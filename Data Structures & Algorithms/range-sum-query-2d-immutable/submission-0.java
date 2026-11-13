class NumMatrix {

    private int[][] sumMatrix; 

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        
        sumMatrix = new int[rows + 1][cols + 1];

        for(int row = 0; row < rows; row++){
            int total = 0;
            for(int col = 0; col < cols; col++) {
                total += matrix[row][col];
                int up  = sumMatrix[row][ col + 1];
                sumMatrix[row + 1][col + 1] = total + up; 
            }
        }        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        row1++;
        row2++;
        col1++;
        col2++;

        int bottomRight = sumMatrix[row2][col2];
        int topRight =  sumMatrix[row1 - 1][col2];
        int bottomLeft = sumMatrix[row2][col1 -1];
        int topLeft = sumMatrix[row1 - 1][col1 -1];

        return  bottomRight - topRight - bottomLeft + topLeft;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */