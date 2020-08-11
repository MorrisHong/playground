package extendbankstatementanalyzer;

import java.io.IOException;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/11
 */

class MainApplication {
	public static void main(String[] args) throws IOException {
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		final BankStatementParser bankStatementParser = new BankStatementCSVParser();
		bankStatementAnalyzer.analyze(args[0], bankStatementParser);
	}
}
