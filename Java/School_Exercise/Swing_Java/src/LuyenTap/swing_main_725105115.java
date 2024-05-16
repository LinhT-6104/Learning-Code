package LuyenTap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class swing_main_725105115 {

	private JFrame frameThongTin;
	private JTextField tfMaHinh;
	private JTextField tfMauSac;
	private JTextField tfChieuDai;
	private JTextField tfChieuRong;
	private JTextField tfSoLuong;
	private JRadioButton radCon, radKhong;
	private ArrayList<HinhChuNhat> listHCN = new ArrayList<HinhChuNhat>();
	private QuanLyKhoHang qlkh = new QuanLyKhoHang();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing_main_725105115 window = new swing_main_725105115();
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
	public swing_main_725105115() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameThongTin = new JFrame();
		frameThongTin.setBounds(100, 100, 884, 439);
		frameThongTin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameThongTin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập thông tin hình chữ nhật");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 10, 876, 25);
		frameThongTin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hình");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(20, 60, 103, 21);
		frameThongTin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Màu sắc");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(20, 100, 103, 21);
		frameThongTin.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chiều dài");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(20, 140, 103, 21);
		frameThongTin.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Chiều rộng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1.setBounds(20, 180, 103, 21);
		frameThongTin.getContentPane().add(lblNewLabel_1_2_1);
		
		tfMaHinh = new JTextField();
		tfMaHinh.setBounds(133, 60, 250, 21);
		frameThongTin.getContentPane().add(tfMaHinh);
		tfMaHinh.setColumns(10);
		
		tfMauSac = new JTextField();
		tfMauSac.setColumns(10);
		tfMauSac.setBounds(133, 100, 250, 21);
		frameThongTin.getContentPane().add(tfMauSac);
		
		tfChieuDai = new JTextField();
		tfChieuDai.setColumns(10);
		tfChieuDai.setBounds(133, 140, 250, 21);
		frameThongTin.getContentPane().add(tfChieuDai);
		
		tfChieuRong = new JTextField();
		tfChieuRong.setColumns(10);
		tfChieuRong.setBounds(133, 180, 250, 21);
		frameThongTin.getContentPane().add(tfChieuRong);
		
		tfSoLuong = new JTextField();
		tfSoLuong.setColumns(10);
		tfSoLuong.setBounds(579, 100, 250, 21);
		frameThongTin.getContentPane().add(tfSoLuong);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số lượng");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(466, 100, 103, 21);
		frameThongTin.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Hàng trong kho");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(466, 60, 363, 21);
		frameThongTin.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Còn hàng");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3_1.setBackground(Color.WHITE);
		lblNewLabel_1_3_1.setBounds(466, 140, 103, 21);
		frameThongTin.getContentPane().add(lblNewLabel_1_3_1);
		
		radCon = new JRadioButton("Còn");
		buttonGroup.add(radCon);
		radCon.setForeground(Color.BLUE);
		radCon.setFont(new Font("Tahoma", Font.BOLD, 17));
		radCon.setBounds(579, 140, 57, 21);
		frameThongTin.getContentPane().add(radCon);
		
		radKhong = new JRadioButton("Không");
		buttonGroup.add(radKhong);
		radKhong.setForeground(Color.RED);
		radKhong.setFont(new Font("Tahoma", Font.BOLD, 17));
		radKhong.setBounds(638, 140, 103, 21);
		frameThongTin.getContentPane().add(radKhong);
		
		JButton btnThemHCN = new JButton("Thêm HCN");
		btnThemHCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maHinh = tfMaHinh.getText();
				String mauSac = tfMauSac.getText();
				String strChieuDai = tfChieuDai.getText();
				String strChieuRong = tfChieuRong.getText();
				String strSoLuong = tfSoLuong.getText();
				if (maHinh.length() > 0 && mauSac.length() > 0 && strChieuDai.length() > 0 &&
					strChieuRong.length() > 0 && strSoLuong.length() > 0 && (radCon.isSelected()
					|| radKhong.isSelected())) {
					double chieuDai = Double.parseDouble(strChieuDai);
					double chieuRong = Double.parseDouble(strChieuRong);
					int soLuong = Integer.parseInt(strSoLuong);
					String conHang;
					if (radCon.isSelected() ) {
						conHang = "Còn";
					} else {
						conHang = "Không";
					}
					
					listHCN.add(new HinhChuNhat(maHinh, mauSac, chieuDai, chieuRong, new KhoHang(soLuong, radCon.isSelected())));
					
					JOptionPane.showMessageDialog(btnThemHCN, "Mã hình: " + maHinh + " Màu sắc: " + mauSac + 
							"\nChiều dài: " + chieuDai + " Chiều rộng: " + chieuRong +
							"\nSố lượng: " + soLuong + " Còn hàng: " + 
							conHang, "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(btnThemHCN, "Nhập đầy đủ thông tin!", "Hệ thống",
								JOptionPane.ERROR_MESSAGE);
				}
 			}
		});
		btnThemHCN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThemHCN.setBounds(57, 285, 183, 30);
		frameThongTin.getContentPane().add(btnThemHCN);
		
		JButton btnLuuDuLieu = new JButton("Lưu dữ liệu");
		btnLuuDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(btnLuuDuLieu, "Xác nhận lưu dữ liệu!", "Hệ thống",
											 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					qlkh.ghiFile(listHCN);
					JOptionPane.showMessageDialog(btnLuuDuLieu, "Lưu dữ liệu vào file hct.txt thành công!", 
											 "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLuuDuLieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLuuDuLieu.setBounds(330, 285, 183, 30);
		frameThongTin.getContentPane().add(btnLuuDuLieu);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(btnThoat, "Xác nhận đóng!", "Hệ thống",
											  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(1);
				} else {
					frameThongTin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThoat.setBounds(616, 285, 183, 30);
		frameThongTin.getContentPane().add(btnThoat);
	}
}
