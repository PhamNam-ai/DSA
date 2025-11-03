public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Đảo ngược danh sách để lấy từ dưới lên dễ hơn
    Collections.reverse(h1);
    Collections.reverse(h2);
    Collections.reverse(h3);

    int sum1 = h1.stream().mapToInt(Integer::intValue).sum();
    int sum2 = h2.stream().mapToInt(Integer::intValue).sum();
    int sum3 = h3.stream().mapToInt(Integer::intValue).sum();

    // Dùng stack thật sự (LinkedList) để pop nhanh
    Deque<Integer> s1 = new ArrayDeque<>(h1);
    Deque<Integer> s2 = new ArrayDeque<>(h2);
    Deque<Integer> s3 = new ArrayDeque<>(h3);

    // Lặp cho đến khi bằng nhau hoặc một chồng rỗng
    while (true) {
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) return 0;

        if (sum1 == sum2 && sum2 == sum3) return sum1;

        // Tìm chồng cao nhất và pop bớt
        if (sum1 >= sum2 && sum1 >= sum3) sum1 -= s1.removeLast();
        else if (sum2 >= sum1 && sum2 >= sum3) sum2 -= s2.removeLast();
        else sum3 -= s3.removeLast();
    }
}
