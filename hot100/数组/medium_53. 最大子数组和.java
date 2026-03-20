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
// Sum = Math.max(Sum, 0) + x; -> 如果Sum记录的曾经的求和都 < 0了，那他一定是累赘，应该重新开始计数了
// 还可以直接化简为Sum = Math.max(Sum + x, x); 
class Solution {
    public int maxSubArray(int[] nums) {
        int Sum = 0;
        int ans = nums[0];
        for(int i : nums) {
            Sum = Math.max(Sum, 0) + x;
            ans = Math.max(ans, Sum);
        }
        return ans;
    }
}




