import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); 

        int n = Integer.parseInt(sc.nextLine()); 

        Set<Integer> set = new TreeSet<>();  

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" "); 
            String command = s[0];  

            if (command.equals("empty")) {
                set.clear(); 
                continue;  
            } else if(command.equals("all")) {
                for(int j = 1; j <= 20; j++) {
                    set.add(j); 
                }
                continue; 
            }
            int num = Integer.parseInt(s[1]); 

            switch (command) {
                case "add":
                    set.add(num); 
                    break;

                case "check":
                    if (set.contains(num)) {
                        sb.append("1\n");  
                    } else {
                        sb.append("0\n");  
                    }
                    break;

                case "remove":
                    set.remove(num); 
                    break;

                case "toggle":
                    if (set.contains(num)) {
                        set.remove(num); 
                    } else {
                        set.add(num);  
                    }
                    break;
            }
        }

        System.out.print(sb.toString());