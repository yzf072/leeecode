```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        if head.next == None:
            return head

        new = self.reverseList(head.next)
        b=head.next
        b.next=head
        head.next=None
        return new
```

执行用时：44 ms, 在所有 Python3 提交中击败了10.06%的用户

内存消耗：19.8 MB, 在所有 Python3 提交中击败了5.14%的用户

