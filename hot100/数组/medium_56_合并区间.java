// ========================================================================
// 贪心算法：先把需求排序，再依次找逻辑
// 排序：左端点排序之后，整个区间都在数轴上平铺了
// 会写sort的lambda表达式

// 结果类型转化集合(list)与<T>
// 使用list.toArray() list为集合的名字，若()为空默认返回Object[]
// 如果List<T[如果有]> list则list.toArray(new T[list.size()][如果有]) 返回需要的类型

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);
        for(int[] i : intervals) {    
            // 通过get获得的是list最后一个对象的引用，不是创造了一个新数组，对其的操作会直接改变list的内容
            int[] tmp = res.get(res.size() - 1);
            if(tmp[1] >= i[0]) {
                // tmp拿的是list的引用，因此修改其中的值直接就可以修改list了
                tmp[1] = Math.max(tmp[1], i[1]);
            } else {
                res.add(i);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
