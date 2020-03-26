import java.util.Scanner;
public class tic_tac_oe_game {
	public static void initialBoard(char Board[][]) {
		for (int i=0; i<3;i++) {
			for (int j=0;j<3;j++) {
				Board[i][j] = '-';
			}
		}
	}
	
	public static void Display(char Board[][]) {
		System.out.println("-------------");
		for (int i=0; i<3;i++) {
			System.out.print("| ");
			for (int j=0;j<3;j++) {
				System.out.print(Board[i][j]+" | ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
	public static boolean checkPosition(int position,char[][] arr) {
		for (int i = 0; i<arr.length;i++) {
			for (int j = 0; j<arr[i].length;j++) {
				if (arr[(position-1)/3][(position-1)%3]=='X' || arr[(position-1)/3][(position-1)%3]=='O') {
					return true;
					
				}
			}
		}
		return false;
	}
	public static boolean checkValid(int x) {
		if (x>=1 && x<=9) {
			return true;
		}
		return false;
	}

	public static boolean checkFull(char Board[][]) {
		boolean check = true;
		for (int i=0; i<Board.length;i++) {
			for (int j=0; j<Board.length;j++) {
				if (Board[i][j] == '-') {
					check = false;
				}
			}
		}
		return check;
	}
	
	

	
	public static boolean rowWin(char Board[][]) {
		boolean check = false;
		for (int i = 0;i<Board.length;i++) {
			if ((Board[i][0]=='X' && Board[i][1]=='X' && Board[i][2]=='X') || (Board[i][0]=='O' && Board[i][1]=='O' && Board[i][2]=='O')) {
				check = true;
			}
		}
		return check;
	}
	public static boolean columnWin(char Board[][]) {
		boolean check = false;
		for (int i = 0;i<Board.length;i++) {
			if ((Board[0][i]=='X' && Board[1][i]=='X' && Board[2][i]=='X') || (Board[0][i]=='O' && Board[1][i]=='O' && Board[2][i]=='O')) {
				check = true;
			}
		}
		return check;
	}
	public static boolean diagonalWin(char Board[][]) {
		if (((Board[0][0]=='X' && Board[1][1]=='X' && Board[2][2]=='X') ||(Board[0][2]=='X' && Board[1][1]=='X' && Board[2][0]=='X')) || ((Board[0][0]=='O' && Board[1][1]=='O' && Board[2][2]=='O') ||(Board[0][2]=='O' && Board[1][1]=='O' && Board[2][0]=='O'))) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		char [][] matrix = new char[3][3];
		initialBoard(matrix);
		Display(matrix);
		Scanner s =  new Scanner(System.in);
		
		while (true) {
			System.out.println("player X, chose a number to place your piece: ");
			int move = s.nextInt();
			while (!checkValid(move)) {
				System.out.println("Error! Invalid number.");
				System.out.println("player X, chose a number to place your piece: ");
				move = s.nextInt();
			}
			while (checkPosition(move,matrix)) {
				System.out.println("Error! Position taken already. ");
				System.out.println("player X, chose a number to place your piece: ");
				move = s.nextInt();
			}
			matrix[(move-1)/3][(move-1)%3] = 'X';
			Display(matrix);
			if (rowWin(matrix) || columnWin(matrix) || diagonalWin(matrix)) {
				System.out.println("X Win!");
				break;
			}
			if (checkFull(matrix)) {
				System.out.println("The board is full! There is no wins.");
				break;
			}
			
			System.out.println("Player O, chose a number to place your piece: ");
			int moveO = s.nextInt();
			while (!checkValid(moveO)) {
				System.out.println("Error! Invalid number.");
				System.out.println("player O, chose a number to place your piece: ");
				moveO = s.nextInt();
			}
			while (checkPosition(moveO,matrix)) {
				System.out.println("Error! Position taken already. ");
				System.out.println("player O, chose a number to place your piece: ");
				moveO = s.nextInt();
			}
			matrix[(moveO-1)/3][(moveO-1)%3] = 'O';
			Display(matrix);
			if (rowWin(matrix) || columnWin(matrix) || diagonalWin(matrix)) {
				System.out.println("O Win!");
				break;
			}
			if (checkFull(matrix)) {
				System.out.println("The board is full! There is no wins.");
				break;
			}
			
			
			
		}
		s.close();
	}
}		
		
	


