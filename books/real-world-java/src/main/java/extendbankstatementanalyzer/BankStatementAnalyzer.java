package extendbankstatementanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/10
 */

class BankStatementAnalyzer {
	private static final String RESOURCES = "books/real-world-java/src/main/resources/";

	public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);
	}

	private void collectSummary(final BankStatementProcessor bankStatementProcessor) {

		System.out.println("The total for transaction in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

		System.out.println("The total for transaction in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

		System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));

		System.out.println("The total tesco received is " + bankStatementProcessor.calculateTotalForCategory("Tesco"));

		System.out.println("2월 달 입출금 내역 중 Amount가 1000 이상인 내역 " + bankStatementProcessor.findTransactions(bankTransaction -> bankTransaction.getAmount() >= 1_000 && bankTransaction.getDate().getMonth() == Month.FEBRUARY));
	}
}
