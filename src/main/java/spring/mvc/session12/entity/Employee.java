package spring.mvc.session12.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	
	private Integer id; // 資料表序號
	
	@Size(min = 2, max = 50, message = "{employee.ename.size}")
	private String ename;
	
	@NotNull(message = "{employee.salary.notNull}")
	@Range(min = 38000, max = 500000, message = "{employee.salary.range}")
	private Integer salary;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createtime;
	
	// 加入 List<Job> 表示一位員工可以有多個工作
	private List<Job> jobs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", salary=" + salary + ", createtime=" + createtime
				+ ", jobs size=" + ((jobs == null) ? 0 : jobs.size()) + "]";
	}
	
	
	
}
