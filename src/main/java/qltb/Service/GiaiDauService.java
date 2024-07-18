package qltb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qltb.Model.GiaiDau;
import qltb.Repository.GiaiDauRepository;

@Service
@Transactional
public class GiaiDauService {

	@Autowired
	private GiaiDauRepository repo;
	
	public List<GiaiDau> listAll() {
		return repo.findAll();
	}
	
	public void save(GiaiDau e) {
		repo.save(e);
	}
	
	public GiaiDau get(String id) {
		return repo.findById(id).get();
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
}
