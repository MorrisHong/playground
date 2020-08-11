package simplebankstatementanalyzer;

import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/11
 */

public interface BankStatementParser {
	BankTransaction parseFrom(String line);

	List<BankTransaction> parseLinesFrom(List<String> lines);
}
