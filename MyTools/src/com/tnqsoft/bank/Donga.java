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
public class Donga {
	public boolean validData(String data1, String data2) {
		//boolean foundMatch1 = data1.matches("[0-9]{2}\\/[0-9]{2}\\/[0-9]{2}");
		data2 = data2.replaceAll("\\r\\n|\\r|\\n", " ");
		boolean foundMatch1 = data1.matches("^CK(.*)$");
		boolean foundMatch2 = data2.matches("^(.*)TK-(.*)$");
		return foundMatch1 && foundMatch2;
	}
	
	public String getValue1(String value) {
		value = value.replaceAll("\\r\\n|\\r|\\n", " ");
		Pattern regex = Pattern.compile("(.*)(TK-.*)\\|(.*)");
		Matcher regexMatcher = regex.matcher(value);
		if (regexMatcher.find()) {
			return regexMatcher.group(2).trim();
		} else {
			return "";
		}
	}
	
	public String getValue5(String value) {
		value = value.replaceAll("\\r\\n|\\r|\\n", " ");
		Pattern regex = Pattern.compile("(.*)(TK-.*)\\|(.*)");
		Matcher regexMatcher = regex.matcher(value);
		if (regexMatcher.find()) {
			return regexMatcher.group(3).trim();
		} else {
			return "";
		}
	}
}
