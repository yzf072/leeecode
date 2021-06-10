class Solution:
    def swap(self,a,i,j):
        temp=a[i]
        a[i]=a[j]
        a[j]=temp
    def quickSort(self,a,l,r):
        if l>=r:
            return
        mid = self.partition(a,l,r)
        self.quickSort(a,l,mid-1)
        self.quickSort(a,mid+1,r)

    def partition(self,a,l,r):
        x=random.randint(l,r)
        self.swap(a,x,r)
        i=l-1
        for j in range(l,r):
            if a[j]>=a[r]:
                continue
            i+=1
            self.swap(a,i,j)
        i+=1
        self.swap(a,i,r)
        return i

    def sortArray(self, nums: List[int]) -> List[int]:
        self.quickSort(nums,0,len(nums)-1)
        return nums
    
'''
快速排序
如果数大，则i不变，i一定要找到一个小的数，才变，这样让i的那一边都是比目标数小




执行用时：708 ms, 在所有 Python3 提交中击败了9.91%的用户
内存消耗：19.9 MB, 在所有 Python3 提交中击败了42.72%的用户
时间：O(nlogn)，基于随机选择目标的快速排序
空间：O(h)，h为快速排序递归所用的树的层数，最坏是n，即每一个数占用一层；最好是O(logn)，为平衡树
'''