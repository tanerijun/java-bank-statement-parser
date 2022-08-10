/**
 * Improved version of BankStatementAnalyzerSimpleTotal and BankStatementAnalyzerMonthTotal
 * Implementing SRP, delegating to other classes and methods
 */

package main.java.com.tanerijun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final IBankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }

    public void analyze(final String fileName, final IBankStatementParser bankStatementParser) throws IOException {
        final Path path = Path.of(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

        collectSummary(processor);
    }

    public static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for all transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for all transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary is received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));

        System.out.println("Here are the transactions in February that cost $1000 or more: ");
        System.out.println(bankStatementProcessor.findTransactions(new BankTransactionInFebruaryAndExpensive()));

        System.out.println("Here are all your expenses: ");
        System.out.println(bankStatementProcessor.findTransactions(bankTransaction -> bankTransaction.getAmount() < 0));
    }
}
