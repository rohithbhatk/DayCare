package edu.neu.csye6200.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vaccination {
	
	private List<Date> hib = new ArrayList<>();
	private List<Date> dTaP = new ArrayList<>();
	private List<Date> polio = new ArrayList<>();
	private List<Date> hepatitis_B = new ArrayList<>();
	private List<Date> mMR = new ArrayList<>();
	private List<Date> varicella = new ArrayList<>();

	public List getHib() { return hib; }
	public void setHib(Date date) { this.hib.add(date); }
	public void setHib(List<Date> hib) { this.hib = hib; }

	public List getdTaP() {
		return dTaP;
	}
	public void setdTaP(Date date) {
		this.dTaP.add(date);
	}
	public void setdTaP(List<Date> dTaP) {
		this.dTaP = dTaP;
	}

	public List getPolio() {
		return polio;
	}
	public void setPolio(Date date) {
		this.polio.add(date);
	}
	public void setPolio(List<Date> polio) {
		this.polio = polio;
	}

	public List getHepatitis_B() {
		return hepatitis_B;
	}
	public void setHepatitis_B(Date date) {
		this.hepatitis_B.add(date);
	}
	public void setHepatitis_B(List<Date> hepatitis_B) {
		this.hepatitis_B = hepatitis_B;
	}
	
	public List getmMR() {
		return mMR;
	}
	public void setmMR(Date date) {
		this.mMR.add(date);
	}
	public void setmMR(List<Date> mMR) {
		this.mMR = mMR;
	}

	public List getVaricella() {
		return varicella;
	}
	public void setVaricella(Date date) {
		this.varicella.add(date);
	}
	public void setVaricella(List<Date> varicella) {
		this.varicella = varicella;
	}

	@Override
	public String toString() {
		return "Vaccination [hib=" + hib + ", dTaP=" + dTaP + ", polio=" + polio + ", hepatitis_B=" + hepatitis_B
				+ ", mMR=" + mMR + ", varicella=" + varicella + "]";
	}

	
}


