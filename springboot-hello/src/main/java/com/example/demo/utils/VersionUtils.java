package com.example.demo.utils;

public class VersionUtils {

	
	public static int compareVersion(String version1,String version2) throws Exception{
	    if (version1 == null || version2 == null) {  
	        throw new Exception("compareVersion error:illegal params.");  
	    }
	    
	    //纯数字比较
	    boolean isVer1Num = isNumeric(version1);
	    boolean isVer2Num = isNumeric(version2);
	    if(isVer1Num && isVer2Num){
	    	return version1.compareTo(version2);
	    }else if(isVer1Num){
	    	return -1;
	    }else if(isVer2Num){
	    	return 1;
	    }
	    
	    String[] versionArray1 = version1.split("\\.");  
	    String[] versionArray2 = version2.split("\\.");  
	    int idx = 0;  
	    int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值  
	    int diff = 0;  
	    while (idx < minLength  
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度  
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符  
	        ++idx;  
	    }  
	    //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；  
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;  
	    return diff; 
	}
	
	
	public static boolean isNumeric(String str){  
	   for(int i=str.length();--i>=0;){  
	      int chr=str.charAt(i);  
	      if(chr<48 || chr>57)  
	         return false;  
	   }  
	   return true;  
	}  
	
	
}
