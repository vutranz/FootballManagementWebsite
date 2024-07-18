package qltb.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trandau")
public class TranDau {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTD;
	private int maBang;
	
	public TranDau() {
		super();
	}
	
	public TranDau(int maTD, int maBang) {
		super();
		this.maTD = maTD;
		this.maBang = maBang;
	}
	
	public TranDau(int maBang) {
		this.maBang = maBang;
	}
	
	public int getMaTD() {
		return maTD;
	}
	
	public void setMaTD(int maTD) {
		this.maTD = maTD;
	}
	
	public int getMaBang() {
		return maBang;
	}
	
	public void setMaBang(int maBang) {
		this.maBang = maBang;
	}
	
}
