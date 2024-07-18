package qltb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qltb.Model.BD_DB_id;
import qltb.Model.BangDau_DoiBong;
import qltb.Repository.BDDBRepository;

@Service
@Transactional
public class BDDBService {

	@Autowired
	private BDDBRepository repo;
	
	public List<BangDau_DoiBong> listAll() {
		return repo.findAll();
	}
	
	public void save(BangDau_DoiBong e) {
		repo.save(e);
	}
	
	public BangDau_DoiBong get(BD_DB_id id) {
		return repo.findById(id).get();
	}
	
	public void delete(BD_DB_id id) {
		repo.deleteById(id);
	}
	
	public List<BangDau_DoiBong> getByMaBang(int maBang) {
		return repo.findByMaBang(maBang);
	}
}
