package hibernate_utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAEncryption {
	public static String passwordEncryption(String password){
		MessageDigest md = null;
		
		try{
			md = MessageDigest.getInstance("SHA-1");
		
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		md.update(password.getBytes());
		byte[] mdBytes = md.digest();
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<mdBytes.length; i++){
			sb.append(Integer.toString((mdBytes[i]&0xff)+0x100,16).substring(1));
		}
		
		return sb.toString();
		
	}
}
