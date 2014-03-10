package Rally.Org.Candidate.NumberToString;
import java.util.HashMap;
import java.util.Map;


public class EnglishLocal implements Locale {

	
	private String[] appenders={"", "thousdend ","million ","billion ","trillion "};
	
	private Map<Character,String> singleDigitsMap=new HashMap<Character,String>();
	private Map<Character,String> tensMap=new HashMap<Character,String>();
	private Map<Integer,String> tenTO19=new HashMap<Integer,String>();

	public String[] getAppenders() {
		return appenders;
	}

	public Map<Character, String> getSingleDigitsMap() {
		return singleDigitsMap;
	}

	public Map<Character, String> getTensMap() {
		return tensMap;
	}


	public Map<Integer, String> getTenTO19() {
		return tenTO19;
	}

	public  EnglishLocal(){
		initMaps();
	}
	

	/**
	 * This method to be modified for another language -
	 * ideally the input to this would have been another map.
	 */
	private void initMaps() {

		 singleDigitsMap.put('0', "");
		 singleDigitsMap.put('1',"one");
		 singleDigitsMap.put('2',"two");
		 singleDigitsMap.put('3',"three");
		 singleDigitsMap.put('4',"four");
		 singleDigitsMap.put('5',"five");
		 singleDigitsMap.put('6',"six");
		 singleDigitsMap.put('7',"seven");
		 singleDigitsMap.put('8',"eight");
		 singleDigitsMap.put('9',"nine");

		 
		tensMap.put('0', "");
		tensMap.put('2', "twenty");
		tensMap.put('3', "thirty");
		tensMap.put('4', "fourty");
		tensMap.put('5', "fifthty");
		tensMap.put('6', "sixty");
		tensMap.put('7', "seventy");
		tensMap.put('8', "eighty");
		tensMap.put('9', "ninety");

		
		 tenTO19.put(10, "ten");
		 tenTO19.put(11, "eleven");;
		 tenTO19.put(12, "twelve");
		 tenTO19.put(13, "thirteen");
		 tenTO19.put(14, "fourteen");
		 tenTO19.put(15, "fifteen");
		 tenTO19.put(16, "sixteen");
		 tenTO19.put(17, "seventeen");
		 tenTO19.put(18, "eighteen");
		 tenTO19.put(19, "nineteen");
		
		
	}

}
