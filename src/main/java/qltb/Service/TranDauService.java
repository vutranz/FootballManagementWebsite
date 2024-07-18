package qltb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qltb.Model.BangDau;
import qltb.Model.TranDau;
import qltb.Repository.TranDauRepository;

@Service
@Transactional
public class TranDauService {

	@Autowired
	private TranDauRepository repo;
	
	public List<TranDau> listAll() {
		return repo.findAll();
	}
	
	public void save(TranDau e) {
		repo.save(e);
	}
	
	public TranDau get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public List<TranDau> getByMaBang(int maBang) {
		return repo.findByMaBang(maBang);
	}
}
