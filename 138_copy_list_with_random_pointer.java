/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> randomMap = new HashMap<>();
        Node dummy = new Node();
        Node p = dummy;
        Node q = head;
        while (q != null) {
            p.next = new Node(q.val, null, null);

            randomMap.put(q, p.next);   // <original node, deep-copied node> ex. {1 -> 1}, {2 -> 2}

            p = p.next;
            q = q.next;
        }
        p = dummy;
        q = head;
        while (q != null) {
            // q.random represents original random node, and queried value is the deep-copied node
            p.next.random = randomMap.get(q.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
}
