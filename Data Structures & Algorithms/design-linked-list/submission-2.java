class ListNode {
    int val; 
    ListNode next;
    ListNode prev;

    ListNode (int val) {
        this.val = val; 
        this.prev = null; 
        this.next = null; 
    } 
}

class MyLinkedList {
    
    ListNode head; 
    ListNode tail; 

    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail; 
        tail.prev = head;    
    }
    
    public int get(int index) {
        ListNode curr = head.next; 
        while(curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if(curr != null && curr != tail && index == 0) {
            return curr.val; 
        } 
        return -1; 
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        ListNode firstNode = head.next; 
        ListNode dummyHead = head;

        dummyHead.next = node; 
        firstNode.prev = node;
        node.next = firstNode; 
        node.prev = dummyHead;
         
    }
    
    public void addAtTail(int val) {

        ListNode node = new ListNode(val);
        ListNode lastNode = tail.prev;
        ListNode dummyTail = tail;

        dummyTail.prev = node;
        lastNode.next = node;
        node.next = dummyTail;
        node.prev = lastNode;     
    }
    
    public void addAtIndex(int index, int val) {

        ListNode curr = head.next;

        while(curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        
        if(curr != null && index == 0){

            ListNode node = new ListNode(val);
            ListNode prevNode = curr.prev; 
            ListNode dummyCurr = curr;

            dummyCurr.prev = node;
            prevNode.next = node; 
            node.next = dummyCurr; 
            node.prev = prevNode;

        }   
    }
    
    public void deleteAtIndex(int index) {
        ListNode curr = head.next; 

        while(curr != null && index > 0) {
            curr = curr.next;
            index--;
        }

        if(curr != null && curr != tail &&index == 0){
            ListNode rightNode = curr.next;
            ListNode leftNode = curr.prev; 

            curr.next = null; 
            curr.prev = null; 
            rightNode.prev = leftNode; 
            leftNode.next = rightNode;
        } 
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */