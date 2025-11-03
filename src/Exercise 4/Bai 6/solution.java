public static int pairs(int k, List<Integer> arr) {
    // Write your code here
    Set<Integer> set = new HashSet<>(arr);
    int count = 0;
    for (int x : arr) {
        if (set.contains(x + k)) count++;
    }
    return count;

}