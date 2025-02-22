//첫 풀이
import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        for(int i = mats.length - 1; i >=0; i--){
            for(int x = 0; x < park.length; x++){
                for(int y = 0; y < park[0].length; y++){
                    if(isEmpty(x,y,mats[i],park)) return mats[i];
                }
            }
        }

        return -1;
    }

    private boolean isEmpty(int startX, int startY, int len, String[][] park){
        if(startX + len > park.length) return false;
        if(startY + len > park[0].length) return false;

        for(int i=startX; i < startX+len; i++){
            for(int j=startY; j<startY+len; j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
}

//최적화
/*
유효 시작점 범위 제한
현재는 park의 모든 좌표를 순회하면서 isEmpty 메서드에서 경계 체크를 수행
mats[i] 길이의 돗자리를 놓을 수 있는 시작점은 x좌표는 0부터 park.length - mats[i]까지, y좌표는 0부터 park[0].length - mats[i]
→ 외부 반복문에서 미리 범위를 제한하여 isEmpty 호출 횟수를 줄일 수 있다.
*/
import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        for(int i = mats.length - 1; i >=0; i--){
            int L = mats[i];
            for(int x = 0; x <= park.length - L ; x++){
                for(int y = 0; y <= park[0].length - L; y++){
                    if(isEmpty(x,y,L,park)) return L;
                }
            }
        }
        
        return -1;
    }

    private boolean isEmpty(int startX, int startY, int len, String[][] park){
        // if(startX + len > park.length) return false;
        // if(startY + len > park[0].length) return false; → 호출 전 필터링

        for(int i=startX; i < startX+len; i++){
            for(int j=startY; j<startY+len; j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
}
