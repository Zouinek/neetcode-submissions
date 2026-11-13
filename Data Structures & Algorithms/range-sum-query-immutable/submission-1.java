class NumArray {

    private int[] sums; 

    public NumArray(int[] nums) {    
        
        sums = new int[nums.length];  
        int total = 0;

        for(int i = 0; i < nums.length; i++) {
              total  += nums[i];
              sums[i] = total;       
        }
        
    }
    
    public int sumRange(int left, int right) {
        

        int preLeft  =  left > 0  ? sums[left - 1] : 0;
        int preRight = sums[right];

        return preRight - preLeft;
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */