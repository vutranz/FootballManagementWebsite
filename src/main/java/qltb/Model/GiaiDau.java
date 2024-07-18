package qltb.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="giaidau")
public class GiaiDau {
	@Id
	private String maGD;
	@Column(name = "ten")
	private String tenGD;
	
	public GiaiDau() {
		super();
	} 
	
	public GiaiDau(String maGD, String tenGD) {
		super();
		this.maGD = maGD;
		this.tenGD = tenGD;
	}
	
	public String getMaGD() {
		return maGD;
	}
	
	public void setMaGD(String maGD) {
		this.maGD = maGD;
	}
	
	public String getTenGD() {
		return tenGD;
	}
	
	public void setTenGD(String tenGD) {
		this.tenGD = tenGD;
	}
	
}
