package Rally.Org.Candidate.NumberToString;
import java.util.ArrayList;
import java.util.List;

/**
 * concrete implementation of  <code>RallyNumberToWordConverter</code> interface.
 * This class can be considered as one concrete strategy.
 * @author soorena sahraian
 *
 */
public class RallyNumberToWordConverterImpl  implements RallyNumberToWordConverter{

	private Locale local;
	
	public RallyNumberToWordConverterImpl (Locale local){
		this.local=local;
	}

	/**
	 * Sibling classes can have their own implementation of this method. This
	 * implementation however, breaks the source number into segments of three
	 */
	@Override
	public String convertNumberToString(String s) {
		StringBuilder sb = new StringBuilder();

		if (validateInput(s)) {
			
			String[] decomposed = s.split("\\.");
			
			List<String> sList = partionToPacketsOfThree(decomposed[0]);

			for (int i = sList.size() - 1; i > -1; i--) {
				printTextInIncrementsOfThree(local.getAppenders()[i],
						sList.get(i), sb);
			}

		
			

			StringBuilder sbr=new StringBuilder();
			


			if (decomposed.length > 1) {
				int decLen = decomposed[1].length();
				sbr.append("1");
				for (int i = 0; i < decLen; i++) {
					sbr.append("0");

				}
				sb.append("and " +  decomposed[1] + "/" + sbr);
			}
			
		

		}
			
			
			
		return sb.toString();
	}

	private boolean  validateInput(String s) {
		boolean flag =false;
		if(s == null || s.equals(" ")){
			System.out.println("Please enter a number !");
			System.exit(0);
		}
	/*	if(Integer.valueOf(s)==0 ){
			System.out.println("Zero !");
			System.exit(0);
		}
		*/
		return true;
	
}

	protected  String zeroPad(String str) {

		StringBuilder srb = new StringBuilder();

		for (int toPrepend=UNITOFPERATION-str.length(); toPrepend>0; toPrepend--) {
		    srb.append('0');
		}

		srb.append(str);
		String result = srb.toString();
		return result;
	}
	
	
	protected void printTextInIncrementsOfThree(String appender, String s, StringBuilder sb) {
		if(checkRange(s)) 
			{
				sb.append( local.getTenTO19().get(Integer.valueOf(s)) + " ");
				sb.append(appender);

			}
			else{
				char[] c=s.toCharArray();

				for(int i=0; i<UNITOFPERATION ; i++){
					
					if(i != 1 ){
						sb.append(  local.getSingleDigitsMap().get(c[i])+" ");
			
					}
					else{
										
						if(c[i]=='1'){
							//if the second digit is 1, skip ahead to the most significant bit and retrieve value from the map
							String aux=	String.valueOf(c[i])+ String.valueOf(c[i+1]);
							sb.append ( local.getTenTO19().get(Integer.valueOf(aux))+" ");
						
							break;
						}
						
						sb.append( local.getTensMap().get(c[i])+" ");
					}

					if( i ==0 && c[i] != '0'){
						//packets come in bundles of 3 digit- first one assumes suffice of hundred.
						sb.append( "hundred"+" "     );

					}

				}
				sb.append(appender);
			}
	}

	public static  boolean	checkRange(String s){
		return   Integer.valueOf(s)>=10  && Integer.valueOf(s) <20;		
	}


	/**
	 * <p>
	 * This method segmentizes the original number into chucnks of 3
	 * eg: 12345789 will be broken into {[012] , [3 4 5], [789]}.
	 * </p>
	 * @param string
	 * @param partitionSize
	 * @return
	 */
	protected  List<String> partionToPacketsOfThree(String string ) {

		List<String> parts = new ArrayList<String>();
		int len = string.length() ;
		int end=len;
		int start=len-UNITOFPERATION;

		boolean cont=true;
		
		while(cont)

		{

			if( start > 0){
				parts.add( string.substring(start,end ));
			}
			else{
				// zero-pad to three to make for lack of digits ; eg [12]->[012]
				parts.add(zeroPad(string.substring(0,end )));
				cont=false;
			}

			int temp = start;
			end=start;
			start=temp-UNITOFPERATION;

		}

		return parts;
	}

	@Override
	public String convertNumberToString(int num) {

		return 	convertNumberToString(String.valueOf(num));
	}


	@Override
	public String convertNumberToString(long num) {
		// TODO Auto-generated method stub
		return convertNumberToString(String.valueOf(num));
	}
}
