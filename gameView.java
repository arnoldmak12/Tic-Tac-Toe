import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gameView extends javax.swing.JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameView frame = new gameView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameView() {
		setTitle("Tic-Tac-Toe");
		setDefaultCloseOperation(gameView.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(300, 140, 600, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("Tic-Tac-Toe Grid.png")));
		lblNewLabel.setBounds(0, 0, 600, 600);
		panel.add(lblNewLabel);
		
		JLabel square00 = new JLabel("");
		square00.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				square00.setIcon(new ImageIcon(this.getClass().getResource("PieceO.png")));
			}
		});
		square00.setBounds(0, 0, 174, 180);
		panel.add(square00);
		
		JLabel square01 = new JLabel("");
		square01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				square01.setIcon(new ImageIcon(this.getClass().getResource("PieceO.png")));
			}
		});
		square01.setBounds(214, 0, 174, 180);
		panel.add(square01);
		
		JLabel square02 = new JLabel("");
		square02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				square02.setIcon(new ImageIcon(this.getClass().getResource("PieceX.png")));
			}
		});
		square02.setBounds(426, 0, 174, 180);
		panel.add(square02);
		
		JLabel square10 = new JLabel("");
		square10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				square10.setIcon(new ImageIcon(this.getClass().getResource("PieceO.png")));
			}
		});
		square10.setBounds(0, 212, 174, 180);
		panel.add(square10);
		
		JLabel square11 = new JLabel("");
		square11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				square11.setIcon(new ImageIcon(this.getClass().getResource("PieceX.png")));
			}
		});
		square11.setBounds(214, 212, 174, 180);
		panel.add(square11);
		
		JLabel square12 = new JLabel("");
		square12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				square12.setIcon(new ImageIcon(this.getClass().getResource("PieceX.png")));
			}
		});
		square12.setBounds(426, 212, 174, 180);
		panel.add(square12);
		
		JLabel square20 = new JLabel("");
		square20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				square20.setIcon(new ImageIcon(this.getClass().getResource("PieceO.png")));
			}
		});
		square20.setBounds(0, 420, 174, 180);
		panel.add(square20);
		
		JLabel square21 = new JLabel("");
		square21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				square21.setIcon(new ImageIcon(this.getClass().getResource("PieceX.png")));
			}
		});
		square21.setBounds(214, 420, 174, 180);
		panel.add(square21);
		
		JLabel square22 = new JLabel("");
		square22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				square22.setIcon(new ImageIcon(this.getClass().getResource("PieceO.png")));
			}
		});
		square22.setBounds(426, 420, 174, 180);
		panel.add(square22);
		
		JLabel lblPlayerTurn = new JLabel("Player Turn:");
		lblPlayerTurn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlayerTurn.setForeground(Color.WHITE);
		lblPlayerTurn.setBounds(300, 69, 238, 58);
		contentPane.add(lblPlayerTurn);
	}
}
