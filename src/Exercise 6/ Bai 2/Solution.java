public static int introTutorial(int V, List<Integer> arr) {
    int left = 0;
    int right = arr.size() - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr.get(mid) == V) {
            return mid;
        } else if (arr.get(mid) < V) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}