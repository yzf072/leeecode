import java.util.Arrays;
class Violence {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

/*
暴力解法
使用java自带进行排序，然后输出length-k位置的数
java中Arrays.sort使用了两种排序方法，quick sort 和优化的 merge sort
quick sort 主要是对哪些基本类型数据（int, short, long, float, double等）排序， 而 merge sort 用于对对象类型进行排序
对于对象，保序性很重要，所以使用merge sort
merge sort
（1）最坏时间复杂度是 O(nlogn)；
（2）平均时间复杂度是 O(nlogn)；
（3）空间复杂度是 O(1)。
quick sort
（1）最坏时间复杂度是 O(n^2)；
（2）平均时间复杂度是 O(nlogn)；
（3）空间复杂度是 O(n)。



执行用时：2 ms, 在所有 Java 提交中击败了91.38%的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了47.63%的用户
*/