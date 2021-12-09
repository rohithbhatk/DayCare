package edu.neu.csye6200;

public class Vaccination {
	
	private int hib = 0;
	private int dTaP = 0;
	private int polio = 0;
	private int hepatitis_B = 0;
	private int mMR = 0;
	private int varicella = 0;
	/*
	private Integer hibCount = 0;
	private Integer dTaPCount= 0;
	private Integer polioCount= 0;
	private Integer hepatitis_BCount= 0;
	private Integer mMRCount= 0;
	private Integer varicellaCount= 0;
	*/
	
	
	public int getHib() {
		return hib;
	}
	public void setHib() {
		this.hib +=1;
	}
	public int getdTaP() {
		return dTaP;
	}
	public void setdTaP() {
		this.dTaP +=1;
	}
	public int getPolio() {
		return polio;
	}
	public void setPolio() {
		this.polio+=1;
	}
	public int getHepatitis_B() {
		return hepatitis_B;
	}
	public void setHepatitis_B() {
		this.hepatitis_B+=1;
	}
	
	public int getmMR() {
		return mMR;
	}
	public void setmMR() {
		this.mMR+=1;
	}
	public int getVaricella() {
		return varicella;
	}
	public void setVaricella() {
		this.varicella +=1;
	}
	@Override
	public String toString() {
		return "Vaccination [hib=" + hib + ", dTaP=" + dTaP + ", polio=" + polio + ", hepatitis_B=" + hepatitis_B
				+ ", mMR=" + mMR + ", varicella=" + varicella + "]";
	}

	
}


