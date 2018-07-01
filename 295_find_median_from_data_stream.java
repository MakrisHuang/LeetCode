class MedianFinder {

    private Queue<Long> small = new PriorityQueue(),
                        large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
               ? large.peek()
               : (large.peek() - small.peek()) / 2.0;
    }

//     List<Integer> arr;

//     public MedianFinder() {
//         arr = new ArrayList<Integer>();
//     }

//     public void addNum(int num) {
//         int start = 0, end = arr.size() - 1;
//         int insertIdx = 0;

//         while (start <= end) {
//             if (num > arr.get(end)) {
//                 insertIdx = end + 1;
//                 break;
//             }
//             if (num < arr.get(start)) {
//                 insertIdx = (start - 1 >= 0) ? start - 1 : 0;
//                 break;
//             }

//             int midIdx = start + (end - start) / 2;
//             if (num > arr.get(midIdx)) {
//                 start = midIdx + 1;
//                 insertIdx = start;
//             } else if (num < arr.get(midIdx)) {
//                 end = midIdx - 1;
//                 insertIdx = end + 2;
//             } else {
//                 insertIdx = midIdx;
//                 break;
//             }
//         }
//         System.out.println("insertIdx = " + insertIdx);

//         this.arr.add(insertIdx, num);
//         print();
//     }

//     public double findMedian() {
//         int size = this.arr.size();
//         int idx = size / 2;
//         if (size % 2 == 1) {
//             return this.arr.get(idx);
//         }
//         else {
//             int next = this.arr.get(idx);
//             int prev = this.arr.get(idx - 1);
//             return (next + prev) / 2.0;
//         }
//     }

//     private void print() {
//         for (Integer i: this.arr) {
//             System.out.print(i + " ");
//         }
//         System.out.println();
//     }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
