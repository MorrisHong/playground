package extendbankstatementanalyzer;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/11
 */

@FunctionalInterface
public interface BankTransactionFilter {
	boolean test(BankTransaction bankTransaction);
}
