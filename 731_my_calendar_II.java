class MyCalendarTwo {

    class Node {
        int start;
        int end;
        Node (int start, int end) {this.start = start; this.end = end;}
    }

    List<Node> calendar;
    List<Node> duplicated;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        duplicated = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (Node prev: duplicated) {
            if (prev.start < end && start < prev.end) return false;
        }

        for (Node prev: calendar) {
            if (prev.start < end && start < prev.end) {
                duplicated.add(new Node(Math.max(prev.start, start),
                                        Math.min(prev.end, end)));
            }
        }
        calendar.add(new Node(start, end));
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
