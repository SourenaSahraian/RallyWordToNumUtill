package Rally.Org.Candidate.NumberToString;
import java.util.Map;


public interface Locale {
	
	public String[] getAppenders() ;
	public Map<Character, String> getSingleDigitsMap() ;
	public Map<Character, String> getTensMap() ;
	public Map<Integer, String> getTenTO19() ;
	

}
