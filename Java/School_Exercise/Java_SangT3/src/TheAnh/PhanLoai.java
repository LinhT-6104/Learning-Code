package TheAnh;

public class PhanLoai {
	private boolean TBDT;
	private int SoLuong;
	
	public PhanLoai()
	{
		SoLuong = 0;
	}
	public PhanLoai(boolean tBDT, int soLuong) {
		super();
		TBDT = tBDT;
		SoLuong = soLuong;
	}
	public boolean isTBDT() {
		return TBDT;
	}
	public void setTBDT(boolean tBDT) {
		TBDT = tBDT;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	@Override
	public String toString() {
		return "PhanLoai [TBDT=" + TBDT + ", SoLuong=" + SoLuong + "]";
	}

}
