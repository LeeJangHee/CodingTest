import java.util.*;

public class Main {
    // 9093 단어뒤집기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String str = sc.nextLine();
            Stack<Character> st = new Stack<>();
            StringBuilder ans = new StringBuilder();

            for (char ch : str.toCharArray()) {
                if (ch == ' ') {
                    while (!st.isEmpty()) {
                        ans.append(st.pop());
                    }
                    ans.append(' ');
                }
                else {
                    st.push(ch);
                }
            }

            while (!st.isEmpty()) {
                ans.append(st.pop());
            }

            System.out.println(ans);
        }
        sc.close();
    }

}
