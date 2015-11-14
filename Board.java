import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Board{

	private static final long serialVersionUID = 1L;
	public char[][] board;
	char player1Symbol;
	char player2Symbol;
	public static final int PLAYER1WON = 1;
	public static final int PLAYER2WON = 2;
	public static final int INCOMPLETE = 3;
	public static final int DRAW = 0;

	public Board(char player1S, char player2S) {
		this.player1Symbol = player1S;
		this.player2Symbol = player2S;
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public int getGameStatus() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {		
				if (board[i][0] == player1Symbol)
					return PLAYER1WON;
				else if (board[i][0] == player2Symbol)
					return PLAYER2WON;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
				if (board[0][i] == player1Symbol)
					return PLAYER1WON;
				else if (board[0][i] == player2Symbol)
					return PLAYER2WON;
			}
		}

		
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			if (board[0][0] == player1Symbol)
				return PLAYER1WON;
			else if (board[0][0] == player2Symbol)
				return PLAYER2WON;
		}

		if (board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
			if (board[2][0] == player1Symbol)
				return PLAYER1WON;
			else if (board[2][0] == player2Symbol)
				return PLAYER2WON;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return INCOMPLETE;
				}
			}
		}
		return DRAW;
	}}
