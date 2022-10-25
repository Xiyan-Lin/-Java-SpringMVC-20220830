package spring.mvc.session11.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.mvc.session11.entity.MyStock;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Component
public class MyStockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 判斷所傳進來的是否是 MyStock 類
		return MyStock.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 基礎驗證
		ValidationUtils.rejectIfEmpty(errors, "symbol", "mystock.symbol.notEmpty");	
		ValidationUtils.rejectIfEmpty(errors, "price", "mystock.price.notNull");
		ValidationUtils.rejectIfEmpty(errors, "amount", "mystock.amount.notNull");
		
		// 進階驗證
		MyStock myStock = (MyStock)target;
		try {
			Stock stock = YahooFinance.get(myStock.getSymbol());
			// 1. 股票代號: 股票代號必須要有存在於市場中
			if(stock == null) {
				errors.rejectValue("symbol", "mystock.symbol.notFound");
			} else {
				// 取得昨日收諞價
				double previousClose = stock.getQuote().getPreviousClose().doubleValue();
				
				// 2. 買進價格: 買進價格必須是昨日收盤價的±10%之間
				if(myStock.getPrice() > previousClose * 1.1 || myStock.getPrice() < previousClose * 0.9) {
					errors.rejectValue("price", "mystock.price.rangeError");
				}
				
				// 3. 買進股數: 買進股數必須是1000的倍數(1000股=1張)
				if(myStock.getAmount() % 1000 != 0) {
					errors.rejectValue("amount", "mystock.amount.rangeError");
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
			errors.rejectValue("symbol", "yahoo.finance.error");
		}
		
	}

}
