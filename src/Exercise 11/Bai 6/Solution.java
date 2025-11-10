public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    List<Double> result = new ArrayList<>();

    for (int num : a) {
        if (maxPQ.isEmpty() || num <= maxPQ.peek()) maxPQ.add(num);
        else minPQ.add(num);

        if (maxPQ.size() > minPQ.size() + 1) minPQ.add(maxPQ.poll());
        else if (minPQ.size() > maxPQ.size() + 1) maxPQ.add(minPQ.poll());

        double median;
        if (maxPQ.size() == minPQ.size())
            median = (maxPQ.peek() + minPQ.peek()) / 2.0;
        else if (maxPQ.size() > minPQ.size())
            median = maxPQ.peek();
        else
            median = minPQ.peek();

        result.add(median);
    }

    return result;
}
