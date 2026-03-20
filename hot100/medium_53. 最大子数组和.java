// ==========================================
// 方法一： 前缀和
// 核心思路： 有负数只能用前缀和，不能用滑动窗口
// 易错点： 初始化很重要，ans很多时候要看情况选择Integer.MIN_VALUE或者Integer.MAX_VALUE，其他变量看着选，参数保证循环第一次逻辑没问题
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int sumMin = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            ans = Math.max(ans, sum - sumMin);    
            sumMin = Math.min(sum, sumMin);
        }
        return ans;
    }
}

// ==========================================
// 方法二： Kadane 算法动态规划






