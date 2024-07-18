package qltb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qltb.Model.TranDau;

@Repository
public interface TranDauRepository extends JpaRepository<TranDau, Integer> {
	List<TranDau> findByMaBang(int maBang);
}
