package cn.gov.hrss.ln.stuenroll.archive;

import cn.gov.hrss.ln.stuenroll.db.I_ArchiveDao;

public class ArchiveService implements I_ArchiveService{
	private I_ArchiveDao i_ArchiveDao;

	@Override
	public boolean isEnrollEligible(long pid) {
		boolean bool = i_ArchiveDao.isEnrollEligible(pid);
		return bool;
	}

	public I_ArchiveDao getI_ArchiveDao() {
		return i_ArchiveDao;
	}

	public void setI_ArchiveDao(I_ArchiveDao i_ArchiveDao) {
		this.i_ArchiveDao = i_ArchiveDao;
	}

}
