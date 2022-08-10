/**
 * A class to demo IBankTransactionFilter
 */

package main.java.com.tanerijun;

import java.time.Month;

public class BankTransactionInFebruaryAndExpensive implements IBankTransactionFilter {

    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1000;
    }
}
