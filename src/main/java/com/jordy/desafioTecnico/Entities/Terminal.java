package com.jordy.desafioTecnico.Entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Terminal implements Serializable{
	/**
	 * Serializable para que o objeto possa transitar pela rede e etc, em bytes.
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	
	public Terminal(Long id, int logic, String serial, String model, int sam, String ptid, int plat, String version,
			int mxr, int mxf, String vERFM) {
		super();
		this.id = id;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Terminal [id=" + id + ", logic=" + logic + ", serial=" + serial + ", model=" + model + ", sam=" + sam
				+ ", ptid=" + ptid + ", plat=" + plat + ", version=" + version + ", mxr=" + mxr + ", mxf=" + mxf
				+ ", VERFM=" + VERFM + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}	
}