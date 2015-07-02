package com.comcast.oscar.configurationfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.snmp4j.smi.OID;

import com.comcast.oscar.dictionary.Dictionary;
import com.comcast.oscar.tlv.TlvBuilder;
import com.comcast.oscar.tlv.TlvNotation;
import com.comcast.oscar.utilities.HexString;
import com.comcast.oscar.utilities.PrettyPrint;

public class ConfiguratonFileFindReplaceTlv {

	private boolean debug = Boolean.FALSE;
	private TlvBuilder tbConfigurationFile = null;
	private TlvBuilder tbConfigurationFileModify = null;
	private ConfigurationFile 	cfFindReplace,
								cfFindReplaceModify;
	
	public ConfiguratonFileFindReplaceTlv(ConfigurationFile cfFindReplace) {
		this.cfFindReplace = cfFindReplace;
		this.cfFindReplaceModify = cfFindReplace.clone(); 
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
	
	private String getTlvDefintion (TlvNotation tn) {
		
		boolean localDebug = Boolean.FALSE;
		
		String sTlvDescription = "";
		String sTlvName = "";
		String sDisplayHint = "";
		
		List<String> lsTlvDotNotation = new ArrayList<String>();
		
		lsTlvDotNotation = Arrays.asList(sTlvDotNotation.split("\\."));
		
		if (debug|localDebug)
			System.out.println("ConfigrationFileExport.getTlvDefintion(): " + lsTlvDotNotation.toString());
		
		//Get TLV Dictionary for the Top Level
		JSONObject joTlvDictionary = dsqDictionarySQLQueries.getTlvDefinition(Integer.decode(lsTlvDotNotation.get(0)));
		
		//Search for TLV Definition
		if (lsTlvDotNotation.size() == 1) {
			
			try {
				sTlvName = joTlvDictionary.getString(Dictionary.TLV_NAME);
				sTlvDescription = joTlvDictionary.getString(Dictionary.TLV_DESCRIPTION);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			sDisplayHint = getDisplayHint(joTlvDictionary);
		
		} else if (lsTlvDotNotation.size() >= 1) {
			
			int iRecursiveSearch = 0;
			
			while (iRecursiveSearch < lsTlvDotNotation.size()) {
				
				if (debug|localDebug)
					System.out.println("ConfigrationFileExport.getTlvDefintion(): WHILE-LOOP");
			
				try {
					
					if (joTlvDictionary.getString(Dictionary.TYPE).equals(lsTlvDotNotation.get(iRecursiveSearch))) {
						
						if (joTlvDictionary.getBoolean(Dictionary.ARE_SUBTYPES)) {
							
							try {
								JSONArray jaTlvDictionary = joTlvDictionary.getJSONArray(Dictionary.SUBTYPE_ARRAY);
								
								for (int iIndex = 0 ; iIndex < jaTlvDictionary.length() ; iIndex++) {
									
									if (debug|localDebug)
										System.out.println("ConfigrationFileExport.getTlvDefintion(): FOR-LOOP");
									
									JSONObject joTlvDictionaryTemp = jaTlvDictionary.getJSONObject(iIndex);
									
									if (joTlvDictionaryTemp.getString(Dictionary.TYPE).equals(lsTlvDotNotation.get(iRecursiveSearch+1))) {
										joTlvDictionary = joTlvDictionaryTemp;
										iRecursiveSearch++;
										break;
									}
								}
								
							} catch (JSONException e) {
								e.printStackTrace();
							}
							
						} else {
							sTlvName = joTlvDictionary.getString(Dictionary.TLV_NAME);
							
							sTlvDescription = joTlvDictionary.getString(Dictionary.TLV_DESCRIPTION);
							
							sDisplayHint = getDisplayHint(joTlvDictionary);
							
							iRecursiveSearch++;
						}
					}
				
				} catch (JSONException e1) {
					e1.printStackTrace();
				}	
			}			
		}
			
		return "\n\n" + sTlvName + ":\n\n" + PrettyPrint.ToParagraphForm(sTlvDescription)  + "\n\n" + "String Format:\n" + sDisplayHint;		
	}
	
}
