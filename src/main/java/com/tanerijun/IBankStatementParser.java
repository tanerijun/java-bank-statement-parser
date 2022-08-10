/**
 * An interface for all bank statement parser
 */

package main.java.com.tanerijun;

import java.util.List;

public interface IBankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
