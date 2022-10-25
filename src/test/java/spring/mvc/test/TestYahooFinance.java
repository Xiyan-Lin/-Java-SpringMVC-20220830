package spring.mvc.test;

import org.junit.Test;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class TestYahooFinance {
	
	@Test
	public void test() throws Exception {
		Stock stock = YahooFinance.get("2330.TW");
		System.out.println(stock);
	}
	
}
