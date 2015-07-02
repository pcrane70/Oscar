package com.comcast.oscar.dictionary;

import org.json.JSONArray;
import org.json.JSONObject;

import com.comcast.oscar.tlv.TlvNotation;

public class DictionaryOperation {

	private JSONArray jaDictionary;
	
	public DictionaryOperation(JSONArray jaDictionary) {
		this.jaDictionary = jaDictionary;
	}
	
	public List<JSONObject> getTopLevelTLV(TlvNotation tn) {
		
	}
	
}
