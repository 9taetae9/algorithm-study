class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health;
        int curHealth = health;
        int cnt = 0;
        int attackIdx = 0;
        int curIdx = 0;
        int attackCnt = attacks.length - 1;

        while(true){
            curIdx++;
            if(attacks[attackIdx][0] == curIdx){
                cnt = 0;
                curHealth -= attacks[attackIdx][1];
                if(curHealth <= 0){
                    answer = -1;
                    break;
                }else{
                    if(attackCnt == attackIdx){
                        answer = curHealth;
                        break;
                    }
                    attackIdx++;
                    continue;
                }
            }

            cnt++;
            if(cnt < bandage[0]){
                curHealth += bandage[1];
            }else{
                curHealth += (bandage[1] + bandage[2]);
                cnt = 0;
            }

            curHealth = curHealth > maxHealth ? maxHealth : curHealth;
        }


        return answer;
    }
}
