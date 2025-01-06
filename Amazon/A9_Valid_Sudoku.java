class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Iterate through the board
        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++) 
            {
                char c = board[i][j];
                if (c == '.')
                    continue; //empty cells skipping

                int num = c - '1'; // changing the index positions to zero-based indexing
                
                // Check row
                if (rows[i][num])
                    return false;
                rows[i][num] = true;
                
                // Check column
                if (cols[j][num])
                    return false;
                cols[j][num] = true;

                // Check 3x3 sub-box
                int boxIndex = (i / 3) * 3 + j / 3;
                if (boxes[boxIndex][num])
                    return false;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}