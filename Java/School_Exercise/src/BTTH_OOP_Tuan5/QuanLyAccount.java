package BTTH_OOP_Tuan5;

import java.util.ArrayList;

public class QuanLyAccount {
	private ArrayList<Account> listAccount;
	
	public QuanLyAccount() {
		this.listAccount = new ArrayList<Account>();
	}

	public QuanLyAccount(ArrayList<Account> listAccount) {
		this.listAccount = listAccount;
	}
	
	public ArrayList<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(ArrayList<Account> listAccount) {
		this.listAccount = listAccount;
	}

}
