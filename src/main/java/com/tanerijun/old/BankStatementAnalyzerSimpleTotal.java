/**
 * Prints the total for all transactions in the bank statement.
 */

package main.java.com.tanerijun.old;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankStatementAnalyzerSimpleTotal {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final Path path = Path.of(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;

        for (final String line: lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }
}
