package com.example.dna.service;

public class DnaService {
	private int sequence = 0;
	
	public boolean hasMutation(String[] dna) {
		if(dna==null||dna.length<4) return(false); //Validating
		int n = dna.length;
		//Searching horizontal sequence
		for(int y=0;y<n;y++) {
			if(dna[y]==null) return(false); //Validating
			int len = dna[y].length();
			if(len!=n) return(false); //Validating
			dna[y] = dna[y].toUpperCase();
			String last = "";
			int chars = 0;
			for(int x=0;x<len;x++) {
				String chr = dna[y].substring(x,x+1);
				if("ACGT".indexOf(chr)==-1) return(false); //Validating
				if(chr.equals(last)) {
					if(++chars>3) {
						if(++sequence>1) return(true);
						last = "";
						chars = 0;
					}
				} else {
					last = chr;
					chars = 1;
				}
			}
		}
		//Searching vertical sequence
		for(int x=0;x<n;x++) {
			if(search(dna,0,x,x)) return(true);
		}
		//Searching oblique sequence 45°
		for(int x=3;x<n;x++) {
			if(search(dna,0,x,0)) return(true);
		}
		int dfr = n-4;
		int lmt = n-1;
		for(int y=1;y<=dfr;y++) {
			if(search(dna,y,lmt,0)) return(true);
		}
		//Searching oblique sequence 135°
		for(int x=dfr;x>=0;x--) {
			if(search(dna,0,x,lmt)) return(true);
		}
		for(int y=1;y<=dfr;y++) {
			if(search(dna,y,0,lmt)) return(true);
		}
		return(false);
	}
	
	private boolean search(String[] dna, int yIni, int xIni, int xEnd) {
		int lmt = dna.length-1;
		int x = xIni;
		String last = "";
		int chars = 0;
		for(int y=yIni;y<=lmt;y++) {
			String chr = dna[y].substring(x,x+1);
			if(chr.equals(last)) {
				if(++chars>3) {
					if(++sequence>1) return(true);
					last = "";
					chars = 0;
				}
			} else {
				last = chr;
				chars = 1;
			}
			if(xIni!=xEnd) {
				if(xEnd>xIni) {
					if(++x>lmt) return(false);
				} else {
					if(--x<0) return(false);
				}
			}
		}
		return(false);
	}
	
}
