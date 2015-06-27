package com.comcast.oscar.configurationfile;

import org.snmp4j.smi.OID;

import com.comcast.oscar.tlv.TlvBuilder;
import com.comcast.oscar.tlv.TlvNotation;
import com.comcast.oscar.utilities.HexString;

public class ConfiguratonFileFindReplaceTlv {

	private TlvBuilder tbConfigurationFile = null;
	private TlvBuilder tbConfigurationFileModify = null;
	
	public ConfiguratonFileFindReplaceTlv(TlvBuilder tbConfigurationFile) {
		this.tbConfigurationFile = tbConfigurationFile;
		tbConfigurationFileModify = tbConfigurationFile.clone(); 
	}
	
	/**
	 * 
	 * @param tnFindTopLevelTlvType
	 * @param tnReplaceTopLevelTlvValue
	 * @return True = Successful Replace*/
	public boolean findReplace(TlvNotation tnFindTopLevelTlvType, String sReplaceTopLevelTlvValue) {
		return false;
	}

	public boolean findReplace(TlvNotation tnFindTopLevelTlvType, int iReplaceTopLevelTlvValue) {
		return false;
	}

	public boolean findReplace(TlvNotation tnFindTopLevelTlvType, byte[] baReplaceTopLevelTlvValue) {
		return false;
	}
	
	public boolean findReplace(TlvNotation tnFindTopLevelTlvType, OID oidReplaceTopLevelTlvValue) {
		return false;
	}

	public boolean findReplace(TlvNotation tnFindTopLevelTlvType, HexString hsReplaceTopLevelTlvValue) {
		return false;
	}
	
	public boolean findReplace(TlvNotation tnMatchTlvType, String sMatchValue , TlvNotation tnFindSubLevelTlvType, String sReplaceSubLevelTlvValue) {
		return false;
	}
	
	public boolean findReplace(TlvNotation tnMatchTlvType, String sMatchValue , TlvNotation tnFindSubLevelTlvType, int iReplaceSubLevelTlvValue) {
		return false;
	}

	public boolean findReplace(TlvNotation tnMatchTlvType, String sMatchValue , TlvNotation tnFindSubLevelTlvType, byte[] baReplaceSubLevelTlvValue) {
		return false;
	}
	
	public boolean findReplace(TlvNotation tnMatchTlvType, String sMatchValue , TlvNotation tnFindSubLevelTlvType, OID oidReplaceSubLevelTlvValue) {
		return false;
	}
	
	public boolean findReplace(TlvNotation tnMatchTlvType, String sMatchValue , TlvNotation tnFindSubLevelTlvType, HexString hsReplaceSubLevelTlvValue) {
		return false;
	}
	
	public boolean deleteTlv(TlvNotation tnMatchTlvType) {
		return false;
	}
	
	public void addTlv(TlvNotation tnMatchTlvType, HexString hsValue) {
		
	}
	
	public TlvBuilder getTlvBuilder() {
		return tbConfigurationFileModify;
	}
	
	public void revertToOriginalTlvBuilder() {
		tbConfigurationFileModify = tbConfigurationFile.clone();
	}
	
	
	
}
