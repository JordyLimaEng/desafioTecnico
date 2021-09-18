package com.jordy.desafioTecnico.entities;

import java.io.Serializable;
import java.util.Objects;

public class Terminal implements Serializable{
	/**
	 * Serializable para que o objeto possa transitar pela rede e etc, em bytes.
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	public Terminal(int logic, String serial, String model, int sam, String ptid, int plat, String version, int mxr,
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
		VERFM = vERFM;
	}
	public int getMxf() {
		return mxf;
	}
	public void setMxf(int mxf) {
		this.mxf = mxf;
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
	public String getVERFM() {
		return VERFM;
	}
	public void setVERFM(String vERFM) {
		VERFM = vERFM;
	}	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Terminal [logic=" + logic + ", serial=" + serial + ", sam=" + sam + ", ptid=" + ptid + ", plat=" + plat
				+ ", version=" + version + ", mxr=" + mxr + ", VERFM=" + VERFM + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(VERFM, logic, mxr, plat, ptid, sam, serial, version);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terminal other = (Terminal) obj;
		return Objects.equals(VERFM, other.VERFM) && logic == other.logic && mxr == other.mxr && plat == other.plat
				&& Objects.equals(ptid, other.ptid) && sam == other.sam && Objects.equals(serial, other.serial)
				&& Objects.equals(version, other.version);
	}	
}
