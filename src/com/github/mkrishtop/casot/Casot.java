package com.github.mkrishtop.casot;

import android.content.Context;
import android.util.Log;

public class Casot {
	
	public static final int DEFAULT_IN_MEMORY_LIMIT = 300;
	public static final String DEBUG_TAG = "casot-debug";
	
	private static volatile Casot sCasot = new Casot(); //FIXME
	private static volatile CasotConfig sConfig;
	
	public static void init(Context context) {
		new CasotConfig(configCallback).init(context);
	}
	
	public static CasotConfig path(String rootPath) {
		CasotConfig config = new CasotConfig(configCallback);
		config.path = rootPath;
		return config;
	}
	
	public static CasotConfig log(boolean logging) {
		CasotConfig config = new CasotConfig(configCallback);
		config.logging = logging;
		return config;
	}
	
	private Casot() {}
	
	private static CasotConfigurable configCallback = new CasotConfigurable() {
		@Override
		public void configure(CasotConfig config) {
			setConfig(config);				
		}
	};
	
	private static void setConfig(CasotConfig config) {
		synchronized (CasotConfig.class) {
			if (sConfig == null) {
				sConfig = config;
				log("Configuration complete.");
			} else {
				log("Reconfiguration failed. Casot could be initialized only once.");
			}
		}
	}
	
	private static void log(String message) {
		if (sConfig.logging) Log.d(DEBUG_TAG, message);
	}

}
