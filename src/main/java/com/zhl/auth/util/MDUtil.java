/**
 * @Author: 
 * @Company: 
 */
package com.zhl.auth.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.zhl.auth.service.impl.StringUtils;


/**
 * @Project: 
 * @Author 
 * @Company:
 */
public class MDUtil {

	public static String SHA1(String decript) {
		String ret = "";
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
			digest.update(decript.getBytes("UTF-8"));
			byte messageDigest[] = digest.digest();
			ret = StringUtils.bytesToHexString(messageDigest);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
}