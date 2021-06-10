public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] a,int l,int r){
        int x=a[r],i=l-1,j;
        for(j=l;j<r;i++){
            if(a[j]<x){
                swap(a,++i,j);
            }
        }
        swap(a,i+1,r);
        if(l<i){
            quickSort(a, l, i);
        }
        if(i+2<r){
            quickSort(a,i+2,r);
        }
    }

    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public void public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

}
