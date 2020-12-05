import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.System;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/*if (args.length < 1) {
      System.err.println("Usage: java EchoServer <port number>");
      System.exit(1);
    }*/

public class Client {
    
private static Scanner inStr;
private static Scanner scanner;
private static Scanner choice;
private static String serverChoice;
public static String secim[] = {"taş", "kağıt", "makas"};
public static String sonuc[] = {"berabere", "Kaybettiniz", "Kazandınız"};

	
public static void main(String[] args) throws IOException {
try {
Socket clientSocket = new Socket("localhost", 4638);
try {
OutputStream o=clientSocket.getOutputStream();  
InputStream a=clientSocket.getInputStream();

PrintWriter out = new PrintWriter(o,true);
setScanner(new Scanner(System.in));
BufferedReader in = new BufferedReader(new InputStreamReader(a));
inStr = new Scanner(in); 


while(true){
String choice1 = null;

while(true) {
	
System.out.println("Seçim: taş, kağıt ya da makas ");

choice = new Scanner(System.in);
choice1 = choice.nextLine();


	if (choice1.equals(secim[0])||choice1.equals(secim[1])||choice1.equals(secim[2])) {
		break;}  

	else if(!((choice1.equals("taş"))||(choice1.equals("kağıt"))||(choice1.equals("makas")))){
	System.out.println("Geçersiz String, seçim taş, kağıt, ya da makas"); 
		continue;}

}
out.println(choice1);
setServerChoice(inStr.nextLine());
String winner = inStr.nextLine();
cikti(winner);

                  
} 

            
} 
finally {	
	clientSocket.close();
	}
      
} catch (IOException e) {
 e.printStackTrace();
 }

    }


	public static String getServerChoice() {
		return serverChoice;
					}


	public static void setServerChoice(String serverChoice) {
		Client.serverChoice = serverChoice;
							}




	public static void cikti(String w1) {
	if(w1.equals("berabere")) {
		System.out.println(sonuc[0]);
					   }
	if(w1.equals("Kaybettiniz")) {
		System.out.println(sonuc[1]);
					}
	if(w1.equals("Kazandınız")) {
	System.out.println(sonuc[2]); 
					}
	
				    }


	public static Scanner getScanner() {
		return scanner;
                                   }


	public static void setScanner(Scanner scanner) {
		Client.scanner = scanner;
                                               }
}

