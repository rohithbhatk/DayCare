package edu.neu.csye6200.models;

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
	/*
	private Integer hibCount = 0;
	private Integer dTaPCount= 0;
	private Integer polioCount= 0;
	private Integer hepatitis_BCount= 0;
	private Integer mMRCount= 0;
	private Integer varicellaCount= 0;
	*/
	

	
	public List getHib() {
		
		return hib;
	}
	public void setHib(Date date) {
		
		this.hib.add(date);
	}
	public List getdTaP() {
		return dTaP;
	}
	public void setdTaP(Date date) {
		this.dTaP.add(date);
	}
	public List getPolio() {
		return polio;
	}
	public void setPolio(Date date) {
		this.polio.add(date);
	}
	public List getHepatitis_B() {
		return hepatitis_B;
	}
	public void setHepatitis_B(Date date) {
		this.hepatitis_B.add(date);
	}
	
	public List getmMR() {
		return mMR;
	}
	public void setmMR(Date date) {
		this.mMR.add(date);
	}
	public List getVaricella() {
		return varicella;
	}
	public void setVaricella(Date date) {
		this.varicella.add(date);
	}
	@Override
	public String toString() {
		return "Vaccination [hib=" + hib + ", dTaP=" + dTaP + ", polio=" + polio + ", hepatitis_B=" + hepatitis_B
				+ ", mMR=" + mMR + ", varicella=" + varicella + "]";
	}

	
}


