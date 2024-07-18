package qltb.Model;

import java.util.List;

public class DoiBong_Diem {
	private int maDB;
	private int maBang;
	private String name;
	private int diem;

	public DoiBong_Diem() {
		super();
	}
	
	public DoiBong_Diem(int maDB, int maBang, String name, int diem) {
		super();
		this.maDB = maDB;
		this.maBang = maBang;
		this.name = name;
		this.diem = diem;
	}
	
	public int getMaDB() {
		return maDB;
	}

	public void setMaDB(int maDB) {
		this.maDB = maDB;
	}

	public int getMaBang() {
		return maBang;
	}

	public void setMaBang(int maBang) {
		this.maBang = maBang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public static void sortByScore(List<DoiBong_Diem> list){
        list.sort((o1, o2) -> o1.getDiem() < o2.getDiem()?1:-1 );
    }
}
