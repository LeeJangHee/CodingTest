import java.util.*;
class Solution {
    static HashMap<String, String> user = new HashMap<>();
    static ArrayList<String> arr = new ArrayList<>();
    public static String[] solution(String[] record) {
        String[] answer;
        String[][] chat = new String[record.length][3];
        // 나누기
        for (int i = 0; i < record.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(record[i], " ");
            int j = 0;
            while (tokenizer.countTokens() > 0) {
                chat[i][j] = tokenizer.nextToken();
                j++;
            }
        }

        for (int i = 0; i < chat.length; i++) {
            // 유저정보 등록
            setUser(chat[i][0], chat[i][1], chat[i][2]);
        }

        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            int idx = arr.get(i).indexOf("님");
            String id = arr.get(i).substring(0,idx);
            String[] temp = arr.get(i).split(" ");
            answer[i] = user.get(id) + "님이 "+temp[1];
        }

        return answer;
    }

    public static void setUser(String state, String id, String name){
        if (state.equals("Enter")) {
            // 들어올 때
            user.put(id, name);
            arr.add(id+"님이 들어왔습니다.");
        } else if (state.equals("Change")) {
            // 이름변경
            user.put(id, name);
        } else {
            // 나갈때
            arr.add(id+"님이 나갔습니다.");
        }
    }
}
