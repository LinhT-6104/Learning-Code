package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyKhoHang {
    private ArrayList<HinhChuNhat> listHCN;

    public QuanLyKhoHang() {
        this.listHCN = new ArrayList<HinhChuNhat>();
    }

    public QuanLyKhoHang(ArrayList<HinhChuNhat> lstHCN) {
        this.listHCN = lstHCN;
    }

    public void nhapDuLieu() throws IOException {	// Câu 1
        System.out.println("\n-------NHẬP DANH SÁCH HÌNH CHỮ NHẬT-------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng hình chữ nhật: ");
        int n = Integer.parseInt(sc.nextLine());

        String dirPath = "D:\\";
        String fileName = "hcn.txt";
        String filePath = dirPath + fileName;

        File directory = new File(dirPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        PrintWriter writer = new PrintWriter(new FileOutputStream(file));

        for (int i = 0; i < n; i++) {
            HinhChuNhat hcn = new HinhChuNhat();
            System.out.println("Nhập hình " + (i+1));
            hcn.nhapDuLieu();
            this.listHCN.add(hcn);

            writer.println(hcn.toString());
        }
        writer.close();
    }

    public void docDuLieu() throws IOException {	// Câu 2
        System.out.println("\nDANH SÁCH HÌNH CHỮ NHẬT-------");
        String dirPath = "D:\\";
        String fileName = "hcn.txt";
        String filePath = dirPath + fileName;

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File không tồn tại.");
            return;
        }

        FileInputStream fiStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fiStream);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
        fiStream.close();
    }
    
    public int demSoLuongDoChoiMauDo() {	// Câu 3
    	int count = 0;
    	for (int i = 0; i < listHCN.size(); i++) {
    		if (listHCN.get(i).layMauSac().equals("Do"))	count++;
    	}
    	return count;
    }
    
    public void timHCNChuVi_Max_Min() {
    	float min = listHCN.get(0).tinhChuVi();
		float max = listHCN.get(0).tinhDienTich(); 
    	for (int i = 1; i < listHCN.size(); i++) {
    		float chuVi = listHCN.get(i).tinhChuVi();
    		float dienTich = listHCN.get(i).tinhDienTich();
    		if (min > chuVi) min = chuVi;
    		if (max < dienTich) max = dienTich;
    	}
    	
    	System.out.println("\n-------HCN có chu vi nhỏ nhất-------");
    	for (int i = 1; i < listHCN.size(); i++) {
    		float chuVi = listHCN.get(i).tinhChuVi();
    		if (min == chuVi) {
    			float chieuDai = listHCN.get(i).layChieuDai();
    			float chieuRong = listHCN.get(i).layChieuRong();
    			System.out.println("Chiều dài: " + chieuDai + " || Chiều rộng: " + chieuRong);
    		}
    	}

    	System.out.println("\n-------HCN có diện tích lớn nhất-------");
    	for (int i = 1; i < listHCN.size(); i++) {
    		float dienTich = listHCN.get(i).tinhDienTich();
    		if (max == dienTich) {
    			float chieuDai = listHCN.get(i).layChieuDai();
    			float chieuRong = listHCN.get(i).layChieuRong();
    			System.out.println("Chiều dài: " + chieuDai + " || Chiều rộng: " + chieuRong);
    		}
    		break;
    	}
    }
    
    public void demDienTichHCN() {
    	ArrayList<Float> dienTichKhacNhau = new ArrayList<>();
        for (int i = 0; i < listHCN.size(); i++) {
            float dienTich = listHCN.get(i).tinhDienTich();
            if (!dienTichKhacNhau.contains(dienTich)) {
                dienTichKhacNhau.add(dienTich);
            }
        }
        
        System.out.println("\nSố lượng diện tích khác nhau: " + dienTichKhacNhau.size());

        // Sắp xếp danh sách diện tích theo thứ tự không tăng
        Collections.sort(dienTichKhacNhau);

        // Hiển thị danh sách diện tích đã sắp xếp
        System.out.println("\nDanh sách diện tích khác nhau:");
        for (float dienTich : dienTichKhacNhau) {
            System.out.println(dienTich);
        }
    }
}
