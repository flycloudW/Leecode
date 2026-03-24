// - 矩阵旋转：顺时针旋转90°，第一列→第一行，第一行→最后一列；第i列→第i行，第i列→倒数第i列。因此$(i,j)→(j,n-1-i)$等价$(i,j)转置→(j,i)行翻转→(j,n-1-i)$
// - **旋转 180°：**旋转 180° 相当于把矩阵“倒过来”再“左右反过来”。
// • **坐标变换**：$(i, j) \to (n-1-i, n-1-j)$
// • **等价操作**：
//     1. **垂直翻转** (上下颠倒)：$(i, j) \to (n-1-i, j)$
//     2. **水平翻转** (左右镜像)：$(n-1-i, j) \to (n-1-i, n-1-j)$
// - **旋转 270°：**旋转 270° 顺时针，其实等同于 **90° 逆时针**。
// • **坐标变换**：$(i, j) \to (n-1-j, i)$
// • **等价操作**：
//     1. **转置 (Transpose)**：$(i, j) \to (j, i)$
//     2. **垂直翻转 (Vertical Flip)**：$(j, i) \to (n-1-j, i)$
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
