package com.comcast.oscar.tlv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.comcast.oscar.utilities.HexString;

public class TlvNotation {

	private String sTlvNotation = "";
	private HexString hsTlvNotation = null;;
	

	/**
	 * 
	 * @param sTlvNotation 	Acceptable Inputs 24.1.2.3 , 3
	 * 						Must be Positive Integers 0 or greater
	 * @throws TlvException*/
	public TlvNotation(String sTlvNotation) throws TlvException {
		this.sTlvNotation = sTlvNotation;

		this.hsTlvNotation = new HexString();
		
		for (String sType : Arrays.asList(sTlvNotation.split("\\."))) {
			
			if (sType.matches("-?\\d+")) {
				this.hsTlvNotation.add(Integer.parseInt(sType));
			} else {
				this.hsTlvNotation = new HexString();
				this.sTlvNotation = "";
				throw new TlvException("TlvNotation() Constructor Argument is not an Integer: " + sType);
			}
					
		}
		
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
		return hsTlvNotation.toByteArray();
	}
	
	/**
	 * 
	 * @return Number of bytes of TLV Notation*/
	public int size() {
		return hsTlvNotation.toByteArray().length;
	}
	
	/**
	 * 
	 * @param iIndex Example 24.2.4.6.8 -> Index=2 Return -> 4
	 * @return Integer of the Type specified in Index*/
	public int getType(int iIndex) {
		return hsTlvNotation.toByteArray()[iIndex];
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
