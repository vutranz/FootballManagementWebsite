package qltb.Model;

public class TranDauDetails {
	private int maTD;
	private int maD1;
	private int maD2;
	private String tend1;
	private String tend2;
	private int d1;
	private int d2;
	
	public TranDauDetails(int maTD, int maD1, int maD2, String tend1, String tend2, int d1, int d2) {
		super();
		this.maTD = maTD;
		this.maD1 = maD1;
		this.maD2 = maD2;
		this.tend1 = tend1;
		this.tend2 = tend2;
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public int getMaTD() {
		return maTD;
	}
	
	public void setMaTD(int maTD) {
		this.maTD = maTD;
	}
	
	public int getMaD1() {
		return maD1;
	}
	
	public void setMaD1(int maD1) {
		this.maD1 = maD1;
	}
	
	public int getMaD2() {
		return maD2;
	}
	
	public void setMaD2(int maD2) {
		this.maD2 = maD2;
	}
	
	public String getTend1() {
		return tend1;
	}
	
	public void setTend1(String tend1) {
		this.tend1 = tend1;
	}
	
	public String getTend2() {
		
		return tend2;
	}
	public void setTend2(String tend2) {
		this.tend2 = tend2;
	}
	
	public int getD1() {
		return d1;
	}
	
	public void setD1(int d1) {
		this.d1 = d1;
	}
	
	public int getD2() {
		return d2;
	}
	
	public void setD2(int d2) {
		this.d2 = d2;
	}
	
	
}
