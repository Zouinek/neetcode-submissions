class Solution {
    public int[] replaceElements(int[] arr) {
        int replacement = 0;
        for(int i = 0; i < arr.length; i++) {
            
            for (int j = i + 1; j < arr.length; j++) {       
                    replacement = Math.max(replacement,arr[j]);     
            }
            if ( i + 1 < arr.length ) {
                arr[i] = replacement;
            }else {
                arr[i] = -1;
            }
            replacement  = 0;
        }
        return arr;
    }

    
}