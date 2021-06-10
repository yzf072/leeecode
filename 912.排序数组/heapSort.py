class Solution:
    def buildHeap(self, a):     #每一个结点都进行像底下的筛选
        for i in range(len(a) - 1, -1, -1):
            self.sift(a, i, len(a))

    def sift(self, a, root, len):   # 用p指向当前选中的子树的根结点，只要p*2+1<len，即有左子树，就要往下一层看
        p = root

        while p * 2 + 1 < len:
            l, r = p * 2 + 1, p * 2 + 2
            if r >= len or a[l] > a[r]  :
                nex = l
            else:
                nex = r
            if a[p] < a[nex]:
                a[p], a[nex] = a[nex], a[p]
                p = nex
            else:
                break

    def heapSort(self,a):   # 构建堆，然后从中取数，取完数进行重新排列，从0到i
        self.buildHeap(a)
        for i in range(len(a) - 1, -1, -1):
            a[i], a[0] = a[0], a[i]
            self.sift(a, 0, i)

    def sortArray(self, nums: List[int]) -> List[int]:
        self.heapSort(nums)
        return nums


'''
堆排序
建堆->挪数->调位置



执行用时：960 ms, 在所有 Python3 提交中击败了5.02%的用户
内存消耗：19.9 MB, 在所有 Python3 提交中击败了42.42%的用户
'''