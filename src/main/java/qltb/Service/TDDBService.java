package qltb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qltb.Model.TD_DB_id;
import qltb.Model.TranDau_DoiBong;
import qltb.Repository.TDDBRepository;

@Service
@Transactional
public class TDDBService {

	@Autowired
	private TDDBRepository repo;
	
	public List<TranDau_DoiBong> listAll() {
		return repo.findAll();
	}
	
	public void save(TranDau_DoiBong e) {
		repo.save(e);
	}
	
	public TranDau_DoiBong get(TD_DB_id id) {
		return repo.findById(id).get();
	}
	
	public void delete(TD_DB_id id) {
		repo.deleteById(id);
	}
	
	public List<TranDau_DoiBong> getByMaTD(int maTD) {
		return repo.findByMaTD(maTD);
	}
}
