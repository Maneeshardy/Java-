class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max=0;
        boolean center = false;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(!map.containsKey(ch))
            {
                map.put(ch,1);
            }
            else
            {
                map.put(ch,map.get(ch)+1);
            }
        }

        for(char key: map.keySet())
        {
            int count = map.get(key);
            if(count%2==0)
            {
                max+=count;
            }
            else
            {
                int freq = count-1;
                max+=freq;
                center = true;
            }
        }
        if(center)
        {
            max+=1;
        }
        return max;
    }
}
