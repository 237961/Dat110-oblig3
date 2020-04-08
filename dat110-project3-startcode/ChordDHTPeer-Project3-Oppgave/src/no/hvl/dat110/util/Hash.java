package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Hash { 
	
	private static int digestBits;
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {	
		
	try {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(entity.getBytes());
		byte[] bytes = md.digest();
		String hexString = toHex(bytes);
		digestBits = bytes.length*8;
		hashint = new BigInteger(hexString, 16);
		
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		
		BigInteger size = BigInteger.valueOf((long) Math.pow(2, digestBits));
		// Task: compute the address size of MD5
		
		// get the digest length
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		return size;
	}
	
	public static int bitSize() {
		
		return digestBits;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
