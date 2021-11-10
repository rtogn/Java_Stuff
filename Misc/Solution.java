import java.util.HashMap;
class Solution {
    public static int[] twoSum(int[] nums, int target) {
      for(int i = 0; i < nums.length; i++) {
         for(int j = i+1; j < nums.length; j++) {
            if(nums[i] + nums[j] == target)     
               return new int[]{i, j};         
         } //end for2       
    }//end for1 
    return null;  
   } //end method
   
   public static int[] twoSum2(int[] nums, int target) {
      HashMap<Integer, Integer> hmap = new HashMap<>();
      for(int i = 0; i < nums.length; i++) {
         int t = target - nums[i];
         if(hmap.containsKey(t)) {
            return new int[] {hmap.get(t), i};
         }
         hmap.put(nums[i], i);
      } return null;
   }

   public static void main (String[] args) {
      int[] q = {2,7,11,15};
         int[] x = twoSum2(q, 9);
         for (int i: x) System.out.println(i);
         Integer f = null;
         Integer z = f;
         System.out.println(6/10);
   
            
      }   
   
}