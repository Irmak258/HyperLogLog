import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] testSizes = {1000, 10000, 50000};

        for (int size : testSizes) {

            HyperLogLog hll = new HyperLogLog(8192);

            for (int i = 0; i < size; i++) {
                hll.add("user" + i);
            }

            double estimate = hll.estimate();
            double error = Math.abs(estimate - size) / size * 100;

            System.out.printf("%-15s %-20s %-15s%n", "Real", "Estimated", "Error%");
            System.out.printf("%-15d %-20.2f %-15.2f%n", size, estimate, error);
            System.out.println("-----------------------------");
        }
    }
}

class HyperLogLog {

    private int m;
    private int[] registers;

    public HyperLogLog(int m) {
        this.m = m;
        this.registers = new int[m];
    }

    private int hash(String value) {
        return value.hashCode();
    }

    private int leadingZeros(int value) {
        return Integer.numberOfLeadingZeros(value) + 1;
    }

    public void add(String element) {

        int x = hash(element);

        int bucket = Math.abs(x) % m;

        int w = x / m;

        int zeros = leadingZeros(w);

        registers[bucket] = Math.max(registers[bucket], zeros);
    }

    public double estimate() {

        double alpha = 0.7213 / (1 + 1.079 / m);

        double sum = 0;

        for (int r : registers) {
            sum += Math.pow(2, -r);
        }

        double E = alpha * m * m / sum;
        
        if (E <= 2.5 * m) {
            int V = 0;
            for (int r : registers) {
                if (r == 0) V++;
            }
            if (V > 0) {
                E = m * Math.log((double) m / V);
            }
        }

        return E;
    }

    public void merge(HyperLogLog other) {
        for (int i = 0; i < m; i++) {
            registers[i] = Math.max(registers[i], other.registers[i]);
        }
    }
}