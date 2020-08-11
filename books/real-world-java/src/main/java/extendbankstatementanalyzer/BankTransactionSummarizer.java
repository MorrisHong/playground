package extendbankstatementanalyzer;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/11
 */

@FunctionalInterface
public interface BankTransactionSummarizer {
	double summarize(double accumulator, BankTransaction bankTransaction);
}
