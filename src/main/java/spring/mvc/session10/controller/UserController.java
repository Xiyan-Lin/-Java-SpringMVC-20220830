package spring.mvc.session10.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session10.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private List<User> users = new CopyOnWriteArrayList<>(); // In-memory db
	
	// 建構初始時作區
	{
		users.add(new User("John", 20, new Date(), "大學", "男", new String[] {"看電影", "玩遙控", "寫程式"}, "履歷表一"));
		users.add(new User("Mary", 23, new Date(), "研究所", "女", new String[] {"爬山"}, "履歷表二"));
		users.add(new User("Bobo", 16, new Date(), "高中", "男", new String[] {"看電影", "寫程式"}, "履歷表三"));
	}
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute User user) {
		// 有 @ModelAttribute User user 在方法中定義, 所以下面二行可以不用寫
		//User user = new User();
		//model.addAttribute("user", user);
		
		//user.setName("王曉明");
		//user.setSex("男");
		//user.setInterest(new String[] {"爬山", "寫程式"});
		//user.setBirth(new Date());
		
		model.addAttribute("users", users);
		return "session10/user";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute User user) {
		users.add(user);
		return "redirect:./";
	}
	
	@GetMapping("/{id}")
	public String get(Model model, @PathVariable int id) {
		User user = users.get(id);
		model.addAttribute("user", user);
		model.addAttribute("id", id);
		return "session10/user_edit";
	}
	
	@PutMapping("/{id}")
	public String update(@ModelAttribute User user, @PathVariable("id") int id) {
		users.set(id, user);
		return "redirect:./";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		users.remove(id);
		return "redirect:./";
	}
	
	
}
