/**
 * A domain object that stores sum‐ mary statistics about a list of transactions
 */

package main.java.com.tanerijun;

public class SummaryStatistics {
    private final double sum;
    private final double min;
    private final double max;
    private final double average;

    public SummaryStatistics(final double sum, final double max, final double min, final double average) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.average = average;
    }

    public double getSum() {
        return sum;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getAverage() {
        return average;
    }
}
