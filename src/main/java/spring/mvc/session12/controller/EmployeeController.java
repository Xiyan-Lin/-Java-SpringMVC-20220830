package spring.mvc.session12.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session12.entity.Employee;
import spring.mvc.session12.repository.EmployeeDao;

@Controller
@RequestMapping("/jdbc/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	private int getPageCount() {
		int pageCount = (int)Math.ceil((double)employeeDao.getCount() / EmployeeDao.LIMIT);
		return pageCount;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("_method", "POST");
		model.addAttribute("employees", employeeDao.query());
		model.addAttribute("pageCount", getPageCount());
		return "session12/employee";
	}
	
	@GetMapping("/{eid}")
	public String get(@PathVariable("eid") Integer eid, Model model) {
		model.addAttribute("_method", "PUT");
		model.addAttribute("employees", employeeDao.query());
		model.addAttribute("employee", employeeDao.getById(eid));
		model.addAttribute("pageCount", getPageCount());
		return "session12/employee";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute @Valid Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("_method", "POST");
			model.addAttribute("employees", employeeDao.query());
			model.addAttribute("pageCount", getPageCount());
			return "session12/employee"; 
		}
		employeeDao.add(employee);
		return "redirect:./";
	}
	
	@PutMapping("/")
	public String update(@ModelAttribute @Valid Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("_method", "PUT");
			model.addAttribute("employees", employeeDao.query());
			model.addAttribute("pageCount", getPageCount());
			return "session12/employee"; 
		}
		employeeDao.update(employee);
		return "redirect:./";
	}
	
	@DeleteMapping("/")
	public String delete(Employee employee) {
		employeeDao.delete(employee.getEid());
		return "redirect:./";
	}
	
}
