package qltb.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="bangdau_doibong")
public class BangDau_DoiBong {
	@EmbeddedId
	private BD_DB_id gddb;
	private int diem;
	
	public BangDau_DoiBong() {
		super();
	}
	
	public BangDau_DoiBong(BD_DB_id gddb, int diem) {
		super();
		this.gddb = gddb;
		this.diem = diem;
	}
	
	public BD_DB_id getGddb() {
		return gddb;
	}
	
	public void setGddb(BD_DB_id gddb) {
		this.gddb = gddb;
	}
	
	public int getDiem() {
		return diem;
	}
	
	public void setDiem(int diem) {
		this.diem = diem;
	}
}
