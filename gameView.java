import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class gameView extends javax.swing.JFrame {

	private JPanel contentPane;
	private int[] inputMove;
	private JLabel[][] squares;
	private JPanel panel;
	private TicTacToeGame game;
	private JLabel lblGameState;
	private JTextArea textPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public gameView(TicTacToeGame game1) {
		lblGameState = new JLabel();
		
		setTitle("Tic-Tac-Toe");
		setDefaultCloseOperation(gameView.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		game = game1;
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("New Game");
		mnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mnNew.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mnNew.setForeground(Color.WHITE);
			}
		});
		mnNew.setForeground(Color.WHITE);
		mnNew.setBackground(Color.BLACK);
		menuBar.add(mnNew);
		
		JMenuItem mntmPlayerVsPlayer = new JMenuItem("Player vs. Player");
		mntmPlayerVsPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setPlayers("Player vs. Player");
				setMove(3,3);			
			}
		});
		mntmPlayerVsPlayer.setForeground(Color.WHITE);
		mntmPlayerVsPlayer.setBackground(Color.BLACK);
		mnNew.add(mntmPlayerVsPlayer);
		
		JMenuItem mntmPlayerVsComputer = new JMenuItem("Player vs. Computer");
		mntmPlayerVsComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setPlayers("Player vs. Computer");
				setMove(3,3);
				
			}
		});
		mntmPlayerVsComputer.setForeground(Color.WHITE);
		mntmPlayerVsComputer.setBackground(Color.BLACK);
		mnNew.add(mntmPlayerVsComputer);
		
		JMenuItem mntmComputerVsPlayer = new JMenuItem("Computer vs. Player");
		mntmComputerVsPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setPlayers("Computer vs. Player");
				setMove(3,3);
				
			}
		});
		mntmComputerVsPlayer.setForeground(Color.WHITE);
		mntmComputerVsPlayer.setBackground(Color.BLACK);
		mnNew.add(mntmComputerVsPlayer);
		
		JMenuItem mntmComputerVsComputer = new JMenuItem("Computer vs. Computer");
		mntmComputerVsComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setPlayers("Computer vs. Computer");
				setMove(3,3);
			}
		});
		mntmComputerVsComputer.setForeground(Color.WHITE);
		mntmComputerVsComputer.setBackground(Color.BLACK);
		mnNew.add(mntmComputerVsComputer);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		squares = new JLabel[3][3];
		
		inputMove = new int[2];
		
		panel = new JPanel();
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
				setMove(0,0);
			}
		});
		square00.setBounds(0, 0, 174, 180);
		panel.add(square00);
		
		JLabel square01 = new JLabel("");
		square01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMove(0, 1);
			}
		});
		square01.setBounds(214, 0, 174, 180);
		panel.add(square01);
		
		JLabel square02 = new JLabel("");
		square02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMove(0, 2);
			}
		});
		square02.setBounds(426, 0, 174, 180);
		panel.add(square02);
		
		JLabel square10 = new JLabel("");
		square10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMove(1, 0);
			}
		});
		square10.setBounds(0, 212, 174, 180);
		panel.add(square10);
		
		JLabel square11 = new JLabel("");
		square11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMove(1, 1);
			}
		});
		square11.setBounds(214, 212, 174, 180);
		panel.add(square11);
		
		JLabel square12 = new JLabel("");
		square12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMove(1, 2);
			}
		});
		square12.setBounds(426, 212, 174, 180);
		panel.add(square12);
		
		JLabel square20 = new JLabel("");
		square20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMove(2, 0);
			}
		});
		square20.setBounds(0, 420, 174, 180);
		panel.add(square20);
		
		JLabel square21 = new JLabel("");
		square21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMove(2, 1);
			}
		});
		square21.setBounds(214, 420, 174, 180);
		panel.add(square21);
		
		JLabel square22 = new JLabel("");
		square22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMove(2, 2);
			}
		});
		square22.setBounds(426, 420, 174, 180);
		panel.add(square22);
		
		lblGameState.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGameState.setForeground(Color.WHITE);
		lblGameState.setBounds(300, 69, 238, 58);
		contentPane.add(lblGameState);
		

		squares[0][0] = square00;
		squares[0][1] = square01;
		squares[0][2] = square02;
		squares[1][0] = square10;
		squares[1][1] = square11;
		squares[1][2] = square12;
		squares[2][0] = square20;
		squares[2][1] = square21;
		squares[2][2] = square22;
		
		textPane = new JTextArea();
		textPane.setEditable(false);
		textPane.setBorder(null);
		//textPane.setHorizontalAlignment(SwingConstants.CENTER);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.BLACK);
		textPane.setBounds(912, 140, 258, 574);
		contentPane.add(textPane);
	}
	
	public void setMoveHistory(String s) {
		System.out.println(s);
		textPane.setText(s);
	}
	public void setLabel(String s) {
		lblGameState.setText(s);
	}
	public int[] getMove()
	{
		return inputMove;
	}
	public void setMove(int r, int c)
	{
		inputMove[0] = r;
		inputMove[1] = c;
	}
	public void setPNG(int r, int c, String p)
	{
		if(r == 0 && c == 0)
		{
			squares[0][0].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else if(r == 0 && c == 1)
		{
			squares[0][1].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else if(r == 0 && c == 2)
		{
			squares[0][2].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else if(r == 1 && c == 0)
		{
			squares[1][0].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else if(r == 1 && c == 1)
		{
			squares[1][1].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else if(r == 1 && c == 2)
		{
			squares[1][2].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else if(r == 2 && c == 0)
		{
			squares[2][0].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else if(r == 2 && c == 1)
		{
			squares[2][1].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else if(r == 2 && c == 2)
		{
			squares[2][2].setIcon(new ImageIcon(this.getClass().getResource(p)));
		}
		else
		{
			System.out.println("Hey buddy you set an invalid");
		}
	}
	public void clearScreen()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int k = 0; k < 3; k++)
			{
				squares[i][k].setIcon(null);
			}
		}
	}
}
