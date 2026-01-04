/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class FlatteningaLinkedList {
    public Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        
        root.next = flatten(root.next);
        
        root = merge(root, root.next);
        
        return root;
    }
    
    private Node merge(Node a, Node b) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        
        while(a != null && b != null) {
            if (a.data <= b.data) {
                tail.bottom = a;
                a = a.bottom;
            } else {
                tail.bottom = b;
                b = b.bottom;
            }
            tail = tail.bottom;
        }
        
        tail.bottom = (a != null) ? a : b;
        return dummy.bottom;
    }
}