package qltb.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import qltb.Model.DoiBong;
import qltb.Model.DoiBong_Diem;
import qltb.Configuration.MyUserDetails;
import qltb.Model.BD_DB_id;
import qltb.Model.BangDau;
import qltb.Model.GiaiDau;
import qltb.Model.TD_DB_id;
import qltb.Model.TranDau;
import qltb.Model.TranDauDetails;
import qltb.Model.TranDau_DoiBong;
import qltb.Model.BangDau_DoiBong;
import qltb.Service.DoiBongService;
import qltb.Service.BDDBService;
import qltb.Service.BangDauService;
import qltb.Service.GiaiDauService;
import qltb.Service.TDDBService;
import qltb.Service.TranDauService;

@Controller
public class QLGDController {
	@Autowired
	private GiaiDauService GDService;
	
	@Autowired
	private DoiBongService DBService;
	
	@Autowired
	private BangDauService BDService;
	
	@Autowired
	private BDDBService BDDBService;
	
	@Autowired
	private TranDauService TDService;
	
	@Autowired
	private TDDBService tddbService;
	
	private int success = 0;
	
	//Tournament management page
	@RequestMapping("admin/quan_ly_giai_dau")
	public String viewQLGD(Model model) {
		List<DoiBong> listDB = DBService.listAll();
		model.addAttribute("listDB", listDB);
		
		List<GiaiDau> listGD = GDService.listAll();
		model.addAttribute("listGD", listGD);
		model.addAttribute("GiaiDau_DoiBong", new GiaiDau());
		isSuccess(model);
		return "GiaiDau";
	}
	
	//Save tournament to database
	@RequestMapping(value = "admin/savegiaidau", method = RequestMethod.POST)
	public String saveGiaiDau(@RequestParam(name = "doibong") Integer[] db,@RequestParam(name = "tengd") String tengd,
			@RequestParam(name = "magd") String magd, Model model) {
		try {
			Collections.shuffle(Arrays.asList(db));
			GiaiDau gd = new GiaiDau(magd,tengd);
			GDService.save(gd);
			xepBangDau(db, magd);
			tranDau_doiBong(magd);
			success=1;
		}catch(Exception e) {
			success=-1;
		}
		return "redirect:/admin/quan_ly_giai_dau";	
	}
	
	//view Group stage
	@RequestMapping("/bangdau/{id}")
	public String viewBangDau(@PathVariable(name = "id") String id, Model model) {
		List<BangDau> listBD = BDService.getByMaGD(id);
	
		//Group A,B,C,D
		List<DoiBong_Diem> A = new ArrayList<DoiBong_Diem>();
		List<DoiBong_Diem> B = new ArrayList<DoiBong_Diem>();
		List<DoiBong_Diem> C = new ArrayList<DoiBong_Diem>();
		List<DoiBong_Diem> D = new ArrayList<DoiBong_Diem>();
		
		//get teams from database and add them to group
		for(BangDau bd : listBD) {
			List<BangDau_DoiBong> list = BDDBService.getByMaBang(bd.getMaBang());
			for(BangDau_DoiBong i : list) {
				DoiBong_Diem d = new DoiBong_Diem(i.getGddb().getId(), bd.getMaBang(), DBService.get(i.getGddb().getId()).getName(), i.getDiem());
				if(bd.getTenBang().equals("Bang A"))
					A.add(d);
				if(bd.getTenBang().equals("Bang B"))
					B.add(d);
				if(bd.getTenBang().equals("Bang C"))
					C.add(d);
				if(bd.getTenBang().equals("Bang D"))
					D.add(d);
			}
		}
		
		//sort team by score
		DoiBong_Diem.sortByScore(A);
		DoiBong_Diem.sortByScore(B);
		DoiBong_Diem.sortByScore(C);
		DoiBong_Diem.sortByScore(D);
		
		//mapping to html file
		model.addAttribute("BangA", A);
		model.addAttribute("BangB", B);
		model.addAttribute("BangC", C);
		model.addAttribute("BangD", D);
		model.addAttribute("bA",A.get(0).getMaBang());
		model.addAttribute("bB",B.get(0).getMaBang());
		model.addAttribute("bC",C.get(0).getMaBang());
		model.addAttribute("bD",D.get(0).getMaBang());
		model.addAttribute("magd", id);
		
		return "BangDau";
	}
	
	//check add and delete action
	private void isSuccess(Model model) {
		if(success==-1)
			model.addAttribute("Message", "Thêm thất bại");
		if(success==1)
			model.addAttribute("Message", "Thêm thành công");
		if(success==-2)
			model.addAttribute("Message", "Xóa thất bại");
		if(success==2)
			model.addAttribute("Message", "Xóa thành công");
		success = 0;
	}
	
	//random team to group stage
	private void xepBangDau(Integer[] db, String maGD) {
		BangDau A = new BangDau("Bang A",maGD);
		BangDau B = new BangDau("Bang B",maGD);
		BangDau C = new BangDau("Bang C",maGD);
		BangDau D = new BangDau("Bang D",maGD);
		
		BDService.save(A);
		BDService.save(B);
		BDService.save(C);
		BDService.save(D);
		
		List<BangDau> listBD = BDService.getByMaGD(maGD);
		for(BangDau bd : listBD) {
			tranDau(bd.getMaBang());
		}

		List<BangDau> list = BDService.listAll();
		int i = 0;
		for(BangDau bd : list) {
			if(bd.getMaGD().equals(maGD)) {
				for(int j = i; j<i+4; j++) {
					BD_DB_id id = new BD_DB_id(bd.getMaBang(),db[j]);
					BangDau_DoiBong bddb = new BangDau_DoiBong(id,0);
					BDDBService.save(bddb);
				}
				i+=4;
			}
		}
	}
	
	//insert into trandau
	private void tranDau(int maBang) {
		for(int i=0;i<6;i++) {
			TDService.save(new TranDau(maBang));
		}
	}
	
	//insert into trandau_doibong
	private void tranDau_doiBong(String magd) {
		List<BangDau> listBD = BDService.getByMaGD(magd);
		for(BangDau bd : listBD) {
			int k=0;
			List<TranDau> listTD = TDService.getByMaBang(bd.getMaBang());
			List<BangDau_DoiBong> listBDDB = BDDBService.getByMaBang(bd.getMaBang());
			for(int i=0;i<listBDDB.size()-1;i++) {
				for(int j=i+1;j<listBDDB.size();j++) {
					TD_DB_id id1 = new TD_DB_id(listTD.get(k).getMaTD(), listBDDB.get(i).getGddb().getId());
					TD_DB_id id2 = new TD_DB_id(listTD.get(k).getMaTD(), listBDDB.get(j).getGddb().getId());
					TranDau_DoiBong tddb1 = new TranDau_DoiBong(id1, -1);
					TranDau_DoiBong tddb2 = new TranDau_DoiBong(id2, -1);
					tddbService.save(tddb1);
					tddbService.save(tddb2);
					k++;
				}
			}
		}
		
	}
	
	//Match page
	@RequestMapping("/trandau/{id}")
	public String viewTranDau(@PathVariable(name = "id") int maBang, Model model) {
		List<TranDau> listTD = TDService.getByMaBang(maBang);
		List<TranDauDetails> list = new ArrayList<TranDauDetails>();
		
		for(TranDau td : listTD) {
			List<TranDau_DoiBong> tddb = tddbService.getByMaTD(td.getMaTD());
			int maD1 = tddb.get(0).getTddb().getMaDB();
			int maD2 = tddb.get(1).getTddb().getMaDB();
			String tend1 = DBService.get(maD1).getName();
			String tend2 = DBService.get(maD2).getName();
			int d1=tddb.get(0).getBangthang();
			int d2=tddb.get(1).getBangthang();
			list.add(new TranDauDetails(td.getMaTD(), maD1, maD2, tend1, tend2,d1 ,d2 ));
		}
		
		model.addAttribute("listTD", list);
		model.addAttribute("mabang", maBang);
		
		//get role
		String role="";
		try {
			MyUserDetails u = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			role = u.getRole();
		}catch(Exception e) {
			;
		}
		
		if(role.equals("ROLE_ADMIN")) 
			return "TranDau";
		model.addAttribute("role", "notAdmin");
		
		return "TranDau";
	}
	
	//save Score to database
	@RequestMapping(value = "admin/saveScore", method = RequestMethod.POST)
	public String saveScore(@RequestParam(name = "bt1") Integer[] bt1, @RequestParam(name = "bt2") Integer[] bt2, 
			@RequestParam(name = "id1") Integer[] id1, @RequestParam(name = "id2") Integer[] id2, 
			@RequestParam(name = "maBD") Integer maBD, @RequestParam(name = "maTD") Integer[] maTD) {
		for(int i=0; i<bt1.length; i++) {
			BDDBService.save(new BangDau_DoiBong(new BD_DB_id(maBD, id1[i]), 0));
			BDDBService.save(new BangDau_DoiBong(new BD_DB_id(maBD, id2[i]), 0));
		}
		for(int i=0; i<bt1.length; i++) {
			if(bt1[i]>-1 && bt2[i]>-1) {
				int d1= BDDBService.get(new BD_DB_id(maBD, id1[i])).getDiem();
				int d2= BDDBService.get(new BD_DB_id(maBD, id2[i])).getDiem();
				if(bt1[i] > bt2[i]) 
					d1+=3;
				else if(bt1[i] < bt2[i]) 
					d2+=3;
				else {
					d1+=1;
					d2+=1;
				}
				BDDBService.save(new BangDau_DoiBong(new BD_DB_id(maBD, id1[i]), d1));
				BDDBService.save(new BangDau_DoiBong(new BD_DB_id(maBD, id2[i]), d2));
				tddbService.save(new TranDau_DoiBong(new TD_DB_id(maTD[i], id1[i]), bt1[i]));
				tddbService.save(new TranDau_DoiBong(new TD_DB_id(maTD[i], id2[i]), bt2[i]));
			}
		}
		
		return "redirect:/bangdau/"+BDService.get(maBD).getMaGD();	
	}
}
