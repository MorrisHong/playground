package extendbankstatementanalyzer;


import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/10
 */

class BankStatementProcessor {
	private final List<BankTransaction> bankTransactions;

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
		double result = 0;
		for (BankTransaction bankTransaction : this.bankTransactions) {
			result = bankTransactionSummarizer.summarize(result, bankTransaction);
		}
		return result;
	}

	public double calculateTotalInMonth(final Month month) {
		return summarizeTransactions((acc, bankTransaction) ->
				bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
	}


	public double calculateTotalForCategory(final String category) {
		return summarizeTransactions((acc, bankTransaction) ->
				bankTransaction.getDescription().equals(category) ? acc + bankTransaction.getAmount() : acc);
	}

	public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
		final List<BankTransaction> result = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransactionFilter.test(bankTransaction)) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
}
