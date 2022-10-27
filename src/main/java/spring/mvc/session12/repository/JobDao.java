package spring.mvc.session12.repository;

import java.util.List;

import spring.mvc.session12.entity.Job;

public interface JobDao {
	// 每頁筆數
	int LIMIT = 5;
	
	// 新增
	int add(Job job);
	
	// 修改
	int update(Job job);
	
	// 刪除
	int delete(Integer jid);
	
	// 查詢所有筆數
	int getCount();
	
	// 查詢單筆資料
	Job getById(Integer jid);
	
	// 查詢所有資料(不分頁)
	List<Job> query();
	
	// 查詢所有資料(分頁), offset: 要從哪一筆開始查, 查 LIMIT 筆
	List<Job> queryPage(int offset);
	
}
