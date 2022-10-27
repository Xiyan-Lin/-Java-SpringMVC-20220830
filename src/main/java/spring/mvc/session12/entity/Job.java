package spring.mvc.session12.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

public class Job {
	
	private Integer jid; // 資料表序號
	
	@Size(min = 2, max = 50, message = "{job.jname.size}")
	private String jname;
	
	private Integer eid;
	
	// 一個工作最多可以配置一個員工
	private Employee employee;

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Job [jid=" + jid + ", jname=" + jname + ", eid=" + eid + ", employee=" + ((employee==null)?null:employee.getEname()) + "]";
	}
	
	
	
}
