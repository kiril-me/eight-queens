package me.kiril.eight.queens;

public class EightQueens {

	private static final int QUEENS = 8;

	private final int size;

	private final int[] board;

	public EightQueens(int size) {
		this.board = new int[size];
		this.size = size;
	}

	public EightQueens() {
		this(QUEENS);
	}

	public boolean solve() {
		return solve(0);
	}

	private boolean solve(int row) {
		if (row >= size) {
			return true;
		}
		for (int col = 0; col < size; col++) {
			if (canGo(row, col)) {
				board[row] = col;
				if (solve(row + 1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean canGo(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i] == col || (i - row) == (board[i] - col) || (i - row) == (col - board[i])) {
				return false;
			}
		}
		return true;
	}

	public void print() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if(c > 0) {
					System.out.print(" ");
				}
				if(board[r] == c) {
					System.out.print("X");
				} else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		EightQueens queens = new EightQueens();
		queens.solve();
		queens.print();
	}
}
