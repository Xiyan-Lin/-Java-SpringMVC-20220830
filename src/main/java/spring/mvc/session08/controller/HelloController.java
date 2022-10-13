package spring.mvc.session08.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Controller
@RequestMapping("/hello")
public class HelloController {
	/* 
	 * 1. 執行路徑: /mvc/hello/welcome
	 * /mvc 在 web.xml 中有定義
	 * /hello 找到 HelloController
	 * /welcome 執行 welcome() 方法
	*/
	@RequestMapping("/welcome")
	@ResponseBody  // 直接將資料回應給前端
	public String welcome() {
		return "Welcome SpringMVC !";
	}
	
	/*
	 * 2. ?後面帶參數 @RequestParam
	 * 執行路徑: /mvc/hello/sayhi?name=John&age=18
	 * */
	@RequestMapping("/sayhi")
	@ResponseBody
	public String sayHi(@RequestParam(value = "name", required = false) String name,
						@RequestParam(value = "age", defaultValue = "12") Integer age) {
		return String.format("Hi %s %d", name, age);
	}
	
	/*
	 * 3.Lab 練習
	 * 執行路徑: /mvc/hello/bmi?h=170&w=60
	 * 執行結果: bmi = 20.76
	 * 請製作對應的方法 ..
	 * */
	@RequestMapping("/bmi")
	@ResponseBody
	public String bmi(@RequestParam(value = "h") Double h,
					   @RequestParam(value = "w") Double w) {
		double bmi = w / Math.pow(h/100, 2);
		return String.format("bmi = %.2f", bmi);
	}
	
	/*
	 * 4. 同名多參數的資料
	 * 執行路徑: /mvc/hello/age?age=18&age=19&age=21
	 * 計算出: 資料筆數, 總和, 平均, 最大值, 最小值
	 * */
	@RequestMapping("/age")
	@ResponseBody
	public String age(@RequestParam("age") List<Integer> ageList) {
		// int 的統計物件
		IntSummaryStatistics stat = ageList.stream()
										   .mapToInt(Integer::intValue)
										   .summaryStatistics();
		return String.format("%s<br>%s", ageList, stat);
		
	}
	
	/*
	 * 4. Lab 取得多檔股價與匯率
	 * 執行路徑: /mvc/hello/symbol?symbol=2330.TW&symbol=2317.TW&symbol=USDTWD=x&symbol=JPYTWD=x
	 * 請製作對應的方法並印出每個商品股價與匯率資料
	 * API: https://financequotes-api.com/
	 * */
	@RequestMapping("/symbol")
	@ResponseBody
	public String symbol(@RequestParam("symbol") String[] symbols) throws IOException {
		Map<String, Stock> stocks = YahooFinance.get(symbols);
		return Arrays.toString(symbols) + "<br>" + stocks.toString()
														 .replace(",", "<br>")
														 .replace("{", "")
														 .replace("}", "");
	}
	
	/*
	 * 5. Map 參數(常用於 form 表單上)
	 * 執行路徑(Get):  /mvc/hello/person?name=Tom&score=90.5&age=18&pass=true
	 * 執行路徑(Post): /mvc/hello/person 
	 *               夾帶 name=Tom&score=90.5&age=18&pass=true
	 * */
	@RequestMapping(value = "/person", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String getPerson(@RequestParam Map<String, String> person) {
		String name = person.get("name");
		String score = person.get("score");
		String age = person.get("age");
		String pass = person.get("pass");
		return String.format("%s, %s, %s, %s\n", name, score, age, pass);
	}
	
	
}







