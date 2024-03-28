package BTTH_OOP_Tuan5;

import java.util.ArrayList;

public class OOP_Bai3 extends Account {
	public static void main(String[] args){
		ArrayList<Account> listAccount = new ArrayList<Account>();
		listAccount.add(new Account(1, "A", 111111));
		listAccount.add(new Account(3, "B", 222222));
		listAccount.add(new Account(2, "C", 333333));
		listAccount.add(new Account(5, "D", 500000));
		listAccount.add(new Account(4, "E", 444444));
		
		QuanLyAccount qla = new QuanLyAccount(listAccount);
		System.out.println(qla);
	}
	
}
