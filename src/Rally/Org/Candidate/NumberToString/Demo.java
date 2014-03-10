package Rally.Org.Candidate.NumberToString;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;


public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long range_max= 100000000000000l;

		for(int i=0; i<15; i++){
			Random rand = new Random();
			double randomNum = range_max*rand.nextDouble() ;
			ContextSwitch cs=new ContextSwitch(new  RallyNumberToWordConverterImpl (new EnglishLocal()));
			BigDecimal rawValue = new BigDecimal(randomNum);  
			String result=cs.convertNumberToString(String.valueOf(rawValue) );
			System.out.println("input=" +rawValue );
			System.out.println(result);
			System.out.println("**********************************");

		}

	}
}