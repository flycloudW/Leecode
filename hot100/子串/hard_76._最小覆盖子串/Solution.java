class Solution {
    public String minWindow(String s, String t) {
        // 核心，覆盖子串允许元素超额，但是不许元素缺失，因此应该随便招新的，多淘汰不合要求的。
        int[] need = new int[128];
        int[] window = new int[128];
        char[] S = s.toCharArray();
        // 当前最小长度
        int minL = Integer.MAX_VALUE;
        // 最小的头节点
        int start = 0;
        // 统计需求
        for(char c : t.toCharArray()) need[c]++;
        int needHeGe = 0;
        for(int i : need) if(i > 0) needHeGe++;

        // 统计有几种字母已经达标
        int hege = 0;

        int left = 0;
        int right = 0;

        while(right < S.length) {
            // 添加新元素
            char c = S[right];
            right++; 

            // 只需要统计有必要统计的t中的元素
            if(need[c] > 0) {
                window[c]++;
                if(window[c] == need[c]) hege++;
            }       
            
            // 都合格了淘汰不合格的
            // 核心：淘汰思路，把每次找到的合格的都压缩到最短，再招其他的合格的，因为保存着现有的往后再找最多只能压缩到同样短，不能更短了
            while(hege == needHeGe) {
                if(right - left < minL) {
                    minL = right - left;
                    start = left;
                }
                char d = S[left];
                left++;
                // 不在需求的left就直接删了
                if(need[d] > 0) {
                    if(window[d] == need[d]) {
                        hege--;
                    }
                    window[d]--;
                }                          
            }
        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(start, start + minL);
    }
}

