package BTTH_OOP_Tuan5;

public class Certificate {
	private String CertificatedID;
	private String CertificateName;
	private int CertificateRank;
	private String CertificatedDate;
	
	public Certificate() {}
	public Certificate(String certificatedID, String certificateName, int certificateRank, String certificatedDate) {
		super();
		CertificatedID = certificatedID;
		CertificateName = certificateName;
		CertificateRank = certificateRank;
		CertificatedDate = certificatedDate;
	}
	
	// -----------------GETTER | SETTER-----------------
	public String getCertificatedID() {
		return CertificatedID;
	}
	public void setCertificatedID(String certificatedID) {
		CertificatedID = certificatedID;
	}
	public String getCertificateName() {
		return CertificateName;
	}
	public void setCertificateName(String certificateName) {
		CertificateName = certificateName;
	}
	public int getCertificateRank() {
		return CertificateRank;
	}
	public void setCertificateRank(int certificateRank) {
		CertificateRank = certificateRank;
	}
	public String getCertificatedDate() {
		return CertificatedDate;
	}
	public void setCertificatedDate(String certificatedDate) {
		CertificatedDate = certificatedDate;
	}
	
	
}
