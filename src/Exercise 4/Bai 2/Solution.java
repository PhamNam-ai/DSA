public static List<Integer> reverseArray(List<Integer> a) {
    // Write your code here
    List<Integer> reversed = new ArrayList<>();
    for (int i = a.size() - 1; i >= 0; i--) {
        reversed.add(a.get(i));
    }
    return reversed;

}