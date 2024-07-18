package qltb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qltb.Model.User;
@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {

}
