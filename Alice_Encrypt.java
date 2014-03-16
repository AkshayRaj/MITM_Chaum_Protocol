package org.owasp.java.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import java.util.Scanner;
import java.io.*;
import org.apache.commons.io.*;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;


//import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * This program provides the following cryptographic functionalities
 * 1. Encryption using AES
 * 2. Decryption using AES
 * 
 * High Level Algorithm :
 * 1. Generate a DES key (specify the Key size during this phase) 
 * 2. Create the Cipher 
 * 3. To Encrypt : Initialize the Cipher for Encryption
 * 4. To Decrypt : Initialize the Cipher for Decryption
 * 
 * 
 */

public class Alice_Encrypt {
	public static void main(String[] args) {
		
		String strDataToEncrypt = new String();
		String strCipherText = new String();
		String strDecryptedText = new String();
		
		
		try{
		/**-------------------------------------------------------------------------------
		 *  Step 1. Generate an AES key using KeyGenerator
		 *  		Initialize the keysize to 128 
		 * 
		 */
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		System.out.println("The Secret Key is :" +secretKey);
		
		/** ------------------------------------------------------------------------------ 
		 * Step 2. Write the SecretKey to a File to send to Bob
		 */ 	
		try{
			  File file = new File("d:\\secretKey.ser");
		FileOutputStream fout = new FileOutputStream("d:\\secretKey.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(secretKey);
		oos.flush();
		oos.close();
		System.out.println("'SecretKey Object written to File !'");
 
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
		/**-------------------------------------------------------------------------------
		 *  Step3. Create a Cipher by specifying the following parameters
		 * 			a. Algorithm name - here it is AES
		 */
		
		Cipher aesCipher = Cipher.getInstance("AES"); 
		aesCipher.init(Cipher.ENCRYPT_MODE,secretKey); //Initialize Cipher
			
		/**
		 *  Step 4. Encrypt the Data
		 *  		1. Get the Message from User
		 *  		2. Convert the Input Text to Bytes
		 *  		3. Encrypt the bytes using doFinal method 
		 */
		System.out.println("Enter the message\n ");	
		Scanner user_input = new Scanner( System.in );
		strDataToEncrypt = user_input.nextLine( );
		
		byte[] byteDataToEncrypt = strDataToEncrypt.getBytes();
		byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt); 
		
		strCipherText = new Base64().encodeToString(byteCipherText);
		System.out.println("Cipher Text generated using AES is " +strCipherText);
		FileUtils.writeStringToFile(new File("d:\\Commitment.txt"), strCipherText);		
		
		}
		
		//------------------------------Exception Handling-------------------------------------------
		catch(IOException ioexception){
			System.out.println("'Cannot Write CipherText to Commitment.txt'");
			}
		catch (NoSuchAlgorithmException noSuchAlgo)
		{
			System.out.println(" No Such Algorithm exists " + noSuchAlgo);
		}
		
		catch (NoSuchPaddingException noSuchPad)
		{
			System.out.println(" No Such Padding exists " + noSuchPad);
		}
		
		catch (InvalidKeyException invalidKey)
		{
			System.out.println(" Invalid Key " + invalidKey);
		}
		
		catch (BadPaddingException badPadding)
		{
			System.out.println(" Bad Padding " + badPadding);
		}
				
		catch (IllegalBlockSizeException illegalBlockSize)
		{
			System.out.println(" Illegal Block Size " + illegalBlockSize);
		}	
				
	}

}
