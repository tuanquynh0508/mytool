/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnqsoft.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyen Nhu Tuan
 */
public class Vietcombank {
	
	public boolean validData(String data1, String data5) {
		boolean foundMatch1 = data1.matches("[0-9]{2}\\/[0-9]{2}\\/[0-9]{4} [A-Z0-9]{4}\\.[0-9]{6}");
		boolean foundMatch2 = data5.matches("(.*)TK DOI UNG: ([0-9]*)");
		return foundMatch1 && foundMatch2;
	}

	public String getValue4(String value) {
		Pattern regex = Pattern.compile("([0-9]{2}\\/[0-9]{2}\\/[0-9]{4})");
		Matcher regexMatcher = regex.matcher(value);
		if (regexMatcher.find()) {
			return regexMatcher.group();
		} else {
			return "";
		}
	}

	public String getValue1(String value) {
		Pattern regex = Pattern.compile("(.*)TK DOI UNG: ([0-9]*)");
		Matcher regexMatcher = regex.matcher(value);
		if (regexMatcher.find()) {
			return regexMatcher.group(2).trim();
		} else {
			return "";
		}
	}

	public String getValue5(String value) {
        boolean matchCase1 = value.matches("FTF.CN(.*)");
		boolean matchCase2 = value.matches("IBVCB\\.(.*)\\.(.*)TK DOI UNG:(.*)");

		if(matchCase1) {
			return "";
		} else if(matchCase2) {
			Pattern regex = Pattern.compile("IBVCB\\.(.*)\\.(.*)TK DOI UNG:(.*)");
			Matcher regexMatcher = regex.matcher(value);
			if (regexMatcher.find()) {
				return regexMatcher.group(2).trim();
			} else {
				return "";
			}
		} else {
			Pattern regex = Pattern.compile("(.*)TK DOI UNG:(.*)");
			Matcher regexMatcher = regex.matcher(value);
			if (regexMatcher.find()) {
				return regexMatcher.group(1).trim();
			} else {
				return "";
			}
		}

	}
}
