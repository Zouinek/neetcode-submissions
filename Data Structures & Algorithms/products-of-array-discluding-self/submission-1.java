class Solution {
    public int[] productExceptSelf(int[] nums) {

        
        int[] productLeftPrefix = new int[nums.length];
        int[] productRightPrefix = new int[nums.length];
        int[] productPrefix = new int[nums.length];
        
        productLeftPrefix[0] = 1;
        productRightPrefix[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            productLeftPrefix[i] = nums[i - 1] * productLeftPrefix[i - 1];
        }

        for(int i = nums.length - 2; i >= 0; i--) {    
            productRightPrefix[i] = nums[i + 1] * productRightPrefix[i + 1];
        }

        for(int i = 0; i < nums.length; i++) {
            productPrefix[i] =  productLeftPrefix[i] * productRightPrefix[i];
        }

        return productPrefix;
    }
}  
