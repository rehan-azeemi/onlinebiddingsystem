package hibernate_utility;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class EncodeDecode {
	public static String encodeData(String data){
		byte[] message = data.getBytes(StandardCharsets.UTF_8);
		String encoded = Base64.getEncoder().encodeToString(message);
		
		return encoded;
	}
	
	public static String decodeData(String data){
		byte[] decoded = Base64.getDecoder().decode(data);
		return new String(decoded, StandardCharsets.UTF_8);
	}
}
