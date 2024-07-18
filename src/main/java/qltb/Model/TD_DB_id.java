package qltb.Model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TD_DB_id implements Serializable{
	private int maTD;
	private int maDB;
	
	public TD_DB_id() {
		super();
	}
	
	public TD_DB_id(int maTD, int maDB) {
		super();
		this.maTD = maTD;
		this.maDB = maDB;
	}
	
	public int getMaTD() {
		return maTD;
	}
	
	public void setMaTD(int maTD) {
		this.maTD = maTD;
	}
	
	public int getMaDB() {
		return maDB;
	}
	
	public void setMaDB(int maDB) {
		this.maDB = maDB;
	}
	
}
