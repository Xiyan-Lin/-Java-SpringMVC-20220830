package spring.mvc.session12.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.session12.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Employee employee) {
		String sql = "insert into employee(ename, salary) values(?, ?)";
		return jdbcTemplate.update(sql, employee.getEname(), employee.getSalary());
	}

	@Override
	public int update(Employee employee) {
		String sql = "update employee set ename=?, salary=? where eid=?";
		return jdbcTemplate.update(sql, employee.getEname(), employee.getSalary(), employee.getEid());
	}

	@Override
	public int delete(Integer eid) {
		String sql = "delete from employee where eid = ?";
		return jdbcTemplate.update(sql, eid);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getById(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> queryPage(int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
