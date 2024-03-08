import java.util.Scanner;
import java.util.Arrays;

public class AlphabetCount
{
	public static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        char[] alpha={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            
        System.out.println("Enter frequency character:");
        char freq = sc.next().charAt(0);
        System.out.println("Enter cipher text:");
        String quote = sc.next();
        quote = quote.toLowerCase().replaceAll("[^a-z]","");
        System.out.println("quote:="+quote);
        int[] frequencies = new int[26];
        for (char c: quote.toCharArray()) 
        {
            frequencies[c - 'a'] = frequencies[c - 'a'] + 1;
        }
        System.out.println("Frequency of character:"+Arrays.toString(frequencies));
        int max = Integer.MIN_VALUE;
        System.out.println("Max Value"+max);
        int index = -1;
        for(int i = 0; i < frequencies.length; i++)
        {
            if(max < frequencies[i])
            {
                max = frequencies[i];
                index = i;
            }
        }
        System.out.println(alpha[index]+" has maximum frequency");
        int key = index - ALPHA.indexOf(freq);
        System.out.println(key+" can be a shift key");
        String decText = decrypt(quote, key);
        System.out.println("Cryptanalysis of cipher text is : "+decText);
    }

    public static String decrypt(String message, int shiftKey) 
    {
        int i = 0;
        char replaceVal = ' ';
        message = message.toLowerCase();
        String plainText = "";
        for (int jj = 0; jj < message.length(); jj++) 
        {
            int charPosition = ALPHA.indexOf(message.charAt(jj));
            System.out.println("Character at position:="+charPosition);
            int keyVal = (charPosition - shiftKey) % 26;
            System.out.println("Kay Value:="+keyVal);
            if(keyVal< 0)
            {
                i = 26-(-keyVal);
                replaceVal = ALPHA.charAt(i);
            }
            else
            {
                replaceVal = ALPHA.charAt(keyVal);
            }
            plainText += replaceVal;
        }
        return plainText;
    }
}
