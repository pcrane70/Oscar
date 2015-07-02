package com.comcast.oscar.examples;

import com.comcast.oscar.tlv.TlvException;
import com.comcast.oscar.tlv.TlvNotation;

public class TlvNotationSplit {

	public static void main(String[] args) throws TlvException {


		TlvNotation tn = new TlvNotation("24.1.2.3");
		
		System.out.println("TlvNotation.Length -> " + tn.size());
		System.out.println("TlvNotation.toString -> " + tn.toString());
		

	}

}
