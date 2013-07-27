package com.github.mkrishtop.casot;

import org.json.JSONObject;

public interface Marshallable {
	JSONObject marshal();
	void unmarshal(JSONObject j);
}
