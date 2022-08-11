package main.java.com.tanerijun;

@FunctionalInterface
public interface IBankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
