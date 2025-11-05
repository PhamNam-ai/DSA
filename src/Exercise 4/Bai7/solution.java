import java.util.Arrays;

public class ThreeSumQuadratic {
    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        threeSum(nums);
    }

    public static void threeSum(int[] nums) {
        Arrays.sort(nums);  // Bước 1: sắp xếp mảng : O(N log N)
        int n = nums.length;

        System.out.println("Các bộ ba có tổng = 0:");
        for (int i = 0; i < n - 2; i++) {
            // Bỏ qua phần tử trùng lặp
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    System.out.println(nums[i] + ", " + nums[left] + ", " + nums[right]);

                    // Bỏ qua các phần tử trùng lặp
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
Vòng for (i) có N lần, mỗi lần inner while(left<right) di chuyển left và right tối đa tổng cộng O(N) (amortized).
        => O(N²) tổng thể.