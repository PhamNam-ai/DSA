public static void insertionSort1(int n, List<Integer> arr) {
    int value = arr.get(n - 1);
    int i = n - 2;

    while (i >= 0 && arr.get(i) > value) {
        arr.set(i + 1, arr.get(i));
        printArray(arr);
        i--;
    }

    arr.set(i + 1, value);
    printArray(arr);

}
public static void printArray(List<Integer> arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}