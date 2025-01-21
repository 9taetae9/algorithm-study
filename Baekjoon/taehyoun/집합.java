//처음 코드
//메모리 : 310096KB, 시간 : 1212ms => boolean 배열 사용시 1164ms
public class Main {
    static final List<Integer> AllNumbers =
            IntStream.rangeClosed(1,20)
                    .boxed()
                    .collect(Collectors.toList());

    static Set<Integer> S = new HashSet<>(20);
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");

            if(query[0].equals("all")){
                S.addAll(AllNumbers);
                continue;
            }
            if(query[0].equals("empty")){
                S.clear();
                continue;
            }

            Integer n = Integer.parseInt(query[1]);
            switch (query[0]){
                case "add":
                    S.add(n);
                    break;
                case "remove":
                    S.remove(n);
                    break;
                case "check" :
                    sb.append(S.contains(n) ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    if(S.contains(n)){
                        S.remove(n);
                    }else S.add(n);
                    break;
            }
        }
        System.out.println(sb);
    }
}

//비트마스크 활용 코드
//메모리 : 326328KB, 시간 : 1200ms
public class BOJ11723 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int S = 0; // 비트마스크

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");

            switch (query[0]) {
                case "all" :
                    S = (1<<21) - 1;// 1 ~ 20 까지 모든 비트 1로 설정
                    continue;
                case "empty" :
                    S = 0;
                    continue;
            }

            int n = Integer.parseInt(query[1]);
            int mask = 1 << n;

            switch (query[0]){
                case "add" :
                    S |= mask; // n번쨰 비트 1로 설정
                    break;
                case "remove" :
                    S &= ~mask; //n번째 비트 0으로 설정
                    break;
                case "check" :
                    sb.append((S & mask) != 0 ? "1\n" : "0\n");// n번째 비트 확인
                    break;
                case "toggle" :
                    S ^= mask; // n 번째 비트 뒤집기
                    break;
            }
        }
        System.out.println(sb);
    }
}
