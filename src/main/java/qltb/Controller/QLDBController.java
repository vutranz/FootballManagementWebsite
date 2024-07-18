package qltb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qltb.Model.DoiBong;
import qltb.Service.DoiBongService;

//football team management
@Controller
public class QLDBController {
	@Autowired
	private DoiBongService DBService;
	private int success = 0;
	
	//football team management page
	@RequestMapping("admin/quan_ly_doi_bong")
	public String viewTeamManagementPage(Model model) {
		List<DoiBong> listDB = DBService.listAll();
		model.addAttribute("listDB", listDB);
		model.addAttribute("DoiBong", new DoiBong());
		isSuccess(model);
		return "DoiBong";
	}
	
	//save the team to database
	@RequestMapping(value = "admin/savedoibong", method = RequestMethod.POST)
	public String saveTeam(@ModelAttribute("DoiBong") DoiBong db, Model model) {	
		try {
			DBService.save(db);
		}catch(Exception e){
			return "redirect:/admin/quan_ly_doi_bong";	
		}
		return "redirect:/admin/quan_ly_doi_bong";	
	}
	
	//Delete the team
	@RequestMapping("/admin/delete/{id}")
	public String deleteTeam(@PathVariable(name = "id") int id) {
		try {
			DBService.delete(id);
		}catch(Exception e){
			success = -2;
			return "redirect:/admin/quan_ly_doi_bong";	
		}
		success = 2;
		return "redirect:/admin/quan_ly_doi_bong";	
	}
	
	//check delete?
	private void isSuccess(Model model) {
		if(success==-2)
			model.addAttribute("Message", "Xóa thất bại");
		if(success==2)
			model.addAttribute("Message", "Xóa thành công");
		success = 0;
	}
}
