import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordSalting
{
    public static SecureRandom 
    random=new SecureRandom();
    public static void main(String args[])
    {
        String password1="secrete1234";
        String password2="secrete1234";
        MessageDigest md,md1;
        try
        {
            md=MessageDigest.getInstance("SHA-256");
            byte[] salt1=new byte[16];
            salt1=getSalt();
            System.out.println("Salt:="+salt1);
            StringBuilder sb = new StringBuilder();
            md.update(salt1);
            byte[] hashedPassword1=md.digest(password1.getBytes(StandardCharsets.UTF_8));
            for(byte b:hashedPassword1)
            sb.append(String.format("%02x",b));
            System.out.println("\n Salted Hashed"+sb);
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
    }

    private static byte[] getSalt()
    {
        byte[] salt=new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
