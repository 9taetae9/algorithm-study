//통과 풀이
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();

        int top = 0, bot = matrix.length-1, left = 0, right = matrix[0].length-1;

        while(top <= bot && left <= right){
            if(left <= right){
                int i = left;
                while(i <= right){
                    arr.add(matrix[top][i++]);
                }
            }else break;
            top++;

            if(top <= bot){
                int i = top;
                while(i <= bot){
                    arr.add(matrix[i++][right]);
                }
            }else break;
            right--;

            if(left <= right){
                int i = right;
                while(i >= left){
                    arr.add(matrix[bot][i--]);
                }
            }else break;
            bot--;

            if(top <= bot){
                int i = bot;
                while(i >= top){
                    arr.add(matrix[i--][left]);
                }
            }
            left++;
        } 

        return arr;
    }
}



//최적화
/*
왼쪽→오른쪽 순회와 오른쪽 열의 위→아래 순회는 해당 경계가 유효하다면 반드시 진행되어야 한다.
아직 경계값을 업데이트하기 전이라서 추가 검증 없이 for문만으로 안전하게 순회가 가능
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();

        int top = 0, bot = matrix.length-1, left = 0, right = matrix[0].length-1;

        while(top <= bot && left <= right){
            for(int i=left; i<=right; i++){
                arr.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<=bot; i++){
                arr.add(matrix[i][right]);
            }
            right--;


            if(top <= bot){
               for(int i=right; i>=left; i--){
                arr.add(matrix[bot][i]);
               }
            }
            bot--;

            if(left <= right){
                for(int i=bot; i>=top; i--){
                    arr.add(matrix[i][left]);
                }
            }
            left++;
        } 

        return arr;
    }
}
