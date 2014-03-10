package Rally.Org.Candidate.NumberToString;

/**
 * 
 * @author soorenasahraian
 *
 */
public interface RallyNumberToWordConverter {
	final static int UNITOFPERATION=3;
	public String convertNumberToString(int num);
	public String convertNumberToString(String num);
	public String convertNumberToString(long num);

}
