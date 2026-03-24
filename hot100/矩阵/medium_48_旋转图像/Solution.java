class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i = 0; i < n; i++) {
            int[] row = matrix[i];
            // 转置
            for(int j = i + 1; j < n; j++) {
                int tmp = row[j];
                row[j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            // 对称
            for(int j = 0; j < n / 2; j++) {
                int tmp = row[j];
                row[j] = row[n - 1 -j];
                row[n - 1 - j] = tmp;
            }
        }
    }
}
