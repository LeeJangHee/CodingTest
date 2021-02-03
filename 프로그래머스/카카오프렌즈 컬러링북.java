import java.util.*;
class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited = new boolean[101][101];
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0) continue;

                answer[1] = Math.max(answer[1], bfs(i, j, m, n, picture));
                answer[0]++;
            }
        }

        return answer;
    }
    public int bfs(int x, int y, int m, int n, int[][] arr) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (arr[nx][ny] == 0) continue;

                if (arr[nx][ny] == arr[x][y] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    count++;
                }
            }
        }
        return count;
    }
}
