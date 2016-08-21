package cn.gov.hrss.ln.stuenroll.db.mariadb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;

import cn.gov.hrss.ln.stuenroll.db.I_ReviewDetailsDao;

public class ReviewDetailsDao implements I_ReviewDetailsDao {

	@Override
	public Record searchReviewDetails(Long reviewId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM review_details WHERE review_id = ?; ");
		Record record = Db.findFirst(sql.toString(), reviewId);
		return record;
	}

	@Override
	public List<Record> searchStudentAttendence(Long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> searchStudentScore(Long studentId) {
		// TODO Auto-generated method stub
		return null;	
	}

	@Before(Tx.class)
	@Override
	public int addReviewDetails(Map<String, Object> map) {
		StringBuffer sql = new StringBuffer();
		List<Object> paras = new ArrayList<>();
		sql.append("INSERT INTO `review_details` ( ");
		sql.append("	`id`, ");
		sql.append("	`review_id`, ");
		sql.append("	`student_info`, ");
		sql.append("	`conversion_trianing`, ");
		sql.append("	`conversion_organization`, ");
		sql.append("	`conversion_teaching`, ");
		sql.append("	`daliy_management`, ");
		sql.append("	`profession_setting`, ");
		sql.append("	`learning_cycle`, ");
		sql.append("	`organization_changes`, ");
		sql.append("	`employed`, ");
		sql.append("	`company_size`, ");
		sql.append("	`company_nature`, ");
		sql.append("	`salary_level`, ");
		sql.append("	`profession_counterparts`, ");
		sql.append("	`job_satisfaction`, ");
		sql.append("	`employed_way`, ");
		sql.append("	`employed_satisfaction`, ");
		sql.append("	`job_advice` ");
		sql.append(") ");
		sql.append("VALUES( NEXT VALUE FOR MYCATSEQ_GLOBAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");
		
		int count = Db.update(sql.toString(), paras.toArray());
		return count;
	}

	@Override
	public String searchUnarchiveStudentImage(Long studentId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT image_id FROM enroll WHERE id = ?; ");
		String id = Db.queryStr(sql.toString(), studentId);
		return id;
	}

	@Override
	public String searchArchiveStudentImage(Long studentId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT id FROM archive WHERE id = ?; ");
		String id = Db.queryStr(sql.toString(), studentId);
		return id;
	}

}
