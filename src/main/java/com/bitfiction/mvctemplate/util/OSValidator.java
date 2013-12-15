package com.bitfiction.mvctemplate.util;

public class OSValidator {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
 
	public static OSType determineOSType() {
  
		if (isWindows()) {
			return OSType.WINDOWS;
		} else if (isMac()) {
			return OSType.MACOS;
		} else if (isUnix()) {
			return OSType.LINUX_UNIX;
		} else if (isSolaris()) {
			return OSType.SOLARIS;
		} else {
			return OSType.UNKNOWN;
		}
	}
 
	public static boolean isWindows() {
 
		return (OS.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac() {
 
		return (OS.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix() {
 
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
 
	}
 
	public static boolean isSolaris() {
 
		return (OS.indexOf("sunos") >= 0);
 
	}
 
}
