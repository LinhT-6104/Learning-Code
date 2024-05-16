package TheAnh;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_TheAnh {

private static ArrayList<ThietBi> TB = new ArrayList<>();
	
	private static void rq1(int N)
	{
		for (int i = 0; i < N; i++)
		{
			System.out.println("Nhập thông tin thiết bị thứ " + (i + 1));
			ThietBi tb = new ThietBi();
			tb.input();
			TB.add(tb);
		}
		try {
			FileOutputStream fout = new FileOutputStream("thietbi.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(TB);
			out.close();
			fout.close();
			System.out.println("Lưu vào file thành công!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void rq2()
	{
		try {
			FileInputStream fin = new FileInputStream("thietbi.txt");
			ObjectInputStream in = new ObjectInputStream(fin);
			TB = (ArrayList<ThietBi>) in.readObject();
			in.close();
			fin.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Các thiết bị đọc từ file:");
		for (ThietBi i : TB)
		{
			i.output();
		}
	}
	private static void rq3()
	{
		System.out.println("\nTên thiết bị có số lượng lớn hơn 10 và do công ty Samsung sản xuất: ");
		int count = 0;
//		for (ThietBi i : TB)
//		{
//			if (i.getPLTB().getSoLuong() > 10 && i.getTenDN().equalsIgnoreCase("Samsung"))
//			{
//				System.out.println(i.getTenTB() + "\n");
//				count++;
//			}
//		}
		for (int i = 0; i < TB.size(); i++) 
		{
			if (TB.get(i).getPLTB().getSoLuong() > 10 && TB.get(i).getTenDN().equalsIgnoreCase("Samsung"))
			{
				System.out.println(TB.get(i).getTenTB() + "\n");
				count++;
			}
		}
		if (count == 0)
		{
			System.out.println("Không có thiết bị nào có số lượng lớn hơn 10 và do công ty Samsung sản xuất!");
		}
	}
	private static void rq4()
	{
		for (int i = 0; i < TB.size(); i++)
		{
			for (int j = i + 1; j < TB.size(); j++)
			{
				if (TB.get(i).getGia() > TB.get(j).getGia())
				{
					Collections.swap(TB, i, j);
				}
			}
		}
		System.out.println("Danh sách thiết bị sau khi sắp xếp theo chiều không giảm của giá:");
		for (ThietBi i : TB)
		{
			i.output();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng thiết bị: ");
		int N = sc.nextInt();
		rq1(N);
		rq2();
		rq3();
		rq4();
	}

}
