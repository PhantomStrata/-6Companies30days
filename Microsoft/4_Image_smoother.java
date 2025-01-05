class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        
        //create a result matrix 
        int[][] result = new int[rows][cols];

        //iterating each pixel of the image
        for(int i = 0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                int tSum=0;
                int count=0;  

                //iterating the 3x3 grid around current cell
                for(int x = Math.max(0,i-1); x<=Math.min(rows-1, i+1); x++)
                {
                    for(int y = Math.max(0,j-1); y<=Math.min(cols-1, j+1); y++)
                    {
                        tSum += img[x][y];
                        count++;
                    }
                }

                //updating result array with smooth values
                result[i][j] = tSum/count;
            }
        }
        return result;
    }

}
