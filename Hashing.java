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
    static double timeOpen(String[][] data, int entries, int m) {
        long total = 0;
        for (int r = 0; r < REPETITIONS; r++) {
            openHash table = new openHash(m);
            for (int i = 0; i < entries; i++)
                table.insert(data[i][0], data[i][1]);
            long start = System.currentTimeMillis();
            for (int i = 0; i < entries; i++)
                table.lookup(data[i][0]);
            long end = System.currentTimeMillis();
            total += (end - start);
        }
        return total / 1000.0 / REPETITIONS;
    }
    public static void main(String[] args) {

        String[][] data = generateData();

        double[] alphas = {0.75, 0.80, 0.85, 0.90, 0.95};

        System.out.println("Average time in seconds");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-15s %-15s\n",
                "Alpha", "Entries", "OpenHash", "ChainedHash");

        for (double alpha : alphas) {
            int entries = (int)(alpha * 1000000);
            int m = (int)(entries / alpha);
            double openTime = timeOpen(data, entries, m);
            double chainedTime = timeChained(data, entries, m);

            System.out.printf("%-10.2f %-10d %-15.6f %-15.6f\n",
                    alpha, entries, openTime, chainedTime);
        }
    }
}

