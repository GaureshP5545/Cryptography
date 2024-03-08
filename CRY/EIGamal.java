import java.math.*;
import java.util.*;
import java.security.*;
import java.io.*;

public class EIGamal
{
	public static void main(String[] args)
	throws IOException
	{
		BigInteger p,b,c,secretkey;
		Random sc=new SecureRandom();
		secretkey=new BigInteger("12345678901234567890");
		System.out.println("secretKey="+ secretkey);
		p=BigInteger.probablePrime(64,sc);
		b=new BigInteger("3");
		c=b.modPow(secretkey,p);
		System.out.println("p="+p);
		System.out.println("b="+b);
		System.out.println("c="+c);
		//Encryption
		System.out.print("Enter your Big Number message-");
		Scanner sca=new Scanner(System.in);
		String s=sca.nextLine();
		BigInteger x=new BigInteger(s);
		BigInteger r=new BigInteger(64,sc);
		BigInteger EC=x.multiply(c.modPow(r,p)).mod(p);
		BigInteger brmodp=b.modPow(r,p);
		System.out.println("Plaintext="+x);
		System.out.println("r="+r);
		System.out.println("EC="+EC);
		System.out.println("b^r mod p="+brmodp);
		//decryption
		BigInteger crmodp=brmodp.modPow(secretkey,p);
		BigInteger d=crmodp.modInverse(p);
		BigInteger ad=d.multiply(EC).mod(p);
		System.out.println("\n\nc^r mod p="+crmodp);
		System.out.println("d="+d);
		System.out.println("Alice decodes:"+ad);
	}
}

