package HongAnh_Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class APP_QLSV {

	private JFrame frame;
	private JTextField tfTenDangNhap;
	private JPasswordField pfMatKhau;
	private boolean hienMK = false;	// Hien mk: true || Khong hien mk: false

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APP_QLSV window = new APP_QLSV();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public APP_QLSV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 743, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập hệ thống");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(197, 35, 200, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(50, 95, 100, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_1.setBounds(50, 132, 100, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tfTenDangNhap = new JTextField();
		tfTenDangNhap.setBounds(175, 95, 317, 20);
		frame.getContentPane().add(tfTenDangNhap);
		tfTenDangNhap.setColumns(10);
		
		pfMatKhau = new JPasswordField();
		pfMatKhau.setEchoChar('*');
		pfMatKhau.setBounds(175, 132, 317, 20);
		frame.getContentPane().add(pfMatKhau);
		
		JButton btnHienMK = new JButton("Hiện");
		btnHienMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hienMK == true) {
					btnHienMK.setText("Hiện");
					pfMatKhau.setEchoChar('*');
					hienMK = false;
				} else {
					btnHienMK.setText("Ẩn");
					pfMatKhau.setEchoChar('\0');
					hienMK = true;
				}
			}
		});
		btnHienMK.setBackground(Color.MAGENTA);
		btnHienMK.setForeground(Color.WHITE);
		btnHienMK.setBounds(529, 131, 85, 21);
		frame.getContentPane().add(btnHienMK);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setBackground(Color.BLUE);
		btnDangNhap.setBounds(224, 176, 186, 40);
		frame.getContentPane().add(btnDangNhap);
	}
}
