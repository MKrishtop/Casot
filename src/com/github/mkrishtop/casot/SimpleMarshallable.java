package com.github.mkrishtop.casot;

import java.lang.reflect.Field;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public abstract class SimpleMarshallable implements Marshallable {

	protected UUID id = UUID.randomUUID();
	
	@Override
	public JSONObject marshal() {
		JSONObject json = new JSONObject();
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value = field.get(this);
				if (value != null) {
					if (value instanceof Marshallable) {
						json.put(field.getName(), ((Marshallable)value).marshal());
					} else {
						json.put(field.getName(), value);
					}
				}
			}
			return json;
		} catch (JSONException je) {
			Log.e(Casot.DEBUG_TAG, "Marshal error.");
		} catch (IllegalAccessException ie) {
			Log.e(Casot.DEBUG_TAG,
					"Can't access field from Marshallable class.");
		}
		return null;
	}

	@Override
	public void unmarshal(JSONObject j) {
		//TODO
	}

}
