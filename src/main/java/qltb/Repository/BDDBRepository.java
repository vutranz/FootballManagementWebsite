package qltb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import qltb.Model.BD_DB_id;
import qltb.Model.BangDau_DoiBong;

@Repository
public interface BDDBRepository extends JpaRepository<BangDau_DoiBong, BD_DB_id> {
	@Query(value = "SELECT * FROM bangdau_doibong i where i.ma_bang = :ma_bang", nativeQuery = true)
	List<BangDau_DoiBong> findByMaBang(@Param("ma_bang") int maBang);
}
