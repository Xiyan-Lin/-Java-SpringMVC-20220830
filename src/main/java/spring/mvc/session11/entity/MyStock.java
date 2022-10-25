package spring.mvc.session11.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class MyStock {
	
	@NotEmpty(message = "{mystock.symbol.notEmpty}")
	@Size(min = 4, message = "{mystock.symbol.size}")
	private String symbol; // 1. 股票代號: 股票代號必須要有存在於市場中
	
	@NotNull(message = "{mystock.price.notNull}")
	@Range(min = 0, message = "{mystock.price.range}")
	private Double price; // 2. 買進價格: 買進價格必須是昨日收盤價的±10%之間
	
	@NotNull(message = "{mystock.amount.notNull}")
	@Range(min = 1000, message = "{mystock.amount.range}")
	private Integer amount; // 3. 買進股數: 買進股數必須是1000的倍數(1000股=1張) 
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "MyStock [symbol=" + symbol + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
}
