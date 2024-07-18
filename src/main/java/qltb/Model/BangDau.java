package qltb.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bangdau")
public class BangDau {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maBang;
	@Column(name = "tenBang")
	private String tenBang;
	@Column(name = "maGD")
	private String maGD;
	
	public BangDau() {
		super();
	}
	
	public BangDau(String tenBang, String maGD) {
		super();
		this.tenBang = tenBang;
		this.maGD = maGD;
	}
	
	public int getMaBang() {
		return maBang;
	}
	
	public void setMaBang(int maBang) {
		this.maBang = maBang;
	}
	
	public String getTenBang() {
		return tenBang;
	}
	
	public void setTenBang(String tenBang) {
		this.tenBang = tenBang;
	}
	
	public String getMaGD() {
		return maGD;
	}
	
	public void setMaGD(String maGD) {
		this.maGD = maGD;
	}
}
