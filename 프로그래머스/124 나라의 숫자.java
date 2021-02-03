class Solution {
    public String solution(int n) {
        String answer = "";
        String[] count = {"4", "1", "2"};

        while (n > 0) {
            int x = n % 3;
            n /= 3;

            if (x == 0) {
                n--;
            }

            answer = count[x] + answer;
        }

        return answer;
    }
}
