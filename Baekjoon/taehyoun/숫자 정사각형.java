public class BOJ1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr= new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int cand = Math.min(N, M);

        while(cand > 1) {
            for (int i = 0; i + cand - 1 < N; i++) {
                for (int j = 0; j + cand - 1 < M; j++) {
                    if(arr[i].charAt(j) == arr[i+cand-1].charAt(j) && arr[i].charAt(j) == arr[i+cand-1].charAt(j+cand-1) && arr[i].charAt(j) == arr[i].charAt(j+cand-1)){
                        System.out.println(cand*cand);
                        return;
                    }
                }
            }
            cand--;
        }

        System.out.println(1);
    }
}
