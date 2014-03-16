MITM_Chaum_Protocol
===================

David Chaum Patent Protocol for Man in the Middle Attack

Following are the things that you may need to change for the code to Execute

1. In Alice_Encrypt class, you have to change the pathname for the following Lines of Code -
	"FileOutputStream fout = new FileOutputStream("d:\\secretKey.ser");" 
	"FileUtils.writeStringToFile(new File("d:\\Commitment.txt"), strCipherText);"
  
2. Same goes with Bob_Decrypt class, you will have to change pathname for the following -
	"File commitmentFile = new File("d:\\Commitment.txt");"
	"FileInputStream fin = new FileInputStream("d:\\secretKey.ser");"
--------------------------------------------------------------------------------------------------------------------------------

TUTORIAL -->

1. Run the Alice_Encrypt Class
2. Alice will be asked from the Console to write the Message 
3. Alice writes the Message ; The program will do the following -->
   -Shared Secret will be written to "secretKey.ser" file. 
   -Commitment will be written to "Commitment.txt" file
4.Send "Commitment.txt" to Bob
	WAIT
5.Bob Requests for Key
	WAIT
6.Alice sends "secretKey.ser" to Bob
7.Bob Decrypts the Message with Shared Secret

I am attaching the Protocol Image from John's Notes. Please refer to it to validate.
   
  
