public static int cookies(int k, List<Integer> A) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(A);
    int cnt = 0;
    while(pq.size() > 1 && pq.peek() < k){
        int m1 = pq.poll();
        int m2 = pq.poll();
        pq.add(m1 + 2 * m2);
        cnt++;
    }
    return pq.peek() >= k ? cnt : -1;

}