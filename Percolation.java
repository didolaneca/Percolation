/* *****************************************************************************
 *  Name: Diyan Simeonov
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid; // declaring our two dimensional array aka our grid
    private int nSize;
    private WeightedQuickUnionUF wqu;

    public Percolation(int n) {
        // create n-by-n grid, with all sites blocked
        this.nSize = n;
        this.grid = new boolean[n][n]; // initializing our grid of size n
        this.wqu = new WeightedQuickUnionUF(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }

    }

    public void open(int row, int col) {
        // open site (row, col) if it is not open already
        int arrRow = row - 1;
        int arrCol = col - 1;
        grid[arrRow][arrCol] = true;
        if (isOpen(row - 1, col)) {
            // check if the ABOVE element is open, if it is union/join them together
            wqu.union(arrRow * nSize + arrCol, (arrRow - 1) * nSize + arrCol);
        }
        if (isOpen(row + 1, col)) {
            // check if the element BENEATH is open, if it is union/join them together
            wqu.union(arrRow * nSize + arrCol, row * nSize + arrCol);
        }
        if (isOpen(row, col - 1)) {
            // check if the element on the left is open, if it is union/join them together
            wqu.union(arrRow * nSize + arrCol, arrRow * nSize + arrCol - 1);
        }
        if (isOpen(row, col + 1)) {
            // check if the element on the right is open, if it is union/join them together
            wqu.union(arrRow * nSize + arrCol, arrRow * nSize + col);
        }

    }

    public boolean isOpen(int row, int col) {
        // is site (row, col) open?
        int arrRow = row - 1;
        int arrCol = col - 1;
        return grid[arrRow][arrCol];
    }

    public boolean isFull(int row, int col) {
        // is site (row, col) full?
    }

    public int numberOfOpenSites() {
        // number of open sites
    }

    public boolean percolates() {
        // does the system percolate?
    }

    public static void main(String[] args) {
        // test client (optional)
    }
}
