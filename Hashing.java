import java.util.*;

public class Main {

    static final int N = 1 << 20;
    static final int REPETITIONS = 30;

    static String[][] generateData() {
        String[] keys = new String[N];
        for (int i = 0; i < N; i++) keys[i] = "key" + i;
        List<String> list = Arrays.asList(keys);
        Collections.shuffle(list);
        String[][] data = new String[N][2];
        for (int i = 0; i < N; i++) {
            data[i][0] = list.get(i);
            data[i][1] = String.valueOf(i + 1);
        }
        return data;
    }
