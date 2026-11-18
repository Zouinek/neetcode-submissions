class ListNode {
    int val; 
    ListNode next;
    ListNode prev;

    ListNode (int val) {
        this.val = val; 
        this.prev = null; 
        this.next = null; 
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next; 
        this.prev = prev; 
    }
}

class MyLinkedList {
    
    ListNode head; 
    ListNode tail;
    int size;  

    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail; 
        tail.prev = head;
        size = 0;    
    }

    private ListNode getPrev(int index){
        if(index <= size / 2) {
            ListNode curr = head; 
            for(int i = 0; i < index; i++){
                curr = curr.next; 
            }
            return curr;
        } else {
            ListNode curr = tail;

            for(int i = 0; i < size - index + 1; i++){
                curr = curr.prev; 
            } 
            return curr;
        }
    }
    
    public int get(int index) {
        if(index >= size) return -1;
        return getPrev(index).next.val; 
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);     
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);    
    }
    
    public void addAtIndex(int index, int val) {

        if(index > size) return;

            ListNode node = new ListNode(val);
            ListNode prevNode = getPrev(index); 
            ListNode dummyCurr = prevNode.next;

            dummyCurr.prev = node;
            prevNode.next = node; 
            node.next = dummyCurr; 
            node.prev = prevNode;
            size++;

           
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
            ListNode prevNode = getPrev(index);
            ListNode curr = prevNode.next;
            ListNode nextNode = curr.next; 

            nextNode.prev = prevNode; 
            prevNode.next = nextNode;
            size--;
        
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