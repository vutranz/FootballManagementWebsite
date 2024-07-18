package qltb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qltb.Model.DoiBong;

@Repository
public interface DoiBongRepository extends JpaRepository<DoiBong, Integer> {

}
