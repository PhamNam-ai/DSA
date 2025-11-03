public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= 3; i++) {
        for (int j = 0; j <= 3; j++) {
            int sum = 0;
            sum += arr.get(i).get(j);
            sum += arr.get(i).get(j+1);
            sum += arr.get(i).get(j+2);
            sum += arr.get(i+1).get(j+1);
            sum += arr.get(i+2).get(j);
            sum += arr.get(i+2).get(j+1);
            sum += arr.get(i+2).get(j+2);

            if (sum > max) max = sum;
        }
    }
    return max;

}