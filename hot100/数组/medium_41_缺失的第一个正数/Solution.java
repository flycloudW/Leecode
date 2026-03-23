// 想象有一间教室，座位从左到右编号为 1 到 n。
// 有 n 个学生坐在教室的座位上，把 nums[i] 当作坐在第 i 个座位上的学生的学号。我们要做的事情，就是让学号在 1 到 n 中的学生，都坐到编号与自己学号相同的座位上（学号与座位编号匹配）。学号不在 [1,n] 中的学生可以忽略。
// 主要是如果有重复的人的话，需要判断第i个座位和他学号nums[i] - 1位置上的人学号一样，直接break避免死循环

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(1 <= nums[i] && nums[i] <= n && nums[i] != i + 1) {
                if(nums[nums[i] - 1] == nums[i]) break;
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
