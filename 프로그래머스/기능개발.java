import java.util.*;

public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        // 반복문으로 처음부터 날짜 기록
        // 이전 날짜보다 짧으면 이전 날짜 +speeds[i]
        // 아니면 이전 날짜 스택에 푸쉬
        for (int i = 0; i < progresses.length; i++) {
            ans.add((100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i] :
                    (100 - progresses[i]) / speeds[i] + 1);
        }

        int count = 1;
        int preNum = ans.get(0);
        for (int i = 1; i < ans.size(); i++) {
            int num = ans.get(i);
            if (preNum >= num) {
                count++;
            } else {
                result.add(count);
                count = 1;
                preNum = num;
            }
        }
        result.add(count);
        answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
