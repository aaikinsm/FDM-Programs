package com.fdmgroup.util;

import com.lambdaworks.crypto.SCryptUtil;

/**
 *  
 * @author benjamin.fonooni
 * 
 *  N: General work factor, iteration count.
 *  r: Blocksize in use for underlying hash; fine-tunes the relative memory-cost.
 *  p: Parallelization factor; fine-tunes the relative CPU-cost.

 *	'r' and 'p' are meant to accommodate for the potential issue that CPU speed and memory size and bandwidth 
 *  do not increase as anticipated. Should CPU performance increase faster, you increase 'p', 
 *  should instead a breakthrough in memory technology provide an order of magnitude improvement, 
 *  you increase 'r'. And 'N' is there to keep up with the general doubling of performance per some timespan.
 *
 */

public class PasswordEncryption {

	private int n;
	private int r;
	private int p;
	
	public PasswordEncryption() {
		super();
	}
	
	public PasswordEncryption(int n, int r, int p) {
		super();
		this.n = n;
		this.r = r;
		this.p = p;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String encrypt(String rawPassword){
		String hashed = SCryptUtil.scrypt(rawPassword, n, r, p);
		return hashed;
	}
	
	public boolean check(String password, String hashed){
		boolean check = SCryptUtil.check(password, hashed);
	    return check;
	}
}
