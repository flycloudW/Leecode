class Solution {
    public void setZeroes(int[][] matrix) {
        // 为了实现原地，把第一行和第一列作为标签，存储0看是否要把对应的整行和整列改为0；
        // 为了避免按行遍历赋予第一列0的时候被认为第一列全要归0，因此第一列的0专门有一个标志确定。
        // 那第一行究竟是否本来就有0就是个问题了。可以用nums[0][0]作为标志位，看第一行是否需要变0
        // 列
        int m = matrix.length;
        // 行
        int n = matrix[0].length;

        boolean firstRowHasZero = false;
        // 记录第一行是否天然存在0；
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // 按行读取用第一行和第一列是否为0来确认是否存在0。特殊：nums[0][0]存储第一行是否天然存在0；
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) { // 如果第一列包含 0，那么 matrix[0][0] 会置为 0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 注意顺序，先改第一列，再改第一行（避免把 matrix[0][0] 从 1 改成 0 影响判断）
        if (matrix[0][0] == 0) { // 替换原来的 firstColHasZero
            for (int[] row : matrix) {
                row[0] = 0;
            }
        }

        if (firstRowHasZero) {
            Arrays.fill(matrix[0], 0);
        }

    }
}
