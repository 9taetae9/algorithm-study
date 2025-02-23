public class study2 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<Integer> list = new ArrayList<Integer>();
    List<Double> answer = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        //left right 자식들만 큐에 넣어서 list에 넣기?
        if (root == null) return null;
        System.out.println("root = " + root.val);
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
                list.add(poll.val);
            }
            long sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            System.out.println("sum = " + sum);
            answer.add((double) sum / list.size());
            list.clear();
        }
        return answer;
    }

    
}
