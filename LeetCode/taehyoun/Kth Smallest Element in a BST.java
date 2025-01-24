//첫 풀이 재귀
class Solution {
    int cnt; 
    int res;
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return res;
    }

    public void inOrderTraversal(TreeNode node, int k){
        if(node == null) return;

        inOrderTraversal(node.left, k);
        
        cnt++;
        if(cnt == k){
            res = node.val;
            return ;
        }

        inOrderTraversal(node.right, k);
    }
}
/*
재귀 중위 순회 방식
코드가 직관적이고 짧다.
inOrderTraversal(node.left) → 현재 노드 방문 → node.right 순으로 진행하여, k번째 값을 찾으면 해당 함수에서 return을 실행한다.
다만, 하위 함수에서 return이 일어나도 부모 함수(상위 스택)에서는 이미 호출한 지점 이후 부분을 수행하므로, 완전히 재귀 트리를 끊지 못할 수 있다.

(추가로 전역 플래그 등을 사용하면 어느 정도 조기 끝내기가 가능하긴 하다). => 마지막 코드 참고
재귀 깊이는 트리의 높이에 비례하므로, 최악의 경우(한쪽으로 매우 치우친 트리) 스택 오버플로우 가능성이 미미하지만 존재한다.
*/

//stack 방식 
class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode current = root;

            while (true) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                k--;
                if (k == 0) {
                    return current.val;
                }
                current = current.right;
            }
      }
}
/*
반복문을 사용하기 때문에 함수 호출로 인한 재귀 스택 사용량이 줄어든다.
각 단계에서 직접 while문 안에서 k의 값을 확인하고, k가 0이 되면 함수를 즉시 종료하므로, 재귀 호출의 잔여 부분을 진행하는 일이 발생하지 않는다.
일반적으로 재귀 방식보다 코드가 조금 길어질 수 있다.
*/


// (재귀) - 조기 종료를 위한 found 플래그 추가 
class Solution {
    int cnt; 
    int res;
    boolean found;
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return res;
    }

    public void inOrderTraversal(TreeNode node, int k){
        if (node == null || found) return;

        inOrderTraversal(node.left, k);
        
        if(!found){
            cnt++;
            if(cnt == k){
                found = true;
                res = node.val;
                return ;
            }
        }

        inOrderTraversal(node.right, k);
    }
}
/*
두 방법 모두 시간 복잡도와 공간 복잡도(트리 높이 이하의 스택/재귀 깊이) 측면에서 본질적으로 유사하다.
재귀 방식은 구현이 간단하지만 찾은 뒤에도 상위 호출 스택이 남아 있어 어느 정도 추가 연산이 발생할 수 있다.
반복문+스택 방식은 스택의 크기를 제어할 수 있어, 필요할 때 즉시 중단하기가 재귀 방식보다 직관적이라는 장점이 있다.
따라서 특별한 성능 차이는 크지 않으나, 매우 깊은 트리이거나 재귀를 피하고 싶다면 스택 방식을, 코드 단순성을 원한다면 재귀 방식을 선호할 수 있다.
*/
