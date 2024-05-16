package Tuan11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLSV {

	private JFrame frmQunLSinh;
	private JTextField tfMaSV;
	private JTextField tfHoVaTen;
	private JTextField tfNgaySinh;
	private JTextField tfDiemTB;
	private final ButtonGroup btnGroupGioiTinh = new ButtonGroup();
	private JTable tableSinhVien;
	private JButton btnDangXuat;
	private JComboBox cbbKhoa;	
	private JRadioButton radNam, radNu;
	private JCheckBox cbxThuyetTrinh, cbxNgoaiNgu, cbxTheThao, cbxVanNghe;
	private JButton btnThemSV, btnSuaSV, btnXoaSV, btnTimKiem, btnLamMoi;
	private SinhVien sv;
	private ArrayList<SinhVien> listSV;
	private ArrayList<String> listKyNang;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSV window = new QLSV();
					window.frmQunLSinh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QLSV() {
		initialize();
		sv = new SinhVien();
		listSV = new ArrayList<SinhVien>();
		listKyNang = new ArrayList<String>();
	}
	
	public void updateTableSV() {
		Object[][] tableData = new Object[listSV.size()][7];
		DefaultTableModel tableModel = (DefaultTableModel) tableSinhVien.getModel();
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
		for (int i = 0 ; i < listSV.size(); i++) {
			tableData[i][0] = listSV.get(i).getMaSV();
			tableData[i][1] = listSV.get(i).getHoTen();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			tableData[i][2] = dateFormat.format(listSV.get(i).getNgaySinh());
			tableData[i][3] = listSV.get(i).getKhoa();
			tableData[i][4] = listSV.get(i).getDiemTB();
			if (listSV.get(i).isGioiTinh()) {
				tableData[i][5] = "Nam";
			} else {
				tableData[i][5] = "Nữ";
			}
			String kyNang = "";
			for (int k = 0; k < listKyNang.size(); k++) {
				kyNang += listKyNang.get(k) + ";";
			}
			tableData[i][6] = kyNang;
			tableModel.addRow(tableData[i]);
		}
	}

	
	public boolean checkMaSV(String maSV) {	// Có tồn tại: true || không tồn tại: 	false
		for (int i = 0; i < listSV.size(); i++) {
			if (maSV.equals(listSV.get(i).getMaSV())) {
				return true;
			}
		}
		return false;
	}
	
	private void initialize() {
		frmQunLSinh = new JFrame();
		frmQunLSinh.setTitle("Hệ thống quản lý sinh viên");
		frmQunLSinh.setBounds(100, 100, 863, 658);
		frmQunLSinh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQunLSinh.getContentPane().setLayout(null);
		
		BufferedImage bufferedImage = null;
		BufferedImage scaledImage = null;
		try {
			bufferedImage = ImageIO.read(new File("images\\user.jpg"));
			
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.scale(0.2, 0.2);
			
			AffineTransformOp affineTransformOP 
				= new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
			
			scaledImage = affineTransformOP.filter(bufferedImage, scaledImage);
		} catch (Exception e) {
			System.out.println("Có lỗi khi đọc ảnh: " + e.toString());
		}

		JLabel lbAvatar = new JLabel();
		lbAvatar.setIcon(new ImageIcon(scaledImage));
		lbAvatar.setBounds(10, 10, 150, 150);
		frmQunLSinh.getContentPane().add(lbAvatar);
		
		JLabel lblNewLabel_1 = new JLabel("Xin chào, admin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 192, 161, 16);
		frmQunLSinh.getContentPane().add(lblNewLabel_1);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangXuat.setForeground(SystemColor.controlLtHighlight);
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDangXuat.setBackground(Color.MAGENTA);
		btnDangXuat.setBounds(21, 218, 150, 21);
		frmQunLSinh.getContentPane().add(btnDangXuat);
		
		JLabel lblNewLabel_2 = new JLabel("Mã SV");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(185, 35, 84, 19);
		frmQunLSinh.getContentPane().add(lblNewLabel_2);
		
		tfMaSV = new JTextField();
		tfMaSV.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfMaSV.setBounds(340, 35, 165, 19);
		frmQunLSinh.getContentPane().add(tfMaSV);
		tfMaSV.setColumns(10);
		
		tfHoVaTen = new JTextField();
		tfHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfHoVaTen.setColumns(10);
		tfHoVaTen.setBounds(610, 35, 165, 19);
		frmQunLSinh.getContentPane().add(tfHoVaTen);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ và tên");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_1.setBounds(530, 35, 74, 19);
		frmQunLSinh.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Khoa");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_2.setBounds(185, 80, 84, 19);
		frmQunLSinh.getContentPane().add(lblNewLabel_2_2);
		
		tfNgaySinh = new JTextField();
		tfNgaySinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tfNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfNgaySinh.setColumns(10);
		tfNgaySinh.setBounds(340, 125, 165, 19);
		frmQunLSinh.getContentPane().add(tfNgaySinh);
		
		JLabel lblNewLabel_2_3 = new JLabel("Ngày sinh (dd/mm/yyyy)");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_3.setBounds(185, 125, 150, 19);
		frmQunLSinh.getContentPane().add(lblNewLabel_2_3);
		
		cbbKhoa = new JComboBox();
		cbbKhoa.setModel(new DefaultComboBoxModel(new String[] {"CNTT", "Toan Tin", "Hoa Hoc", "Vat Ly", "Ngu Van", "Lich Su", "Dia Ly", "Tieng Anh", "GD Quoc Phong", "GD Dac Biet"}));
		cbbKhoa.setBounds(340, 80, 165, 19);
		frmQunLSinh.getContentPane().add(cbbKhoa);
		
		tfDiemTB = new JTextField();
		tfDiemTB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfDiemTB.setColumns(10);
		tfDiemTB.setBounds(610, 80, 165, 19);
		frmQunLSinh.getContentPane().add(tfDiemTB);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Điểm TB");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_1_1.setBounds(530, 80, 74, 19);
		frmQunLSinh.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Giới tính");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_1_2.setBounds(530, 125, 74, 19);
		frmQunLSinh.getContentPane().add(lblNewLabel_2_1_2);
		
		radNam = new JRadioButton("Nam");
		btnGroupGioiTinh.add(radNam);
		radNam.setForeground(Color.BLUE);
		radNam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		radNam.setBounds(610, 125, 58, 21);
		frmQunLSinh.getContentPane().add(radNam);
		
		radNu = new JRadioButton("Nữ");
		btnGroupGioiTinh.add(radNu);
		radNu.setForeground(Color.MAGENTA);
		radNu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		radNu.setBounds(670, 125, 58, 21);
		frmQunLSinh.getContentPane().add(radNu);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Kỹ năng mềm");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_3_1.setBounds(185, 170, 84, 19);
		frmQunLSinh.getContentPane().add(lblNewLabel_2_3_1);
		
		cbxThuyetTrinh = new JCheckBox("Thuyết trình");
		cbxThuyetTrinh.setForeground(new Color(32, 178, 170));
		cbxThuyetTrinh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		cbxThuyetTrinh.setBounds(275, 175, 100, 21);
		frmQunLSinh.getContentPane().add(cbxThuyetTrinh);
		
		cbxNgoaiNgu = new JCheckBox("Ngoại ngữ");
		cbxNgoaiNgu.setForeground(new Color(32, 178, 170));
		cbxNgoaiNgu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		cbxNgoaiNgu.setBounds(377, 175, 100, 21);
		frmQunLSinh.getContentPane().add(cbxNgoaiNgu);
		
		cbxTheThao = new JCheckBox("Thể thao");
		cbxTheThao.setForeground(new Color(32, 178, 170));
		cbxTheThao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		cbxTheThao.setBounds(479, 175, 100, 21);
		frmQunLSinh.getContentPane().add(cbxTheThao);
		
		cbxVanNghe = new JCheckBox("Văn nghệ");
		cbxVanNghe.setForeground(new Color(32, 178, 170));
		cbxVanNghe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		cbxVanNghe.setBounds(581, 175, 100, 21);
		frmQunLSinh.getContentPane().add(cbxVanNghe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(181, 257, 631, 339);
		frmQunLSinh.getContentPane().add(scrollPane);
		
		tableSinhVien = new JTable();
		scrollPane.setViewportView(tableSinhVien);
		tableSinhVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSinhVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Sinh Vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "Khoa", "\u0110i\u1EC3m TB", "Gi\u1EDBi t\u00EDnh", "K\u1EF9 n\u0103ng m\u1EC1m"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Float.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		btnThemSV = new JButton("Thêm SV");
		btnThemSV.setForeground(new Color(240, 248, 255));
		btnThemSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maSV = tfMaSV.getText().trim();
					String hoVaTen = tfHoVaTen.getText().trim();
					String khoa = String.valueOf(cbbKhoa.getSelectedItem());
					String strDiemTB = tfDiemTB.getText().trim();
					String ngaySinh = tfNgaySinh.getText().trim();
					
					boolean gioiTinh = false; // Nam: true || Nu: false;
					if (radNam.isSelected()) {
						gioiTinh = true;
					}
					
					listKyNang = new ArrayList<String>();
					if (cbxThuyetTrinh.isSelected()) listKyNang.add(cbxThuyetTrinh.getText());
					if (cbxNgoaiNgu.isSelected()) listKyNang.add(cbxNgoaiNgu.getText());
					if (cbxTheThao.isSelected()) listKyNang.add(cbxTheThao.getText());
					if (cbxVanNghe.isSelected()) listKyNang.add(cbxVanNghe.getText());
					
					// Mai tiếp tục
					if (maSV.length() > 0 && hoVaTen.length() > 0 && khoa.length() > 0 && strDiemTB.length() > 0
							&& ngaySinh.length() > 0 && listKyNang.size() > 0) {
						if (!checkMaSV(maSV)) {
							float diemTB = Float.parseFloat(strDiemTB);
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
							Date NgaySinh = dateFormat.parse(ngaySinh);
							sv = new SinhVien(maSV, hoVaTen, NgaySinh, khoa, diemTB, gioiTinh, listKyNang);
							listSV.add(sv);
							
							// Cập nhật bảng SinhVien
							updateTableSV();
							JOptionPane.showMessageDialog(btnThemSV, "Đã thêm sinh viên " + maSV + "!", "Thêm SV", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(btnThemSV, "Mã SV " + maSV + " đã tồn tại", "Thêm SV", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(btnThemSV, "Vui lòng nhập đủ thông tin SV", "Thêm SV", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					System.out.println("Có lỗi xảy ra " + ex);
					JOptionPane.showMessageDialog(btnThemSV, "Có lỗi xảy ra " + ex, "Thêm SV", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnThemSV.setBackground(new Color(30, 144, 255));
		btnThemSV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemSV.setBounds(180, 215, 90, 30);
		frmQunLSinh.getContentPane().add(btnThemSV);
		
		btnSuaSV = new JButton("Sửa SV");
		btnSuaSV.setForeground(new Color(240, 255, 255));
		btnSuaSV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuaSV.setBackground(new Color(30, 144, 255));
		btnSuaSV.setBounds(300, 215, 90, 30);
		frmQunLSinh.getContentPane().add(btnSuaSV);
		
		btnXoaSV = new JButton("Xóa SV");
		btnXoaSV.setForeground(new Color(240, 248, 255));
		btnXoaSV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaSV.setBackground(new Color(255, 0, 0));
		btnXoaSV.setBounds(420, 215, 90, 30);
		frmQunLSinh.getContentPane().add(btnXoaSV);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(new Color(240, 255, 255));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLamMoi.setBackground(new Color(50, 205, 50));
		btnLamMoi.setBounds(540, 215, 90, 30);
		frmQunLSinh.getContentPane().add(btnLamMoi);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(new Color(240, 255, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiem.setBackground(new Color(30, 144, 255));
		btnTimKiem.setBounds(660, 215, 90, 30);
		frmQunLSinh.getContentPane().add(btnTimKiem);
	}
}
