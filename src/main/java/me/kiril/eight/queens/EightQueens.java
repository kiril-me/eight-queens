/**
 * Copyright 2017 Kirils Mensikovs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.kiril.eight.queens;

import java.util.LinkedList;

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
		LinkedList<Integer> cols = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			cols.add(i);
		}
		return solve(0, cols);
	}

	private boolean solve(int row, LinkedList<Integer> cols) {
		if (row >= size) {
			return true;
		}
		int colSize = cols.size();
		for (int i = 0; i < colSize; i++) {
			int col = cols.removeFirst();
			if (canGo(row, col)) {
				board[row] = col;
				if (solve(row + 1, cols)) {
					return true;
				}
			}
			cols.add(col);
		}
		return false;
	}

	private boolean canGo(int row, int col) {
		for (int i = 0; i < row; i++) {
			int diagonal = i - row;
			if (diagonal == (board[i] - col) || diagonal == (col - board[i])) {
				return false;
			}
		}
		return true;
	}

	public void print() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (c > 0) {
					System.out.print(" ");
				}
				if (board[r] == c) {
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
