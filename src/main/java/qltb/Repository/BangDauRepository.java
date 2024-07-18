package qltb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qltb.Model.BangDau;
@Repository
public interface BangDauRepository extends JpaRepository<BangDau, Integer> {
	List<BangDau> findByMaGD(String maGD);
}
