public static String balancedSums(List<Integer> arr) {
    // Write your code here
    int totalSum = 0;
    for (int num : arr) totalSum += num;

    int leftSum = 0;
    for (int i = 0; i < arr.size(); i++) {
        int rightSum = totalSum - leftSum - arr.get(i);
        if (leftSum == rightSum) {
            return "YES";
        }
        leftSum += arr.get(i);
    }
    return "NO";

}