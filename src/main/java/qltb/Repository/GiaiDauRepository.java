package qltb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qltb.Model.GiaiDau;

@Repository
public interface GiaiDauRepository extends JpaRepository<GiaiDau, String> {

}
