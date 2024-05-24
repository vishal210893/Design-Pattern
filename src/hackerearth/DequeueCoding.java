package hackerearth;

import java.util.*;

public class DequeueCoding {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            st.add(num);
            if (deque.size() == m) {
                if (max < st.size()) {
                    max = st.size();
                }
                final Integer remove = deque.remove();
                if (!deque.contains(remove)) {
                    st.remove(remove);
                }
            }
        }
        System.out.println(max);
    }
}



