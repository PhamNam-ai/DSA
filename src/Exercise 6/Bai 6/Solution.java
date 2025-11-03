public static List<Integer> countingSort(List<Integer> arr) {
    int[] cnt = new int[100];
    for(int num : arr){
        cnt[num]++;
    }
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < 100; i++){
        result.add(cnt[i]);
    }
    return result;
}
