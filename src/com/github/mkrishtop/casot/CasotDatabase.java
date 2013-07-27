package com.github.mkrishtop.casot;


public class CasotDatabase<T extends Marshallable> {
	
	private Class<T> mClass;
	private Integer mId;
	private Integer mVersion;
	
	public CasotDatabase(Class<T> clazz, Integer id, Integer version) {
		mClass = clazz;
		mId = id;
		mVersion = version;
	}
	
	public CasotInfo info() {
		CasotInfo info = new CasotInfo();
		info.name = mClass.getName().replace(".", CasotInfo.PATH_SEPARATOR) 
				+ CasotInfo.PATH_SEPARATOR + mId 
				+ CasotInfo.PATH_SEPARATOR + mVersion;
		return info;
	}

}
