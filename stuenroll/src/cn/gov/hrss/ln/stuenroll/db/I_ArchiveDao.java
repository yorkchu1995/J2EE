package cn.gov.hrss.ln.stuenroll.db;

/**
 * Archive表Dao接口
 * 
 * @author YangDi
 *
 */
public interface I_ArchiveDao {
	/**
	 * 根据条件查询归档表相关数据总数
	 * 
	 * @param year
	 * @param month
	 * @param stateId
	 * @param organizationId
	 * @return
	 */
	public long searchCountByCondition(int year, int month, int stateId,long organizationId);
	/**
	 * 验证报名是否成功，通过查看身份证号是否重复
	 * @param pid
	 * @return
	 */
	public boolean isEnrollEligible(long pid);
}
