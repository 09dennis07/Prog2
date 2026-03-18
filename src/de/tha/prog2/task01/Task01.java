package de.tha.prog2.task01;

public class Task01 {
	
	public static void main(String[] args) {
		
		int row = 3;
		int col = 4;
		
		System.out.print(createChessBoard(row, col));
		
	}
	public static String createChessBoard(int row, int col) {
		String schachbrett = "";
		if (row <= 0 || col <= 0) {
			return schachbrett;
		} else {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (j < col - 1) {
						if ((i + j) % 2 != 0) {
							schachbrett += "O ";
						} else {
							schachbrett += "X ";
						}				
					} else {
						if ((i + j) % 2 != 0) {
							schachbrett += "O";
						} else {
							schachbrett += "X";
						}	
					}
				}
				schachbrett += "\n";
			}
			return schachbrett;
		}
	}
	
}
