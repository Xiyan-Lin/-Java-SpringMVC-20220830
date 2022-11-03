package spring.mvc.session12.repository;

import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
		String sql = "select count(*) from employee";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Employee getById(Integer eid) {
		String sql = "select eid, ename, salary, createtime from employee where eid=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), eid);
	}

	@Override
	public List<Employee> query() {
		// 利用 SQL-Join 結合 SimpleFlatMapper
		String sql = "select e.eid, e.ename, e.salary, e.createtime, "  +
					 "j.jid as job_jid, j.jname as job_jname, j.eid as job_eid " +
					 "from employee e left join job j on e.eid = j.eid";

		ResultSetExtractor<List<Employee>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("eid") // employee 主表的主鍵欄位
				.newResultSetExtractor(Employee.class); // 資料結果要對應的物件類別
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}

	@Override
	public List<Employee> queryPage(int offset) {
		// 利用 SQL-Join 結合 SimpleFlatMapper
		String sql = "select e.eid, e.ename, e.salary, e.createtime, "  +
					 "j.jid as job_jid, j.jname as job_jname, j.eid as job_eid " +
					 "from employee e left join job j on e.eid = j.eid ";
		
		// 加入分頁 sql
		if(offset >= 0) {
			sql += String.format("limit %d offset %d ", LIMIT, offset) ;
		}
		
		ResultSetExtractor<List<Employee>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("eid") // employee 主表的主鍵欄位
				.newResultSetExtractor(Employee.class); // 資料結果要對應的物件類別
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	
	
}
