import java.util.*;

class Solution {
      public static int solution(String str1, String str2) {
        // 집합만들기
        ArrayList<String> a, b;
        a = getArray(str1.toLowerCase());
        b = getArray(str2.toLowerCase());

        Collections.sort(a);
        Collections.sort(b);

        ArrayList<String> insert = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        // 교집합, 합집합
        for (String s : a) {
            if (b.remove(s)) {
                insert.add(s);
            }
            union.add(s);
        }
        union.addAll(b);

        double jakard = 0;

        if (union.size() == 0) {
            jakard = 1;
        } else{
            jakard = (double) insert.size() / (double) union.size();
        }

        return (int)(jakard * 65536);
    }

    public static ArrayList<String> getArray(String str) {
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i+1);
            if ('a' <= ch1 && ch1 <= 'z' &&
                    'a' <= ch2 && ch2 <= 'z') {
                arr.add(ch1+""+ch2);
            }
        }

        return arr;
    }
}
