import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int[] res = new int[photo.length];
        
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                //sum += map.get(photo[i][j]); => NullPointerException 발생 
                sum += map.getOrDefault(photo[i][j], 0); //수정
            }
            res[i] = sum;
        }
        return res;
    }
}
Exception in thread "main" java.lang.NullPointerException
	at Solution.solution(Unknown Source)
	at SolutionTest.lambda$main$0(Unknown Source)
	at SolutionTest$SolutionRunner.run(Unknown Source)
	at SolutionTest.main(Unknown Source)
