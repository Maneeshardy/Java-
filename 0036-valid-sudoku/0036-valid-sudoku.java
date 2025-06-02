class Solution {
    public boolean isValidSudoku(char[][] nums) {
        Set<String>set=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=nums[i][j];
                if(c!='.'){
                    if(!set.add(c+"in row"+i)||!set.add(c+"in col"+j)||!set.add(c+"block"+i/3+"-"+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}