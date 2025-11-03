public static List<Integer> countingSort(List<Integer> arr) {
    int[] count = new int[100];
    for(int num : arr) {
        count[num]++;
    }
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < 100; i++){
        for(int j = 0; j < count[i]; j++){
            result.add(i);
        }
    }
    return result;
    // Write your code here

}