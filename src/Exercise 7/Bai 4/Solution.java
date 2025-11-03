public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here
    int pivot = arr.get(0);

    List<Integer> left = new ArrayList<>();
    List<Integer> equal = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    for (int x : arr) {
        if (x < pivot) left.add(x);
        else if (x == pivot) equal.add(x);
        else right.add(x);
    }

    List<Integer> result = new ArrayList<>();
    result.addAll(left);
    result.addAll(equal);
    result.addAll(right);

    return result;

}
