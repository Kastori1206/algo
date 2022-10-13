package programmers;

public class 아이템_줍기 {
    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4},
                {3, 2, 5, 5,},
                {4, 3, 6, 9},
                {2, 6, 8, 8}};
        System.out.println(solution(rectangle, 1, 3, 7, 8));
    }

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean[][] map;
    static boolean[][] visited;
    static int answer;
    static public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = Integer.MAX_VALUE;
        map = new boolean[100 + 2][100 + 2];
        visited = new boolean[100 + 2][100 + 2];

        for (int i = 0; i < rectangle.length; i++) {
            draw(map, rectangle[i]);
        }

        dfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2, 0);

        return answer/2;
    }

    private static void dfs(int sr, int sc, int er, int ec, int cnt) {
        if (sr == er && sc == ec) {
            answer = Math.min(answer, cnt);
            return;
        }
        if (answer <= cnt || !check(sr, sc)) {
            return;
        }
        visited[sr][sc] = true;
        for (int d = 0; d < 4; d++) {
            int nr = sr + dr[d];
            int nc = sc + dc[d];

            dfs(nr, nc, er, ec, cnt + 1);
        }
        visited[sr][sc] = false;
    }

    private static boolean check(int r, int c) {
        if (visited[r][c] || !map[r][c]) {
            return false;
        }
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!map[nr][nc]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r <= 100 && c <= 100;
    }

    private static void draw(boolean[][] map, int[] rect) {
        int sr = rect[1] * 2;
        int sc = rect[0] * 2;
        int er = rect[3] * 2;
        int ec = rect[2] * 2;
        for (int r = sr; r <= er; r++) {
            for (int c = sc; c <= ec; c++) {
                map[r][c] = true;
            }
        }
    }


}
