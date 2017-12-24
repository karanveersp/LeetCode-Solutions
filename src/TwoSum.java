import java.util.Map;
import java.util.HashMap;

public class TwoSum {


    // my first accepted solution
    public static int[] twoSumOriginal(int[] nums, int target) {

        int[] result = new int[2];
        boolean finished = false;

        for (int i = 0; i < nums.length; i++){

            for (int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if (sum == target){
                    result[0] = i;
                    result[1] = j;
                    finished = true;
                    break;
                }
            }
            if (finished) break;
        }

        return result;
    }

    // cleaner return
    public static int[] twoSumBruteForce (int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (target == nums[i] + nums[j]){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // runs in constant time
    public static int[] twoSumHash(int[] nums, int target){
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (numbers.containsKey(complement) && numbers.get(complement) != i){
                return new int[] {numbers.get(complement), i};
            }
            numbers.put(nums[i], i);
        }
        return null;
    }

    // test case
    public static void main(String[] args) {
        int[] input = new int[]{2,3,4,5,6,100};
        int target = 104;
        int[] result = twoSumHash(input, target);
        if (result == null)
            System.out.println("Error! No sum pairs in the array!");
        else {
            System.out.println("{" + result[0] + ", " + result[1] + "}");
        }
    }
}