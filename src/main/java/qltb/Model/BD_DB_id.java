package qltb.Model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BD_DB_id implements Serializable{
	private int maBang;
	private int id;
	
	public BD_DB_id() {
		super();
	}
	
	public BD_DB_id(int maBang, int id) {
		super();
		this.maBang = maBang;
		this.id = id;
	}
	
	public int getMaBang() {
		return maBang;
	}
	
	public void setMaBang(int maBang) {
		this.maBang = maBang;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
