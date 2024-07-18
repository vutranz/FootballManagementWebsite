package qltb.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qltb.Model.User;
import qltb.Repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository repo;
	
	public List<User> listAll() {
		return repo.findAll();
	}
	
	public void save(User e) {
		repo.save(e);
	}
	
	public User get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
