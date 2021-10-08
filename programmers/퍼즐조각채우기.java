package programmers;

import java.util.*;

/**
 * 퍼즐 조각 채우기
 * https://programmers.co.kr/learn/courses/30/lessons/84021
 */
public class 퍼즐조각채우기 {
    public static void main(String[] args) {
        int[][] game_board = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        System.out.println(solution(game_board, table));
    }

    static class Block {
        int r, c;

        public Block(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Piece {
        int cnt;
        int size;

        public Piece(int cnt, int size) {
            this.cnt = cnt;
            this.size = size;
        }
    }

    static Map<String, Piece> pieces = new HashMap<>();
    static List<Block> blocks;
    static int size = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        for (int r = 0; r < game_board.length; r++) {
            for (int c = 0; c < game_board.length; c++) {
                game_board[r][c] = game_board[r][c] == 0 ? 1 : 0;
            }
        }
        for (int r = 0; r < game_board.length; r++) {
            for (int c = 0; c < game_board.length; c++) {
                if (game_board[r][c] == 1) {
                    String key = bfs(game_board, r, c);
                    Piece piece = pieces.getOrDefault(key, new Piece(0, size));
                    piece.cnt++;
                    pieces.put(key, piece);
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            table = rotate(table);
            int[][] cloneTable = new int[table.length][table.length];
            for (int r = 0; r < table.length; r++) {
                cloneTable[r] = table[r].clone();
            }
            for (int r = 0; r < cloneTable.length; r++) {
                for (int c = 0; c < cloneTable[r].length; c++) {
                    if (cloneTable[r][c] == 1) {
                        String key = bfs(cloneTable, r, c);
                        if (pieces.containsKey(key)) {
                            for (Block block : blocks) {
                                table[block.r][block.c] = 0;
                            }
                            Piece b = pieces.get(key);
                            answer += b.size;
                            if (--b.cnt == 0) {
                                pieces.remove(key);
                            } else {
                                pieces.put(key, b);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static String bfs(int[][] map, int r, int c) {
        Queue<Block> q = new LinkedList<>();
        int R = map.length;
        int C = map[0].length;

        blocks = new ArrayList<>();
        q.offer(new Block(r, c));
        map[r][c] = 0;
        size = 0;
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = 0;
        int maxC = 0;

        while (!q.isEmpty()) {
            Block cur = q.poll();
            minR = Math.min(cur.r, minR);
            minC = Math.min(cur.c, minC);
            maxR = Math.max(cur.r, maxR);
            maxC = Math.max(cur.c, maxC);

            size++;
            blocks.add(new Block(cur.r, cur.c));
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (!isIn(nr, nc, R, C)) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    continue;
                }
                map[nr][nc] = 0;
                q.offer(new Block(nr, nc));
            }
        }
        return makeBlock(minR, minC, maxR, maxC);
    }

    static String makeBlock(int minR, int minC, int maxR, int maxC) {
        int[][] arr = new int[maxR - minR + 1][maxC - minC + 1];
        for (Block b : blocks) {
            arr[b.r - minR][b.c - minC] = 1;
        }

        StringBuilder result = new StringBuilder();
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                result.append(arr[r][c]);
            }
            result.append("n");
        }
        return result.toString();
    }

    static boolean isIn(int r, int c, int R, int C) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    static int[][] rotate(int[][] block) {
        int[][] newBlock = new int[block.length][block.length];
        for (int r = 0; r < block.length; r++)
            for (int c = 0; c < block.length; c++)
                newBlock[c][block.length - r - 1] = block[r][c];
        return newBlock;
    }
}

