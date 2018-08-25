public class Vector2D implements Iterator<Integer> {

    Queue<Integer> queue;

    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<>();
        for (List<Integer> list: vec2d) {
            for (Integer num: list) {
                queue.offer(num);
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return ! queue.isEmpty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
