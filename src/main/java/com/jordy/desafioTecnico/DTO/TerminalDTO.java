package com.jordy.desafioTecnico.DTO;

public class TerminalDTO {
	
	int logic;
	String serial;
	String model;
	int sam;
	String ptid;
	int plat;
	String version;
	int mxr;
	int mxf;
	String VERFM;
	
	public TerminalDTO(int logic, String serial, String model, int sam, String ptid, int plat, String version, int mxr,
			int mxf, String vERFM) {
		super();
		this.logic = logic;
		this.serial = serial;
		this.model = model;
		this.sam = sam;
		this.ptid = ptid;
		this.plat = plat;
		this.version = version;
		this.mxr = mxr;
		this.mxf = mxf;
		this.VERFM = vERFM;
	}
	
	public TerminalDTO() {
	}

	public int getLogic() {
		return logic;
	}
	public void setLogic(int logic) {
		this.logic = logic;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSam() {
		return sam;
	}
	public void setSam(int sam) {
		this.sam = sam;
	}
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public int getPlat() {
		return plat;
	}
	public void setPlat(int plat) {
		this.plat = plat;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getMxr() {
		return mxr;
	}
	public void setMxr(int mxr) {
		this.mxr = mxr;
	}
	public int getMxf() {
		return mxf;
	}
	public void setMxf(int mxf) {
		this.mxf = mxf;
	}
	public String getVERFM() {
		return VERFM;
	}
	public void setVERFM(String vERFM) {
		this.VERFM = vERFM;
	}

	@Override
	public String toString() {
		return logic + ";" + serial + ";" + model + ";" + sam + ";" + ptid + ";" + plat + ";" + version + ";" + mxr
				+ ";" + mxf + ";" + VERFM;
	}
	
	
}
