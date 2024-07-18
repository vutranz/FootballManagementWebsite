package qltb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import qltb.Model.TD_DB_id;
import qltb.Model.TranDau_DoiBong;

@Repository
public interface TDDBRepository extends JpaRepository<TranDau_DoiBong, TD_DB_id> {
	@Query(value = "SELECT * FROM trandau_doibong i where i.maTD = :maTD", nativeQuery = true)
	List<TranDau_DoiBong> findByMaTD(@Param("maTD") int maTD);
}
