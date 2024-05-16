package Tuan11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application_QLSV {

	private JFrame frameDN;
	private JTextField tfTenDangNhap;
	private JPasswordField pfMatKhau;
	private boolean hienMK = false; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application_QLSV window = new Application_QLSV();
					window.frameDN.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application_QLSV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDN = new JFrame();
		frameDN.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(frameDN,
						"You really want to exit ?", "Hệ thống",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(1);
				} else {
					frameDN.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		frameDN.setBounds(100, 100, 585, 387);
		frameDN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDN.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập hệ thống");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(42, 0, 471, 50);
		frameDN.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(47, 71, 100, 20);
		frameDN.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(47, 110, 100, 20);
		frameDN.getContentPane().add(lblNewLabel_2);
		
		tfTenDangNhap = new JTextField();
		tfTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTenDangNhap.setBounds(175, 70, 213, 20);
		frameDN.getContentPane().add(tfTenDangNhap);
		tfTenDangNhap.setColumns(10);
		
		pfMatKhau = new JPasswordField();
		pfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pfMatKhau.setEchoChar('*');
		pfMatKhau.setBounds(175, 110, 213, 20);
		frameDN.getContentPane().add(pfMatKhau);
		
		JButton btnHienMatKhau = new JButton("Hiện");
		btnHienMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hienMK) {
					pfMatKhau.setEchoChar('*');
					btnHienMatKhau.setText("Hiện");
					hienMK = false;
				} else {
					pfMatKhau.setEchoChar('\0');
					btnHienMatKhau.setText("Ẩn");
					hienMK = true;
				}
			}
		});
		btnHienMatKhau.setBackground(Color.MAGENTA);
		btnHienMatKhau.setForeground(SystemColor.controlLtHighlight);
		btnHienMatKhau.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHienMatKhau.setBounds(415, 109, 85, 20);
		frameDN.getContentPane().add(btnHienMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tenDangNhap = tfTenDangNhap.getText().trim();
				String matKhau = String.valueOf(pfMatKhau.getPassword());   

				if (tenDangNhap.length() > 0 && matKhau.length() > 0) {
					if (tenDangNhap.equals("admin") && matKhau.equals("1")) {
						JOptionPane.showMessageDialog(btnDangNhap, "Xin chào admin", "Hệ thống",
								JOptionPane.INFORMATION_MESSAGE);
						frameDN.dispose();
						QLSV.main(null);
					} else {
						JOptionPane.showMessageDialog(btnDangNhap,
								"Tên đăng nhập hoặc mật khẩu không đúng!",
								"Hệ thống", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(btnDangNhap,
							"Nhập đầy đủ tên đăng nhập và mật khẩu!", "Hệ thống",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDangNhap.setForeground(SystemColor.controlLtHighlight);
		btnDangNhap.setBackground(Color.BLUE);
		btnDangNhap.setBounds(226, 150, 110, 40);
		frameDN.getContentPane().add(btnDangNhap);
	}
}
