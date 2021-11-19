package ddeliopoulos.github.example;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber hs = new HouseRobber();
        int[] houses = {2, 7, 9, 3, 1};

        System.out.println(hs.rob(houses));
    }


    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] arr = new int[nums.length];

        arr[0] = nums[0];
        arr[1] =  Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; ++i){
            arr[i] = Math.max(arr[i-1], arr[i-2] + nums[i]);
        }
        return arr[arr.length-1];
    }
}
