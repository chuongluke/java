package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Currency Formatter
 * 
 * @author no_name
 *
 */
public class CurrencyFormatter {

	public static void main(String[] args) throws ParseException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double currency;
		
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		NumberFormat numberFormatter = NumberFormat.getInstance();
		
		String currencyOut;
		
		System.out.println("Please enter a number to be formatted as currency : \n");
		currency = numberFormatter.parse(in.readLine()).doubleValue();
		currencyOut = currencyFormatter.format(currency);
		
		System.out.println("\n\n The number formatted as currency is: \n");
		System.out.println(currencyOut);
		
		
	}
}
