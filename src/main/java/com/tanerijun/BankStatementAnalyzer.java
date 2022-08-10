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
        final BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

        System.out.println("The total for all transactions is " + processor.calculateTotalAmount());
        System.out.println("The transactions in January " + processor.selectInMonth(Month.JANUARY));
    }
}
