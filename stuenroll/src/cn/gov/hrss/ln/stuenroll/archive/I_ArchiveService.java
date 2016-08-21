package cn.gov.hrss.ln.stuenroll.archive;

import cn.gov.hrss.ln.stuenroll.db.I_ArchiveDao;

public interface I_ArchiveService {
	public boolean isEnrollEligible(long pid);
}
