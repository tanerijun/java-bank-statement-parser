/**
 * Improved version of BankStatementAnalyzerSimpleTotal and BankStatementAnalyzerMonthTotal
 * Implementing SRP, delegating to other classes and methods
 */

package main.java.com.tanerijun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        final String fileName = args[0];
        final Path path = Path.of(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("The transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;

        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month)
                bankTransactionsInMonth.add(bankTransaction);
        }

        return bankTransactionsInMonth;
    }
}
