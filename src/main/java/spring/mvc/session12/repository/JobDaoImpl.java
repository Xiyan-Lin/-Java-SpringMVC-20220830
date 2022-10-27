package spring.mvc.session12.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.session12.entity.Job;

@Repository
public class JobDaoImpl implements JobDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Job job) {
		String sql = "insert into job (jname, eid) values(?, ?)";
		return jdbcTemplate.update(sql, job.getJname(), job.getEid());
	}

	@Override
	public int update(Job job) {
		String sql = "update job set jname=?, eid=? where jid=?";
		return jdbcTemplate.update(sql, job.getJname(), job.getEid(), job.getJid());
	}

	@Override
	public int delete(Integer jid) {
		String sql = "delete from job where jid=?";
		return jdbcTemplate.update(sql, jid);
	}

	@Override
	public int getCount() {
		String sql = "select count(*) from job";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Job getById(Integer jid) {
		String sql = "select jid, jname, eid from job where jid=?";
		return jdbcTemplate.queryForObject(sql, Job.class, jid);
	}

	@Override
	public List<Job> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> queryPage(int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
