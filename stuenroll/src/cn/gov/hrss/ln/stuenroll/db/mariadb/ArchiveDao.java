package cn.gov.hrss.ln.stuenroll.db.mariadb;

import com.jfinal.plugin.activerecord.Db;

import cn.gov.hrss.ln.stuenroll.db.I_ArchiveDao;

/**
 * Archive表Dao类
 * 
 * @author YangDi
 *
 */
public class ArchiveDao implements I_ArchiveDao {

	@Override
	public long searchCountByCondition(int year, int month, int stateId, long organizationId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("	COUNT(*) ");
		sql.append("FROM ");
		sql.append("	archive ");
		sql.append("WHERE ");
		sql.append("	YEAR (create_time) = ? ");
		sql.append("AND MONTH (create_time) = ? ");
		sql.append("AND state_id = ? ");
		if(organizationId!=-1){
			sql.append("AND organization_id = ? ");
			long count = Db.queryLong(sql.toString(), year, month, stateId,organizationId);
			return count;
		}
		else{
			long count = Db.queryLong(sql.toString(), year, month, stateId);
			return count;
		}		
	}

	@Override
	public boolean isEnrollEligible(long pid) {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("	count(*) ");
		sql.append("FROM ");
		sql.append("	archive");
		sql.append("WHERE ");
		sql.append("	pid = ?; ");
		System.out.println(pid);
		long count=Db.queryLong(sql.toString(), pid);
		boolean bool=(count==0);
		return bool;
	}

}
