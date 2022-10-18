package spring.mvc.session09.controller;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lotto")
public class LottoController {
	// 存放所有 lotto 紀錄的集合
	private List<Set<Integer>> lottos = new CopyOnWriteArrayList<>();
	
	// lotto 主畫面
	@GetMapping("/")
	public String index(Model model) {
		return "session09/lotto";
	}
	
	// 取得最新電腦選號
	@GetMapping("/get")
	public String get(Model model) {
		// 取得最新 lotto 資料
		Set<Integer> lotto = getRandomLotto();
		// 將 lotto 放入 lottos 歷史紀錄中
		lottos.add(lotto);
		// 要回傳給 jsp 的資料
		model.addAttribute("lotto", lotto); // 此次得到的 lotto 資料
		model.addAttribute("lottos", lottos); // 歷史 lotto 紀錄
		return "session09/lotto"; // jsp 所在位置
	}
	
	// 隨機產生 lotto 電腦選號
	private Set<Integer> getRandomLotto() {
		// 1~39 取5個不重複的數字
		Random r = new Random();
		Set<Integer> lotto = new LinkedHashSet<>();
		while (lotto.size() < 5) {
			lotto.add(r.nextInt(39) + 1);
		}
		return lotto;
	}
}
