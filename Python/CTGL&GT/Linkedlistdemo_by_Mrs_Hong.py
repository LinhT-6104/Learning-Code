class ListNode:
    def __init__(self, data):
        self.data = data
        self.next= None

head=ListNode(20)

new=ListNode(5)
new.next=head
head=new

new=ListNode(25)
new.next=head
head=new
    
def traversal(head):
    cur=head
    while cur is not None:
        print(cur.data)
        cur=cur.next
    
traversal(head)