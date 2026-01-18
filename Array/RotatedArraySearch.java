public class RotatedArraySearch {

    // Main search function
    public int search(int[] nums, int target) {
        int min = minSearch(nums); // index of minimum element

        // Search in right sorted part
        if (nums[min] <= target && target <= nums[nums.length - 1]) {
            return binarySearch(nums, min, nums.length - 1, target);
        }
        // Search in left sorted part
        else {
            return binarySearch(nums, 0, min - 1, target);
        }
    }

    // Find index of minimum element (pivot)
    private int minSearch(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Normal binary search
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // Test
    public static void main(String[] args) {
        RotatedArraySearch obj = new RotatedArraySearch();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(obj.search(nums, target)); // Output: 4
    }
}
