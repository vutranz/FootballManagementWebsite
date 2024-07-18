package qltb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qltb.Model.BangDau;
import qltb.Repository.BangDauRepository;

@Service
@Transactional
public class BangDauService {

	@Autowired
	private BangDauRepository repo;
	
	public List<BangDau> listAll() {
		return repo.findAll();
	}
	
	public void save(BangDau e) {
		repo.save(e);
	}
	
	public BangDau get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public List<BangDau> getByMaGD(String maGD) {
		return repo.findByMaGD(maGD);
	}
}
