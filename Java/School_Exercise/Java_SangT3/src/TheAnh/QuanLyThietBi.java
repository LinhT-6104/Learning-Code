package TheAnh;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class QuanLyThietBi extends JFrame {

	private JPanel contentPane;
	private JTextField tfTenTB;
	private JTextField tfMaDN;
	private ThietBi tb = new ThietBi();
	private static ArrayList<ThietBi> TB = new ArrayList<>();
	private JTextField tfTenDN;
	private JTextField tfGia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyThietBi frame = new QuanLyThietBi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void GhiFile()
	{
		try 
		{
			FileOutputStream fout = new FileOutputStream("thietbi.data");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(TB);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public QuanLyThietBi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Nhập thông tin thiết bị");
		lblNewLabel.setForeground(new Color(255, 153, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(270, 0, 381, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lbMaDN = new JLabel("Mã doanh nghiệp");
		lbMaDN.setForeground(new Color(0, 128, 128));
		lbMaDN.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbMaDN.setBounds(45, 360, 165, 30);
		contentPane.add(lbMaDN);
		
		JLabel lbTenDN = new JLabel("Tên doanh nghiệp");
		lbTenDN.setForeground(new Color(0, 128, 128));
		lbTenDN.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbTenDN.setBounds(45, 306, 165, 30);
		contentPane.add(lbTenDN);
		
		JLabel lbTenTB = new JLabel("Tên thiết bị");
		lbTenTB.setForeground(new Color(0, 128, 128));
		lbTenTB.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbTenTB.setBounds(45, 83, 123, 30);
		contentPane.add(lbTenTB);
		
		JLabel lbLoaiTB = new JLabel("Loại thiết bị");
		lbLoaiTB.setForeground(new Color(0, 128, 128));
		lbLoaiTB.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbLoaiTB.setBounds(45, 141, 123, 30);
		contentPane.add(lbLoaiTB);
		
		tfTenTB = new JTextField();
		tfTenTB.setBackground(UIManager.getColor("ToolBar.dockingBackground"));
		tfTenTB.setColumns(10);
		tfTenTB.setBounds(270, 87, 347, 30);
		contentPane.add(tfTenTB);
		
		tfMaDN = new JTextField();
		tfMaDN.setBackground(UIManager.getColor("ToolBar.dockingBackground"));
		tfMaDN.setColumns(10);
		tfMaDN.setBounds(270, 366, 347, 30);
		contentPane.add(tfMaDN);
		
		JLabel lbGia = new JLabel("Giá");
		lbGia.setForeground(new Color(0, 128, 128));
		lbGia.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbGia.setBounds(45, 252, 123, 30);
		contentPane.add(lbGia);
		
		tfTenDN = new JTextField();
		tfTenDN.setColumns(10);
		tfTenDN.setBackground(SystemColor.menu);
		tfTenDN.setBounds(270, 315, 347, 30);
		contentPane.add(tfTenDN);
		
		tfGia = new JTextField();
		tfGia.setColumns(10);
		tfGia.setBackground(SystemColor.menu);
		tfGia.setBounds(270, 256, 347, 30);
		contentPane.add(tfGia);
		
		JLabel lbSoLuong = new JLabel("Số lượng");
		lbSoLuong.setForeground(new Color(0, 128, 128));
		lbSoLuong.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbSoLuong.setBounds(45, 199, 123, 30);
		contentPane.add(lbSoLuong);
		
		JSpinner spSL = new JSpinner();
		spSL.setBackground(new Color(240, 240, 240));
		spSL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spSL.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		spSL.setBounds(270, 201, 104, 30);
		contentPane.add(spSL);
		
		JRadioButton btnDT = new JRadioButton("Điện tử");
		btnDT.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDT.setBounds(270, 141, 123, 30);
		contentPane.add(btnDT);
		
		JRadioButton btnKDT = new JRadioButton("Không phải điện tử");
		btnKDT.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnKDT.setBounds(436, 142, 191, 29);
		contentPane.add(btnKDT);
		
		ButtonGroup check = new ButtonGroup();
		check.add(btnDT);
		check.add(btnKDT);
		
		JButton btnThem = new JButton("Thêm thiết bị");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (tfTenTB.getText().equals("") || tfMaDN.getText().equals("")
						|| tfTenDN.getText().equals("") || (Integer)spSL.getValue() == 0 || check.isSelected(null))
				{
					JOptionPane.showMessageDialog(btnThem, "Bạn cần nhập, chọn đủ thông tin!", "LỖI", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String TenTB = tfTenTB.getText();
					Boolean DienTu = true;
					String DT = "Thiết bị điện tử";
					int SL = (Integer) spSL.getValue();
					double Gia = Double.parseDouble(tfGia.getText());
					String TenDN = tfTenDN.getText();
					String MaDN = tfMaDN.getText();
					
					if (btnKDT.isSelected())
					{
						DienTu = false;
						DT = "Không phải thiết bị điện tử";
					}
					JOptionPane.showMessageDialog(btnThem, 
													"Tên thiết bị: " + TenTB
												+ "\nPhân loại: " + DT +  "\nSố lượng: " + SL 
												+ "\nGiá: " + Gia + "\nTên doanh nghiệp: " + TenDN
												+ "\nMã doanh nghiệp: " + MaDN, 
												"Thông tin thiết bị!", 
												JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnThem.setForeground(new Color(105, 105, 105));
		btnThem.setBackground(new Color(169, 169, 169));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThem.setBounds(34, 446, 221, 36);
		contentPane.add(btnThem);
		
		JButton btnLuu = new JButton("Lưu thiết bị");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String TenTB = tfTenTB.getText();
				Boolean DienTu = true;
				String DT = "Thiết bị điện tử";
				int SL = (Integer) spSL.getValue();
				double Gia = Double.parseDouble(tfGia.getText());
				String TenDN = tfTenDN.getText();
				String MaDN = tfMaDN.getText();
				
				PhanLoai pl = new PhanLoai();
				tb.setTenTB(TenTB);
				pl.setTBDT(DienTu);
				pl.setSoLuong(SL);
				tb.setPLTB(pl);
				tb.setGia(Gia);
				tb.setTenDN(TenDN);
				tb.setMaDN(MaDN);
				TB.add(tb);
				int save = JOptionPane.showConfirmDialog(btnLuu, "Bạn có muốn lưu không?", "XÁC NHẬN", 
											JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (save == JOptionPane.YES_OPTION)
				{
					GhiFile();
					JOptionPane.showMessageDialog(btnLuu, "Lưu vào file thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				if (save == JOptionPane.NO_OPTION)
				{
					JOptionPane.showMessageDialog(btnLuu, "Không lưu vào file!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLuu.setForeground(SystemColor.controlDkShadow);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLuu.setBackground(new Color(169, 169, 169));
		btnLuu.setBounds(362, 446, 173, 36);
		contentPane.add(btnLuu);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int exit = JOptionPane.showConfirmDialog(btnThoat, "Bạn có muốn thoát không?", "XÁC NHẬN", 
												JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
				if (exit == JOptionPane.NO_OPTION)
				{
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
		btnThoat.setForeground(SystemColor.controlDkShadow);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThoat.setBackground(new Color(169, 169, 169));
		btnThoat.setBounds(626, 446, 136, 36);
		contentPane.add(btnThoat);
	}
}
