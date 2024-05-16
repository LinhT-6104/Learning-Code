package BaiTapTongHop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import BaiTapTongHop.QuanLyKhoHang;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HinhChuNhat_Swing {

	private JFrame frameThongTin;
	private JTextField tfMaHinh;
	private JTextField tfMauSac;
	private JTextField tfChieuDai;
	private JTextField tfChieuRong;
	private JTextField tfSoLuong;
	private JRadioButton radCon, radHet;
	private JButton btnThemHCN, btnLuuDuLieu, btnThoat;
	private QuanLyKhoHang qlkh = new QuanLyKhoHang();
	private ArrayList<HinhChuNhat> listHCN = new ArrayList<HinhChuNhat>();
	private final ButtonGroup bgConHang = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HinhChuNhat_Swing window = new HinhChuNhat_Swing();
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
	public HinhChuNhat_Swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameThongTin = new JFrame();
		frameThongTin.getContentPane().setBackground(Color.WHITE);
		frameThongTin.getContentPane().setForeground(Color.BLACK);
		frameThongTin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
		});
		frameThongTin.setBounds(100, 100, 835, 461);
		frameThongTin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameThongTin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập thông tin hình chữ nhật");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 803, 40);
		frameThongTin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hình");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 120, 117, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Màu sắc");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(40, 170, 117, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chiều dài");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(40, 220, 117, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Chiều rộng");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(450, 120, 117, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_3);
		
		tfMaHinh = new JTextField();
		tfMaHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		tfMaHinh.setBounds(170, 120, 213, 20);
		frameThongTin.getContentPane().add(tfMaHinh);
		tfMaHinh.setColumns(10);
		
		tfMauSac = new JTextField();
		tfMauSac.setColumns(10);
		tfMauSac.setBounds(170, 170, 213, 20);
		frameThongTin.getContentPane().add(tfMauSac);
		
		tfChieuDai = new JTextField();
		tfChieuDai.setColumns(10);
		tfChieuDai.setBounds(170, 220, 213, 20);
		frameThongTin.getContentPane().add(tfChieuDai);
		
		tfChieuRong = new JTextField();
		tfChieuRong.setColumns(10);
		tfChieuRong.setBounds(570, 170, 213, 20);
		frameThongTin.getContentPane().add(tfChieuRong);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số lượng");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(450, 170, 91, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_4);
		
		tfSoLuong = new JTextField();
		tfSoLuong.setColumns(10);
		tfSoLuong.setBounds(570, 120, 213, 20);
		frameThongTin.getContentPane().add(tfSoLuong);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Còn hàng");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(450, 220, 95, 20);
		frameThongTin.getContentPane().add(lblNewLabel_1_4_1);
		
		radCon = new JRadioButton("Còn");
		bgConHang.add(radCon);
		radCon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radCon.setBounds(570, 220, 57, 21);
		frameThongTin.getContentPane().add(radCon);
		
		radHet = new JRadioButton("Hết");
		bgConHang.add(radHet);
		radHet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radHet.setBounds(629, 220, 57, 21);
		frameThongTin.getContentPane().add(radHet);
		
		btnThemHCN = new JButton("Thêm hình chữ nhật");
		btnThemHCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maHinh = tfMaHinh.getText();
				String mauSac = tfMauSac.getText();
				String strChieuDai = tfChieuDai.getText();
				String strChieuRong = tfChieuRong.getText();
				String strSoLuong = tfSoLuong.getText();
				String strConHang = "Còn";
				if (radHet.isSelected()) {
					strConHang = "Hết";
				}
				if (maHinh.length()>0 && mauSac.length()>0 && strChieuDai.length()>0 &&
					strChieuRong.length()>0 && strSoLuong.length()>0 && 
					(radHet.isSelected() || radCon.isSelected())) {
					float chieuDai = Float.parseFloat(strChieuDai);
					float chieuRong = Float.parseFloat(strChieuRong);
					int soLuong = Integer.parseInt(strSoLuong);
					boolean conHang = true;
					if (radHet.isSelected()) {
						conHang = false;
					}
					
					listHCN.add(new HinhChuNhat(maHinh, mauSac, chieuDai, chieuRong, new KhoHang(soLuong, conHang)));
					
					String result = "Mã hình: " + maHinh + "\n" +
									"Màu sắc: " + mauSac + "\n" +
									"Chiều dài: " + strChieuDai + "\n" +
									"Chiều rộng: " + strChieuRong + "\n" +
									"Số lượng: " + strSoLuong + "\n" +
									"Còn hàng: " + strConHang;
					JOptionPane.showMessageDialog(frameThongTin,
							result, "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frameThongTin, "Nhập đầy đủ thông tin",
							"Hệ thống", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnThemHCN.setBackground(Color.BLUE);
		btnThemHCN.setForeground(SystemColor.controlLtHighlight);
		btnThemHCN.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThemHCN.setBounds(40, 300, 210, 50);
		frameThongTin.getContentPane().add(btnThemHCN);
		
		btnLuuDuLieu = new JButton("Lưu dữ liệu");
		btnLuuDuLieu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int luaChon = JOptionPane.showConfirmDialog(frameThongTin, "Xác nhận lưu?",
		                "Save", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        if (luaChon == JOptionPane.YES_OPTION && listHCN.size() > 0) {
		            qlkh.ghiFile(listHCN);
		            JOptionPane.showMessageDialog(frameThongTin, "Lưu dữ liệu thành công",
		                    "Save", JOptionPane.PLAIN_MESSAGE);
		        } 
		    }
		});

		btnLuuDuLieu.setBackground(Color.ORANGE);
		btnLuuDuLieu.setForeground(SystemColor.controlLtHighlight);
		btnLuuDuLieu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLuuDuLieu.setBounds(303, 300, 210, 50);
		frameThongTin.getContentPane().add(btnLuuDuLieu);
		
		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(frameThongTin,
						"Xác nhận muốn thoát", "Hệ thống", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					frameThongTin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}		
		});
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(SystemColor.controlLtHighlight);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThoat.setBounds(570, 300, 210, 50);
		frameThongTin.getContentPane().add(btnThoat);
		
		JButton btnNewButton = new JButton("HienThiFile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qlkh.inDuLieuFile(qlkh.docFile());
			}
		});
		btnNewButton.setBounds(259, 366, 117, 48);
		frameThongTin.getContentPane().add(btnNewButton);
	}
}
