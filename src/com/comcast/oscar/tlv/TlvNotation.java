package com.comcast.oscar.tlv;

import java.util.List;

public class TlvNotation {

	private String sTlvNotation = "";
	
	/**
	 * 
	 * @param sTlvNotation 	Acceptable Inputs 24.1.2.3 , 3
	 * 						Must be Positive Integers 0 or greater
	 */
	public TlvNotation(String sTlvNotation) {
		this.sTlvNotation = sTlvNotation;
	}
	
	/**
	 * @param sTlvNotation Example 24.1.3 of 3
	 * @return True = Valid | False != Valid*/
	public static boolean isTlvNotation(String sTlvNotation) {
		return false;
	}
	
	/**
	 **/
	public String toString() {
		return sTlvNotation;
	}
	
	/**
	 * 
	 * @return Byte representation of TLVNotation*/
	public byte[] toByteArray() {
		return null;
	}
	
	/**
	 * 
	 * @return Number of bytes of TLV Notation*/
	public int size() {
		return 0;
	}
	
	/**
	 * 
	 * @param iIndex Example 24.2.4.6.8 -> Index=2 Return -> 4
	 * @return Integer of the Type specified in Index*/
	public int getType(int iIndex) {
		return 0;
	}
	
	/**
	 * 
	 * @param tb TLV
	 * @return List of all possible TlvNotations
	 */
	public static List<String> GetAllPossiableTlvNotation(TlvBuilder tb) {
		return null;
	}
	
}
