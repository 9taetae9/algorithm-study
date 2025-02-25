package org.example;

import java.io.IOException;

class TodayAlgorithm {
    public static void main(String[] args) throws IOException {
        //지폐 접기 - 340199
        solution(new int[]{30, 15},	new int[]{26, 17});
        solution(new int[]{50, 50},	new int[]{100, 241});
    }
    public static int solution(int[] wallet, int[] bill) {
        int count = 0;
        int walletBig = Math.max(wallet[0], wallet[1]);
        int walletSmall = Math.min(wallet[0], wallet[1]);
        int billBig = Math.max(bill[0], bill[1]);
        int billSmall = Math.min(bill[0], bill[1]);
        while ( walletBig < billBig || walletSmall < billSmall) {
            //지갑 크기는 가만히
            //지폐 크기가 swap하면서 큰 건 절반으로
            int[] swap = swap(billBig, billSmall);
            billBig = swap[0];
            billSmall = swap[1];
            count++;
        }
        System.out.println("count = " + count);
        return count;
    }
    public static int[] swap(int beforeBig, int beforeSmall){
        beforeBig /= 2;
        if( beforeBig < beforeSmall){
            int temp = beforeBig;
            beforeBig = beforeSmall;
            beforeSmall = temp;
        }
        return new int[]{beforeBig,beforeSmall};
    }


}
