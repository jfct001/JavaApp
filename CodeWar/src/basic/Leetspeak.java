package basic;

public class Leetspeak extends Encoder{

	  public String encode(String source){
	    // TODO - Encode the source string into a 133tSp34k string
		  if (source.isEmpty() || source.equals("")) return "";
		  
		  source = source.replaceAll("(?i)a", "4");
		  source = source.replaceAll("(?i)e", "3");
		  source = source.replaceAll("(?i)l", "1");
		  source = source.replaceAll("(?i)m", "/^^\\\\");
		  source = source.replaceAll("(?i)o", "0");
		  source = source.replaceAll("(?i)u", "(_)");
		  
		  return source;
	  }
	  
}

abstract class Encoder{
	 public abstract String encode(String source);
}