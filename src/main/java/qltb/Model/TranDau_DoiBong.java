package qltb.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="trandau_doibong")
public class TranDau_DoiBong {
	@EmbeddedId
	private TD_DB_id tddb;
	private int banthang;
	
	public TranDau_DoiBong(TD_DB_id tddb, int banthang) {
		super();
		this.tddb = tddb;
		this.banthang = banthang;
	}
	
	public TranDau_DoiBong() {
		super();
	}
	
	public TD_DB_id getTddb() {
		return tddb;
	}
	
	public void setTddb(TD_DB_id tddb) {
		this.tddb = tddb;
	}
	
	public int getBangthang() {
		return banthang;
	}
	
	public void setBangthang(int banthang) {
		this.banthang = banthang;
	}
	
}
