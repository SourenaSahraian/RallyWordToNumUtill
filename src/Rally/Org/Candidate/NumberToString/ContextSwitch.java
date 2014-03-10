package Rally.Org.Candidate.NumberToString;

/**
 * ContextSwitch class allows for easy swap of
 * <code>convertNumberToString<code> implementation at runtime.
 * 
 * @author soorenasahraian
 * 
 */

public class ContextSwitch {

		private RallyNumberToWordConverter  converter;
		
		public ContextSwitch(RallyNumberToWordConverter converter){
			this.converter=converter;
			
		}
		
		public String convertNumberToString(String num){
			return converter.convertNumberToString(num);
		}
		
		public String convertNumberToString(int num){
			return converter.convertNumberToString(num);
		}

		public String convertNumberToString(long num){
			return converter.convertNumberToString(num);
		}

	

}
