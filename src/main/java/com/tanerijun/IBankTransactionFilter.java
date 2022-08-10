/**
 * An interface responsible for the selection logic
 */

package main.java.com.tanerijun;

@FunctionalInterface
public interface IBankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
