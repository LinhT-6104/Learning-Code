package Swing;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLSVWindow {

	private JFrame frameQLSV;
	private JTextField tfMaSV;
	private JTextField tfNgaySinh;
	private JTextField tfHoVaTen;
	private JTextField tfDiemTB;
	private final ButtonGroup btnGroupGioiTinh = new ButtonGroup();
	private JTable tableSinhVien;	
	private JComboBox cbbKhoa;
	private JRadioButton radNam, radNu;
	private JCheckBox cbxThuyetTrinh, cbxNgoaiNgu, cbxTheThao, cbxVanNghe;
	private JButton btnThemSV, btnSuaSV, btnXoaSV, btnLamMoi, btnTimKiem;
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
					QLSVWindow window = new QLSVWindow();
					window.frameQLSV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QLSVWindow() {
		initialize();
		sv = new SinhVien();
		listSV = new ArrayList<SinhVien>();
		listKyNang = new ArrayList<String>();
	}
	
	public void updateTableSV() {
		Object[][] tableData= new Object[listSV.size()][7];
		DefaultTableModel tableModel = (DefaultTableModel)tableSinhVien.getModel();
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
		for (int i = 0; i < listSV.size(); i++) {
			tableData[i][0] = listSV.get(i).getMaSV();
			tableData[i][1] = listSV.get(i).getHoVaTen();
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
				kyNang += listKyNang.get(k) + "";
			}
			tableData[i][6] = kyNang;
			tableModel.addRow(tableData[i]);
		}
	}

	public boolean checkMaSV(String maSV) {	// Co ton tai: true || Khong ton tai: false
		for (int i = 0; i < listSV.size(); i++) {
			if (maSV.equals(listSV.get(i).getMaSV())) {
				return true;
			}
		}
		return false;
	}
	
	private void initialize() {
		frameQLSV = new JFrame();
		frameQLSV.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameQLSV.setTitle("Hệ thống quản lý sinh viên");
		frameQLSV.setBounds(100, 100, 861, 569);
		frameQLSV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameQLSV.getContentPane().setLayout(null);
		
		BufferedImage bufferedImage = null;
		BufferedImage scaledImage = null;
		try {
			bufferedImage = ImageIO.read(new File("images\\user.jpg"));
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.scale(0.24, 0.24);
			AffineTransformOp affineTransformOP = 
					new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
			scaledImage = affineTransformOP.filter(bufferedImage, scaledImage);
		} catch (Exception e) {
			System.out.println("Có lỗi khi đọc ảnh!");;
		}
		
		JLabel lbAvatar = new JLabel();
		lbAvatar.setIcon(new ImageIcon(scaledImage));
		lbAvatar.setBounds(10, 10, 150, 150);
		frameQLSV.getContentPane().add(lbAvatar);
		
		JLabel lblNewLabel_1 = new JLabel("Xin chào, admin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 163, 128, 20);
		frameQLSV.getContentPane().add(lblNewLabel_1);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangXuat.setBackground(Color.MAGENTA);
		btnDangXuat.setForeground(SystemColor.controlLtHighlight);
		btnDangXuat.setBounds(10, 200, 128, 25);
		frameQLSV.getContentPane().add(btnDangXuat);
		
		JLabel lblNewLabel = new JLabel("Mã SV");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(160, 30, 100, 20);
		frameQLSV.getContentPane().add(lblNewLabel);
		
		JLabel lblKhoa = new JLabel("Khoa");
		lblKhoa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblKhoa.setBounds(160, 80, 100, 20);
		frameQLSV.getContentPane().add(lblKhoa);
		
		JLabel lblNgySinhddmmyyyy = new JLabel("Ngày sinh (dd/mm/yyyy)");
		lblNgySinhddmmyyyy.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNgySinhddmmyyyy.setBounds(160, 130, 159, 20);
		frameQLSV.getContentPane().add(lblNgySinhddmmyyyy);
		
		JLabel lblNewLabel_3_1 = new JLabel("Kỹ năng mềm");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3_1.setBounds(160, 180, 200, 20);
		frameQLSV.getContentPane().add(lblNewLabel_3_1);
		
		tfMaSV = new JTextField();
		tfMaSV.setBounds(330, 30, 200, 20);
		frameQLSV.getContentPane().add(tfMaSV);
		tfMaSV.setColumns(10);
		
		tfNgaySinh = new JTextField();
		tfNgaySinh.setColumns(10);
		tfNgaySinh.setBounds(330, 130, 200, 20);
		frameQLSV.getContentPane().add(tfNgaySinh);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblHVTn.setBounds(560, 30, 60, 20);
		frameQLSV.getContentPane().add(lblHVTn);
		
		JLabel lblNewLabel_2_1 = new JLabel("Điểm TB");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2_1.setBounds(560, 80, 60, 20);
		frameQLSV.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Giới tính");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2_2.setBounds(560, 130, 60, 20);
		frameQLSV.getContentPane().add(lblNewLabel_2_2);
		
		cbbKhoa = new JComboBox();
		cbbKhoa.setModel(new DefaultComboBoxModel(new String[] {"CNTT", "Toan Tin", "Hoa Hoc", "Vat Ly", "Ngu Van", "Lich Su", "Dia Ly", "Tieng Anh", "GD Quoc Phong", "GD Dac Biet"}));
		cbbKhoa.setBounds(330, 80, 200, 20);
		frameQLSV.getContentPane().add(cbbKhoa);
		
		tfHoVaTen = new JTextField();
		tfHoVaTen.setColumns(10);
		tfHoVaTen.setBounds(641, 32, 184, 20);
		frameQLSV.getContentPane().add(tfHoVaTen);
		
		tfDiemTB = new JTextField();
		tfDiemTB.setColumns(10);
		tfDiemTB.setBounds(641, 80, 184, 20);
		frameQLSV.getContentPane().add(tfDiemTB);
		
		radNam = new JRadioButton("Nam");
		btnGroupGioiTinh.add(radNam);
		radNam.setFont(new Font("Tahoma", Font.BOLD, 12));
		radNam.setForeground(Color.BLUE);
		radNam.setBounds(628, 130, 52, 21);
		frameQLSV.getContentPane().add(radNam);
		
		radNu = new JRadioButton("Nữ");
		btnGroupGioiTinh.add(radNu);
		radNu.setForeground(Color.MAGENTA);
		radNu.setFont(new Font("Tahoma", Font.BOLD, 12));
		radNu.setBounds(696, 131, 52, 21);
		frameQLSV.getContentPane().add(radNu);
		
		cbxThuyetTrinh = new JCheckBox("Thuyết trình");
		cbxThuyetTrinh.setForeground(new Color(0, 153, 0));
		cbxThuyetTrinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxThuyetTrinh.setBounds(267, 203, 93, 21);
		frameQLSV.getContentPane().add(cbxThuyetTrinh);
		
		cbxNgoaiNgu = new JCheckBox("Ngoại ngữ");
		cbxNgoaiNgu.setForeground(new Color(0, 153, 0));
		cbxNgoaiNgu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxNgoaiNgu.setBounds(397, 203, 93, 21);
		frameQLSV.getContentPane().add(cbxNgoaiNgu);
		
		cbxTheThao = new JCheckBox("Thể thao");
		cbxTheThao.setForeground(new Color(0, 153, 0));
		cbxTheThao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxTheThao.setBounds(527, 203, 93, 21);
		frameQLSV.getContentPane().add(cbxTheThao);
		
		cbxVanNghe = new JCheckBox("Văn nghệ");
		cbxVanNghe.setForeground(new Color(0, 153, 0));
		cbxVanNghe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxVanNghe.setBounds(667, 203, 93, 21);
		frameQLSV.getContentPane().add(cbxVanNghe);
		
		btnThemSV = new JButton("Thêm SV");
		btnThemSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maSV = tfMaSV.getText().trim();
					String hoVaTen = tfHoVaTen.getText().trim();
					String khoa = String.valueOf(cbbKhoa.getSelectedItem());
					String strDiemTB = tfDiemTB.getText().trim();
					String strNgaySinh = tfNgaySinh.getText().trim();
					boolean gioiTinh = false;	// nam: true || nu: false
					if (radNam.isSelected()) {
						gioiTinh = true;
					}
					listKyNang = new ArrayList<String>();
					if (cbxThuyetTrinh.isSelected())	listKyNang.add(cbxThuyetTrinh.getText());
					if (cbxNgoaiNgu.isSelected())		listKyNang.add(cbxNgoaiNgu.getText());
					if (cbxTheThao.isSelected())		listKyNang.add(cbxTheThao.getText());
					if (cbxVanNghe.isSelected())		listKyNang.add(cbxVanNghe.getText());
					
					if (maSV.length() > 0 && hoVaTen.length() > 0 && khoa.length() > 0 && strDiemTB.length() > 0 
							&& strNgaySinh.length() > 0 && listKyNang.size() > 0) {
						if (!checkMaSV(maSV)) {
							float diemTB = Float.parseFloat(strDiemTB);
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
							Date ngaySinh = dateFormat.parse(strNgaySinh); 
							sv = new SinhVien(maSV, hoVaTen, khoa, diemTB, ngaySinh, gioiTinh, listKyNang);
							listSV.add(sv);
							// Cập nhật bảng sinh viên
							updateTableSV();
							JOptionPane.showMessageDialog(btnThemSV, "Thêm sv " + maSV + " thành công!",
									"Thêm SV", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(btnThemSV, "Mã SV " + maSV + 
									" đã tồn tại!", "Thêm SV", JOptionPane.ERROR_MESSAGE);
						}
						
						
					} else {
						JOptionPane.showMessageDialog(btnThemSV, "Vui lòng nhập đủ thông tin sv", 
								"Thêm sv", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					System.out.println("Có lỗi xảy ra " + ex);
				}
			}
		});
		btnThemSV.setBackground(new Color(30, 144, 255));
		btnThemSV.setForeground(SystemColor.controlLtHighlight);
		btnThemSV.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemSV.setBounds(160, 245, 90, 30);
		frameQLSV.getContentPane().add(btnThemSV);
		
		btnSuaSV = new JButton("Sửa SV");
		btnSuaSV.setForeground(SystemColor.controlLtHighlight);
		btnSuaSV.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSuaSV.setBackground(new Color(147, 112, 219));
		btnSuaSV.setBounds(285, 245, 90, 30);
		frameQLSV.getContentPane().add(btnSuaSV);
		
		btnXoaSV = new JButton("Xóa SV");
		btnXoaSV.setForeground(SystemColor.controlLtHighlight);
		btnXoaSV.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaSV.setBackground(new Color(255, 0, 0));
		btnXoaSV.setBounds(413, 245, 90, 30);
		frameQLSV.getContentPane().add(btnXoaSV);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(SystemColor.controlLtHighlight);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoi.setBackground(Color.ORANGE);
		btnLamMoi.setBounds(530, 245, 90, 30);
		frameQLSV.getContentPane().add(btnLamMoi);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(SystemColor.controlLtHighlight);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKiem.setBackground(new Color(95, 158, 160));
		btnTimKiem.setBounds(658, 245, 90, 30);
		frameQLSV.getContentPane().add(btnTimKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 285, 665, 221);
		frameQLSV.getContentPane().add(scrollPane);
		
		tableSinhVien = new JTable();
		tableSinhVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSinhVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 sinh vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "Khoa", "\u0110i\u1EC3m TB", "Gi\u1EDBi t\u00EDnh", "K\u1EF9 n\u0103ng m\u1EC1m"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableSinhVien);
	}
}
