import java.util.Random;

class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {      //使用快排
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    
    public int quickSelect(int[] a,int l, int r, int index){        //in：数组，左边界，右边界，目标位置；
        int q = randomPartition(a,l,r);
        if ( q == index){
            return a[q];
        }
        else{
            return q<index?quickSelect(a,q+1,r,index):quickSelect(a,l,q-1,index);
        }
    }
    
    public int randomPartition(int[] a, int l, int r){      //从数组中随机选出一个值，并为接下来的方便移到最右边，然后给到partition函数进行位置交换确定该数的下标；in：数组， 左右值
        int i = random.nextInt(r-l+1)+l;
        swap(a,i,r);
        return partition(a,l,r);
    }
    
    public int partition(int[] a,int l , int r){        //对数组l-r范围进行交换，大的移到右边
        int x=a[r],i=l-1;
        for(int j=l;j<r;j++){
            if(a[j]<x){
                swap(a,++i,j);
            }
        }
        swap(a,i+1,r);
        return(i+1);
    }
    
    public void swap(int[] a,int i,int j){      //交换函数
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}



/*
快速排序，典型的分治算法
使用方法：分解，将数组划分为两个子数组，a[l...q-1]比a[q]小，a[q+1...r]比a[q]大；解决，通过递归，对两个子数组进行快速排序
每次划分后，能确定一个元素的正确位置，如果小于index则在右边继续找，反之在左边，若正好等于index则为需要的值



执行用时：2 ms, 在所有 Java 提交中击败了91.38%的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了59.98%的用户

时间复杂度：O(n)，期望为线性的选择算法
空间复杂度：：O(logn)，递归栈使用空间为logn
*/