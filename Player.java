import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;


public class TicTacToe extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	Board b;
	boolean isPlayer1Turn = true;
	
	Player currentPlayer;
	JPanel[] row = new JPanel[4];
	JButton[] button = new JButton[9];
	Dimension displayDimension = new Dimension(300,45);
	Dimension regularDimension = new Dimension(65,50);
	JTextArea display = new JTextArea(2,20);
	Font font = new Font("Times new Roman", Font.BOLD, 14);
	
	public Player takePlayerInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter player name");
		String name = s.nextLine();
		System.out.println("Enter player symbol");
		char symbol = s.next().charAt(0);
		return new Player(name, symbol);
	}

	public TicTacToe() {	
		super("Tic Tac Toe Game");
		setDesign();
		setSize(330, 250);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(4,3);
		setLayout(grid);
		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
		FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
		for(int i = 0; i < 4; i++)
			row[i] = new JPanel();
		row[0].setLayout(f1);
		for(int i = 1; i < 4; i++)
			row[i].setLayout(f2);

		for(int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button[i].setText("");
			button[i].setBackground(Color.GRAY);
			button[i].setFont(font);
			button[i].addActionListener(this);
		}

		display.setFont(font);
		display.setEditable(false);
		display.setPreferredSize(displayDimension);

		for(int i = 0; i < 9; i++)
			button[i].setPreferredSize(regularDimension);
		row[0].add(display);
		add(row[0]);
		for(int i = 0; i < 3; i++)
			row[1].add(button[i]);
		add(row[1]);
		for(int i = 3; i < 6; i++)
			row[2].add(button[i]);
		add(row[2]);
		for(int i = 6; i < 9; i++)
			row[3].add(button[i]);
		add(row[3]);
		setVisible(true);
		Player player1 = takePlayerInput();
		Player player2 = takePlayerInput();
		
		while (player2.getSymbol() == player1.getSymbol()) {
			System.out.println("Player2 take someother symbol");
			player2 = takePlayerInput();
		}

		b = new Board(player1.getSymbol(), player2.getSymbol());
		Scanner s = new Scanner(System.in);
		while (b.getGameStatus() == Board.INCOMPLETE) {
			if (isPlayer1Turn)
				currentPlayer = player1;
			else 
				currentPlayer = player2;
			display.setText(currentPlayer.getName()+"  your turn");
		}
		
		int status = b.getGameStatus();
		if (status == Board.DRAW) {
			display.setText("Draw");
		} else if (status == Board.PLAYER1WON) {
			display.setText(player1.getName()+"  You Won");
		} else {
			display.setText(player2.getName()+"  You Won");
		}
		for(int i = 0;i < 9;i++){
			button[i].setEnabled(false);
		}

	}

	public final void setDesign() {
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {   
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae != null){
			if(ae.getSource() == button[0]){
				b.board[0][0] = currentPlayer.getSymbol();
				button[0].setText(Character.toString(currentPlayer.getSymbol()));
				button[0].setEnabled(false);
			} else if(ae.getSource() == button[1]){
				b.board[0][1] = currentPlayer.getSymbol();
				button[1].setText(Character.toString(currentPlayer.getSymbol()));
				button[1].setEnabled(false);
			} else if(ae.getSource() == button[2]){
				b.board[0][2] = currentPlayer.getSymbol();
				button[2].setText(Character.toString(currentPlayer.getSymbol()));
				button[2].setEnabled(false);
			} else if(ae.getSource() == button[3]){
				b.board[1][0] = currentPlayer.getSymbol();
				button[3].setEnabled(false);
				button[3].setText(Character.toString(currentPlayer.getSymbol()));
			} else if(ae.getSource() == button[4]){
				button[4].setEnabled(false);
				b.board[1][1] = currentPlayer.getSymbol();
				button[4].setText(Character.toString(currentPlayer.getSymbol()));
			} else if(ae.getSource() == button[5]){
				button[5].setEnabled(false);
				b.board[1][2] = currentPlayer.getSymbol();
				button[5].setText(Character.toString(currentPlayer.getSymbol()));
			} else if(ae.getSource() == button[6]){
				button[6].setEnabled(false);
				b.board[2][0] = currentPlayer.getSymbol();
				button[6].setText(Character.toString(currentPlayer.getSymbol()));
			} else if(ae.getSource() == button[7]){
				button[7].setEnabled(false);
				b.board[2][1] = currentPlayer.getSymbol();
				button[7].setText(Character.toString(currentPlayer.getSymbol()));
			} else if(ae.getSource() == button[8]){
				button[8].setEnabled(false);
				b.board[2][2] = currentPlayer.getSymbol();
				button[8].setText(Character.toString(currentPlayer.getSymbol()));
			}

		}
		isPlayer1Turn = !isPlayer1Turn;
	}

	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
	}
}
