class Solution {
    public static String solution(int[] numbers, String hand) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int currentLeft = 10;
        int currentRight = 12;
        int left = 0;
        int rignt = 0;

        int lx = (currentLeft - 1) / 3;
        int rx = (currentRight - 1) / 3;
        int ly = 0, ry = 2;

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                lx = (num - 1) / 3;
                ly = 0;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rx = (num - 1) / 3;
                ry = 2;
            } else {
                if (num == 0) num = 10;

                left = distance(lx, ly, (num - 1) / 3, 1);
                rignt = distance(rx, ry, (num - 1) / 3, 1);

                if (left < rignt) {
                    sb.append("L");
                    lx = (num - 1) / 3;
                    ly = 1;
                } else if (left > rignt) {
                    sb.append("R");
                    rx = (num - 1) / 3;
                    ry = 1;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rx = (num - 1) / 3;
                        ry = 1;
                    } else {
                        sb.append("L");
                        lx = (num - 1) / 3;
                        ly = 1;
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }

    public static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
