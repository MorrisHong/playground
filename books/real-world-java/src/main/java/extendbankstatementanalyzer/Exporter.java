package extendbankstatementanalyzer;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/12
 */

public interface Exporter {
	String export(SummaryStatistics summaryStatistics);
}
