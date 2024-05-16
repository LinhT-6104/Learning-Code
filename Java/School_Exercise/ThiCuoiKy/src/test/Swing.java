package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

//Họ tên: Trần Đức Linh
//Mã SV: 725105115

public class Swing {

	private JFrame frameThongTin;
	private JTextField tfMaSV;
	private JTextField tfHoTen;
	private JTextField tfDiemGK;
	private JTextField tfDiemCK;
	private ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
					window.frameThongTin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameThongTin = new JFrame();
		frameThongTin.setBounds(100, 100, 834, 460);
		frameThongTin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameThongTin.getContentPane().setLayout(null);
		
		JLabel lblNhpThngTin = new JLabel("Nhập thông tin");
		lblNhpThngTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpThngTin.setForeground(Color.RED);
		lblNhpThngTin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNhpThngTin.setBounds(10, 26, 800, 40);
		frameThongTin.getContentPane().add(lblNhpThngTin);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sinh viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 120, 131, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(40, 170, 117, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(40, 220, 117, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_1_1);
		
		tfMaSV = new JTextField();
		tfMaSV.setColumns(10);
		tfMaSV.setBounds(170, 120, 213, 20);
		frameThongTin.getContentPane().add(tfMaSV);
		
		tfHoTen = new JTextField();
		tfHoTen.setColumns(10);
		tfHoTen.setBounds(170, 170, 213, 20);
		frameThongTin.getContentPane().add(tfHoTen);
		
		JLabel lblNewLabel_1_2 = new JLabel("Điểm giữa kì");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(436, 120, 131, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Điểm cuối kì");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(436, 170, 117, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_3);
		
		tfDiemGK = new JTextField();
		tfDiemGK.setColumns(10);
		tfDiemGK.setBounds(570, 120, 213, 20);
		frameThongTin.getContentPane().add(tfDiemGK);
		
		tfDiemCK = new JTextField();
		tfDiemCK.setColumns(10);
		tfDiemCK.setBounds(570, 170, 213, 20);
		frameThongTin.getContentPane().add(tfDiemCK);
		
		JRadioButton radNam = new JRadioButton("nam");
		buttonGroup.add(radNam);
		radNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radNam.setBounds(170, 220, 65, 21);
		frameThongTin.getContentPane().add(radNam);
		
		JRadioButton radNu = new JRadioButton("nữ");
		buttonGroup.add(radNu);
		radNu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radNu.setBounds(237, 220, 65, 21);
		frameThongTin.getContentPane().add(radNu);
		
		JButton btnThemSinhVien = new JButton("Thêm sinh viên");
		btnThemSinhVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThemSinhVien.setForeground(SystemColor.controlLtHighlight);
		btnThemSinhVien.setBackground(Color.BLUE);
		btnThemSinhVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSV = tfMaSV.getText();
				String hoTen = tfMaSV.getText();
				String gioiTinh;
				if (radNu.isSelected()) {
					gioiTinh = "Nữ";
				} else {
					gioiTinh = "Nam";
				}
				String strDiemGK = tfDiemGK.getText().trim();
				String strDiemCK = tfDiemCK.getText().trim();
				
				if (maSV.length() > 0 && hoTen.length() > 0 
						&& (radNam.isSelected() || radNu.isSelected() 
						&& strDiemGK.length() > 0 && strDiemCK.length() > 0) ) {
					int diemGK = Integer.parseInt(strDiemGK);
					int diemCK = Integer.parseInt(strDiemCK);
					double diemTB = (diemGK*0.4 + diemCK*0.6);
					
					listSV.add(new SinhVien(hoTen, gioiTinh, maSV, new DiemSo(diemGK, diemCK)));
					
					JOptionPane.showMessageDialog(btnThemSinhVien,
							"Mã sinh viên: " + maSV + "\nHọ tên: " + hoTen + "\nGiới tính: " + gioiTinh + 
							"\nĐiểm giữa kì: " + diemGK + "\nĐiểm cuối kì: " + diemCK + "\nĐiểm trung bình: " + diemTB,
							"Hệ thống", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(btnThemSinhVien, "Nhập đầy đủ thông tin", "Hệ thống", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnThemSinhVien.setBounds(40, 300, 210, 50);
		frameThongTin.getContentPane().add(btnThemSinhVien);
		
		JButton btnLuuDuLieu = new JButton("Lưu dữ liệu");
		btnLuuDuLieu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLuuDuLieu.setBackground(Color.ORANGE);
		btnLuuDuLieu.setForeground(SystemColor.controlLtHighlight);
		btnLuuDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(btnLuuDuLieu, "Xác nhận lưu dữ liệu!",
						"Hệ thống", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					File file = new File("D:\\sinhvien.data");
					FileOutputStream fileOutputStream = null;
					ObjectOutputStream objectOuputStream = null;
					try {
						fileOutputStream = new FileOutputStream(file);
						objectOuputStream = new ObjectOutputStream(fileOutputStream);
						
						objectOuputStream.writeObject(listSV);
						
						objectOuputStream.close();
						fileOutputStream.close();
						
						JOptionPane.showMessageDialog(btnLuuDuLieu, "Dữ liệu ghi vào file " + file.getAbsolutePath() + " thành công!");
					} catch (Exception e1) {
						System.err.println("Có lỗi xảy ra");
						e1.printStackTrace();
					}
				}
			}
		});
		btnLuuDuLieu.setBounds(303, 300, 210, 50);
		frameThongTin.getContentPane().add(btnLuuDuLieu);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(SystemColor.controlLtHighlight);
		btnThoat.setBackground(Color.RED);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(btnLuuDuLieu, "Xác nhận đóng!",
						"Hệ thống", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(1);
				} else {
					frameThongTin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		btnThoat.setBounds(570, 300, 210, 50);
		frameThongTin.getContentPane().add(btnThoat);
	}
}
