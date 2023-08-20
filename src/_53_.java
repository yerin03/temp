import java.util.Arrays;

public class _53_ {


    public static int[] parent;

    public int solution(int n, int[][] costs) {

        // 1. 비용에 따라 오름차순으로 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        // 2.Union-Find 초기화 (자기 자신으로 초기화)
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }


        // 3. 크루스칼 알고리즘
        int answer = 0;
        int bridgeCount = 0;

        // 비용이 적은 다리부터 선택하고, 두 다리가 연결 되어 있지 않다면,
        for (int[] cost : costs) {
            if (union(cost[0], cost[1])) {
                answer += cost[2]; //비용 더하고
                bridgeCount++; //다리 추가
            }

            if (bridgeCount == n - 1) break; //모든 섬이 연결된 경우
        }

        return answer;
    }

    // 최상위 부모(root)섬을 찾아 반환하는 함수
    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }


    //a,b 를 연결하는 함수
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false; //이미 연결 되어 있다면 false 반환

        parent[rootA] = rootB;
        return true;
    }

    public static void main(String[] args) {
        _53_ sol = new _53_();
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(sol.solution(n, costs));  // Expected output: 4
    }
}
