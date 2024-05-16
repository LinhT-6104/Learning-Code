//Tran_Duc_Linh_725105115
package BaiThi;

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
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;


public class GiaoTrinhApplication {

	private JFrame frameThongTin;
	private JTextField tfTenGiaoTrinh;
	private JTextField tfSoLuong;
	private JTextField tfTenChuyenNghanh;
	private JRadioButton radCoBan, radNangCao;
	private ArrayList<GiaoTrinh> listGiaoTrinh = new ArrayList<GiaoTrinh>();
	private QuanLyGiaoTrinh qlgt = new QuanLyGiaoTrinh();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoTrinhApplication window = new GiaoTrinhApplication();
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
	public GiaoTrinhApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameThongTin = new JFrame();
		frameThongTin.setBounds(100, 100, 832, 380);
		frameThongTin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameThongTin.getContentPane().setLayout(null);
		
		JLabel lblNhpThngTin = new JLabel("Nhập thông tin giáo trình");
		lblNhpThngTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpThngTin.setForeground(Color.RED);
		lblNhpThngTin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNhpThngTin.setBounds(10, 26, 800, 40);
		frameThongTin.getContentPane().add(lblNhpThngTin);
		
		JLabel lblNewLabel_1 = new JLabel("Tên giáo trình");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(27, 120, 130, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loại ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(27, 170, 130, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(410, 170, 130, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_1_1);
		
		tfTenGiaoTrinh = new JTextField();
		tfTenGiaoTrinh.setColumns(10);
		tfTenGiaoTrinh.setBounds(170, 120, 213, 20);
		frameThongTin.getContentPane().add(tfTenGiaoTrinh);
		
		tfSoLuong = new JTextField();
		tfSoLuong.setColumns(10);
		tfSoLuong.setBounds(590, 174, 213, 20);
		frameThongTin.getContentPane().add(tfSoLuong);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên chuyên ngành");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(410, 120, 174, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_2);
		
		tfTenChuyenNghanh = new JTextField();
		tfTenChuyenNghanh.setColumns(10);
		tfTenChuyenNghanh.setBounds(590, 120, 213, 20);
		frameThongTin.getContentPane().add(tfTenChuyenNghanh);
		
		radCoBan = new JRadioButton("Cơ bản");
		buttonGroup.add(radCoBan);
		radCoBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radCoBan.setBounds(170, 170, 83, 21);
		frameThongTin.getContentPane().add(radCoBan);
		
		radNangCao = new JRadioButton("Nâng cao");
		buttonGroup.add(radNangCao);
		radNangCao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radNangCao.setBounds(255, 170, 107, 21);
		frameThongTin.getContentPane().add(radNangCao);
		
		JButton btnThemGiaoTrinh = new JButton("Thêm giáo trình");
		btnThemGiaoTrinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThemGiaoTrinh.setForeground(SystemColor.controlLtHighlight);
		btnThemGiaoTrinh.setBackground(Color.BLUE);
		btnThemGiaoTrinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenGiaoTrinh = tfTenGiaoTrinh.getText();
				String loai;
				if (radCoBan.isSelected()) {
					loai = "Cơ bản";
				} else {
					loai = "Nâng cao";
				}
				String strSoLuong = tfSoLuong.getText();
				String tenChuyenNghanh = tfTenChuyenNghanh.getText();
				
				if (tenGiaoTrinh.length() > 0 && strSoLuong.length() > 0 && tenChuyenNghanh.length() > 0 
						&& (radCoBan.isSelected() || radNangCao.isSelected())) {
					int soLuong = Integer.parseInt(strSoLuong);
					
					String info = "Tên giáo trình: " + tenGiaoTrinh
							+ "\nLoại: " + loai
							+ "\nSố lượng: " + soLuong
							+ "\nTên chuyên nghành: " + tenChuyenNghanh;
					
					JOptionPane.showMessageDialog(btnThemGiaoTrinh, info,
							"Hệ thống", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frameThongTin, "Nhập đầy đủ thông tin giáo trình",
							"Hệ thống", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnThemGiaoTrinh.setBounds(40, 250, 210, 50);
		frameThongTin.getContentPane().add(btnThemGiaoTrinh);
		
		JButton btnLuuDuLieu = new JButton("Lưu dữ liệu");
		btnLuuDuLieu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLuuDuLieu.setBackground(Color.ORANGE);
		btnLuuDuLieu.setForeground(SystemColor.controlLtHighlight);
		btnLuuDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(btnLuuDuLieu, "Xác nhận lưu?",
						"Save", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					qlgt.ghiFile(listGiaoTrinh);
					JOptionPane.showMessageDialog(btnLuuDuLieu, "Lưu dữ liệu thành công!",
							"Save", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLuuDuLieu.setBounds(303, 250, 210, 50);
		frameThongTin.getContentPane().add(btnLuuDuLieu);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(SystemColor.controlLtHighlight);
		btnThoat.setBackground(Color.RED);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(btnThoat,
						"Xác nhận đóng?", "Hệ thống", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					frameThongTin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		btnThoat.setBounds(570, 250, 210, 50);
		frameThongTin.getContentPane().add(btnThoat);
	}
}
