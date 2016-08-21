package cn.gov.hrss.ln.stuenroll.archive;

public class ArchiveController implements I_ArchiveController{

	private I_ArchiveService i_ArchiveService;

	public I_ArchiveService getI_ArchiveService() {
		return i_ArchiveService;
	}

	public void setI_ArchiveService(I_ArchiveService i_ArchiveService) {
		this.i_ArchiveService = i_ArchiveService;
	}
}
