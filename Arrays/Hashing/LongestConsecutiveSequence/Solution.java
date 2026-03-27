import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n  = nums.length;
        int longest = 0;
        if(n==0) return 0;

        Set<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }

        for(int it : st){
            if(!st.contains(it - 1)){
                int cnt = 1;
                int x = it;

                while(st.contains(x + 1)){
                    x = x + 1;
                    cnt = cnt + 1;
                }

                longest = Math.max(cnt, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int result = obj.longestConsecutive(nums);

        System.out.println(result);

        sc.close();
    }
}