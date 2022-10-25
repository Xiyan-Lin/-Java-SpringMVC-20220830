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
			
		} catch (Exception e) {
			System.out.println(e);
			errors.rejectValue("symbol", "mystock.symbol.notFound");
		}
		
	}

}
