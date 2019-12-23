package programming.set7.sudoku;

/**
 * A Sudoku board.
 */
public class Sudoku extends NumberBoard {
    /** Constructs an empty Sudoku board. */
    public Sudoku() {
        super(9, 9);
    }

    @Override
    public void setValueAt(int row, int col, int value) {
        // Only call the setter if the value is valid for a sudoku-board.
        if (value == EMPTY || (value > 0 && value <= 9)) {
            super.setValueAt(row, col, value);
        }
    }

    /**
     * Whether the Sudoku-Board is valid. This is the case if there is no row, no
     * column, and no 3×3 sub-grid that contains a number more than once.
     * 
     * @return true if the board is valid, otherwise false.
     */
    public boolean isValid() {
        // Check rows and columns in the same iteration.
        for (int i = 0; i < 9; i++) {
            // Check every i-th row
            if (!isValidRow(i)) {
                return false;
            }

            // Check every i-th column
            if (!isValidColumn(i)) {
                return false;
            }

            // Check every grid.
            if (i % 3 == 0) {
                for (int col = 0; col < 9; col += 3) {

                    if (!isValidSubGrid(i, col)) {
                        return false;
                    }

                }
            }
        }

        return true;
    }

    /**
     * Whether the specified row is valid, meaning that it contains no number more
     * than once.
     * 
     * @param row the row, starting at 0.
     * @return whether the row is valid.
     */
    private boolean isValidRow(int row) {
        // A lookup array, where the index denotes the number and the value denotes
        // whether that number has already been found in the current row.
        boolean[] usedNumbers = new boolean[10];

        for (int col = 0; col < 9; col++) {
            int value = getValueAt(row, col);
            // There can be arbitrarily many empty fields.
            if (value == EMPTY) {
                continue;
            }

            // If the number has already been found in that row, it's invalid.
            if (usedNumbers[value]) {
                return false;
            }

            // Mark the value as used.
            usedNumbers[value] = true;
        }

        return true;
    }

    /**
     * Whether the specified column is valid, meaning that it contains no number
     * more than once.
     * 
     * @param col the column, starting at 0.
     * @return whether the column is valid.
     */
    private boolean isValidColumn(int col) {
        // A lookup array, where the index denotes the number and the value denotes
        // whether that number has already been found in the current column.
        boolean[] usedNumbers = new boolean[10];

        for (int row = 0; row < 9; row++) {
            int value = getValueAt(row, col);

            // There can be arbitrarily many empty fields.
            if (value == EMPTY) {
                continue;
            }

            // If the number has already been found in that column, it's invalid.
            if (usedNumbers[value]) {
                return false;
            }
            // Mark the value as used.
            usedNumbers[value] = true;
        }

        return true;
    }

    /**
     * Whether a 3*3 grid in the board is valid, meaning that it contains no number
     * more than once.
     * 
     * @param highRow    The top row of the grid.
     * @param leftColumn The leftmost column of the grid.
     * @return Whether the grid is valid.
     */
    private boolean isValidSubGrid(int highRow, int leftColumn) {
        int lowRow = highRow + 3;
        int rightColumn = leftColumn + 3;

        // A lookup array, where the index denotes the number and the value denotes
        // whether that number has already been found in the current grid.
        boolean[] usedNumbers = new boolean[10];

        // Iterate over all elements in the grid.
        for (int row = highRow; row < lowRow; row++) {
            for (int col = leftColumn; col < rightColumn; col++) {
                int value = getValueAt(row, col);

                // There can be arbitrarily many empty fields.
                if (value == EMPTY) {
                    continue;
                }

                // If the number has already been found in that grid, it's invalid.
                if (usedNumbers[value]) {
                    return false;
                }
                // Mark the value as used.
                usedNumbers[value] = true;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        String output = "";
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                output += getValueAt(row, col);
            }
            output += "\n";
        }
        return output;
    }
}