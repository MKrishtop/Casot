package com.github.mkrishtop.casot;

import android.content.Context;

public class CasotConfig {

	public static final String DEFAULT_ROOT_PATH = "casot/";
	public static final boolean DEFAULT_LOGGING = false;
	
	Context context;
	String path;
	Boolean logging;

	private CasotConfigurable mConfigurable;
	
	CasotConfig(CasotConfigurable configurable) {
		mConfigurable = configurable;
	}

	public void init(Context context) {
		if (this.context == null) this.context = context;
		if (this.path == null) this.path = DEFAULT_ROOT_PATH;
		if (this.logging == null) this.logging = DEFAULT_LOGGING;
		if (mConfigurable != null) mConfigurable.configure(this);
	}
	
	public CasotConfig log(boolean logging) {
		this.logging = logging;
		return this;
	}
	
	public CasotConfig path(String rootPath) {
		this.path = rootPath;
		return this;
	}

}
