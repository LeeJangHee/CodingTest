import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 17413 단어뒤집기2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        boolean tag = false;
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch == '<') {
                tag = true;
                while (!st.isEmpty()) {
                    ans.append(st.pop());
                }
                ans.append('<');
            } else if (ch == '>') {
                tag = false;
                ans.append('>');
            } else if (ch == ' ') {
                while (!st.isEmpty()) {
                    ans.append(st.pop());
                }
                ans.append(" ");
            } else {
                if (tag) {
                    ans.append(ch);
                } else {
                    st.push(ch);
                }
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        System.out.println(ans);
        sc.close();

    }

}
