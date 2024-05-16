package Swing;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DangNhapWindow {

	private JFrame frameDangNhap;
	private JTextField tfTenDangNhap;
	private JPasswordField pfMatKhau;
	private boolean hienMatKhau = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapWindow window = new DangNhapWindow();
					window.frameDangNhap.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DangNhapWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDangNhap = new JFrame();
		frameDangNhap.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(frameDangNhap, 
						"Bạn muốn thoát ứng dụng ?", "EXIT", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					frameDangNhap.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		frameDangNhap.setTitle("Login");
		frameDangNhap.setBounds(100, 100, 629, 374);
		frameDangNhap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDangNhap.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập hệ thống");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(200, 10, 260, 59);
		frameDangNhap.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(48, 79, 120, 22);
		frameDangNhap.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(48, 129, 120, 22);
		frameDangNhap.getContentPane().add(lblNewLabel_1_1);
		
		tfTenDangNhap = new JTextField();
		tfTenDangNhap.setBounds(188, 79, 260, 22);
		frameDangNhap.getContentPane().add(tfTenDangNhap);
		tfTenDangNhap.setColumns(10);
		
		pfMatKhau = new JPasswordField();
		pfMatKhau.setEchoChar('*');
		pfMatKhau.setBounds(188, 129, 260, 22);
		frameDangNhap.getContentPane().add(pfMatKhau);
		
		JButton btnHienMatKhau = new JButton("Hiện");
		btnHienMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hienMatKhau) {
					pfMatKhau.setEchoChar('*');
					btnHienMatKhau.setText("Hiện");
					hienMatKhau = false;
				} else {
					pfMatKhau.setEchoChar('\0');
					btnHienMatKhau.setText("Ẩn");
					hienMatKhau = true;
				}
			}
		});
		btnHienMatKhau.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHienMatKhau.setBackground(Color.MAGENTA);
		btnHienMatKhau.setForeground(SystemColor.controlLtHighlight);
		btnHienMatKhau.setBounds(468, 129, 80, 22);
		frameDangNhap.getContentPane().add(btnHienMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenDN = tfTenDangNhap.getText();
				String matKhau = String.valueOf(pfMatKhau.getPassword());
				if (tenDN.length() > 0 && matKhau.length() > 0) {
					if (tenDN.equals("admin") && matKhau.equals("1")) {
						JOptionPane.showMessageDialog(btnDangNhap, 
							"Chào mừng admin!", "Hệ thống",
							JOptionPane.INFORMATION_MESSAGE);
						frameDangNhap.dispose();
						QLSVWindow.main(null);
						
					} else {
						JOptionPane.showMessageDialog(btnDangNhap, 
							"Sai tên đăng nhập hoặc mật khẩu!", "Hệ thống",
							JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(btnDangNhap, 
							"Nhập đầy đủ tên đăng nhập và mật khẩu!", "Hệ thống",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDangNhap.setBackground(Color.BLUE);
		btnDangNhap.setForeground(SystemColor.controlLtHighlight);
		btnDangNhap.setBounds(257, 179, 100, 40);
		frameDangNhap.getContentPane().add(btnDangNhap);
	}
}
