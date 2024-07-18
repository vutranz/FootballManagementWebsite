package qltb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qltb.Model.DoiBong;
import qltb.Repository.DoiBongRepository;

@Service
@Transactional
public class DoiBongService {

	@Autowired
	private DoiBongRepository repo;
	
	public List<DoiBong> listAll() {
		return repo.findAll();
	}
	
	public void save(DoiBong e) {
		repo.save(e);
	}
	
	public DoiBong get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
