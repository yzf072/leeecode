class heapSort {
    public int findKthLargest(int[] nums, int k) {
        int heapSize=nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i=nums.length-1;i>=nums.length-k+1;--i){
            swap(nums,0,i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize){
        for(int i=heapSize/2;i>=0;--i){
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a,int i,int heapSize){
        int l=i*2+1,r=i*2+2,largest=i;
        if(l<heapSize&&a[largest]<a[l]){
            largest=l;
        }
        if(r<heapSize&& a[largest]<a[r]){
            largest=r;
        }
        if(largest!=i){
            swap(a,i,largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}



/*
堆排序
堆看作一颗完全二叉树，满足任何一个非叶结点的值都不大于其左右孩子结点的值
排序：
    堆顶值是最大的，无序列表调整为一个堆即可找到这个序列的最大值，然后交换到序列最后，就排好了一个，然后对剩余序列重复操作就实现了排序
    从最底下最右边的非叶结点开始进行调整
    
插入：
    先将要插入的结点x放入最底层最右边，满足完全二叉树；然后把x一次向上调整到合适位置满足父大子小的性质
删除：
    删除后出现一个孔，把最底层最右边的放上去然后下调到合适位置



执行用时：2 ms, 在所有 Java 提交中击败了91.38%的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了27.29%的用户
时间复杂度：O(nlogn)
    建堆用O(n)，删除用时klogn，k<n，则总时间O(n+klogn)=O(nlogn)
空间复杂度：O(logn)
    递归使用的栈
*/

//书上代码
class book{
    public void sift(int[] R, int low, int high){
        int i=low,j=i*2;
        int temp=R[i];
        while(j<=high){
            if(j<high&&R[j]<R[j+1]){
                j++;
            }
            if(temp<R[j]){
                R[i]=R[j];
                i=j;
                j=i*2;
            }else{
                break;
            }
        }
        R[i]=temp;
    }

    public void heapSort(int[] R,int n){
        int i;
        int temp;
        for(i=n/2;i>=1;i++){
            sift(R,i,n);
        }
        for(i=n;i>=2;i--){
            temp=R[1];
            R[1]=R[i];
            R[i]=temp;
            sift(R,1,i-1);
        }
    }
}