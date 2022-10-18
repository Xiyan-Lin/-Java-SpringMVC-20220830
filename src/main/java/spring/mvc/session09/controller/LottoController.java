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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lotto")
public class LottoController {
	// 存放所有 lotto 紀錄的集合
	private List<Set<Integer>> lottos = new CopyOnWriteArrayList<>();

	// lotto 主畫面
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("lottos", lottos); // 歷史 lotto 紀錄
		return "session09/lotto";
	}

	// 取得最新電腦選號
	@GetMapping(value = { "/get", "/add" })
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

	// 修改指定 index 的 lotto 紀錄. 注意: { index } 不可有空白
	@GetMapping("/update/{index}")
	public String update(Model model, @PathVariable("index") int index) {
		// 重新取得 lotto 號碼
		Set<Integer> lotto = getRandomLotto();
		// 將 lotto 放在指定 index 的位置 (更新資料)
		lottos.set(index, lotto);
		model.addAttribute("lottos", lottos); // 歷史 lotto 紀錄
		return "redirect:/mvc/lotto/"; // 重導到 lotto 主畫面
	}
	
	// 刪除指定 index 的 lotto 紀錄
	@GetMapping("/delete/{index}")
	public String delete(Model model, @PathVariable("index") int index) {
		// 根據 index 位置刪除該筆紀錄
		lottos.remove(index);
		model.addAttribute("lottos", lottos); // 歷史 lotto 紀錄
		return "redirect:/mvc/lotto/"; // 重導到 lotto 主畫面
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
