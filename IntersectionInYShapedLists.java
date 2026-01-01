/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        if (head1 == null || head2 == null) return null;
        
        Node pointer1 = head1;
        Node pointer2 = head2;
        
        while (pointer1 != pointer2) {
            pointer1 = (pointer1 == null) ? head2 : pointer1.next;
            pointer2 = (pointer2 == null) ? head1 : pointer2.next;
        }
        
        return pointer1;
    }
}