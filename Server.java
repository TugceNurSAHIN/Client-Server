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

public class Server {
    
private static ServerSocket serverSocket;
private static Scanner scanner;
static String choicee = null;
private static String win;
public static String secim[] = {"taş", "kağıt", "makas"};
public static String sonuc[] = {"berabere", "Kaybettiniz", "Kazandınız"};



public static String getMove() {
String move = null;   
Random random = new Random();
int Num = random.nextInt(3);

if(Num == 0) {
move = secim[0];}
if (Num == 1) {
move = secim[1];}
if (Num == 2) {
move = secim[2];}
return move;
}




public static void main(String[] args) throws IOException {
try {
serverSocket = new ServerSocket(4638);
Socket clientSocket = serverSocket.accept();
System.out.println("Connection....\n");
InputStream i=clientSocket.getInputStream();
choicee = null;

OutputStream s=clientSocket.getOutputStream();

PrintWriter out = new PrintWriter(s, true);
BufferedReader in = new BufferedReader(new InputStreamReader(i));
getWin();

try {
do {
String serverMove = getMove();
                
try {
scanner = new Scanner(in);
String playerMove = scanner.nextLine();

String roundWin = winner(playerMove, serverMove);
              
System.out.println(playerMove);
System.out.println(serverMove);                    
System.out.println(roundWin);
System.out.println("\n");
choicee = null;                  
out.println(serverMove);
out.println(roundWin);
} 
catch (NoSuchElementException e) {
                    return; }               
} while(true);
} finally {
clientSocket.close(); }
  
} catch(IOException e) {
e.printStackTrace();
}
}
    
    
public static String getWin() {
	return win;
}



public static void setWin(String win) {
	Server.win = win;
}

public static String winner(String playerMove,String serverMove) {
String winner;
if(serverMove.equals(secim[0]) && playerMove.equals(secim[2])) {
winner = sonuc[1]; }
else if(serverMove.equals(playerMove)) {
winner = sonuc[0]; }
else if (serverMove.equals(secim[2]) && playerMove.equals(secim[1])) {
winner = sonuc[1]; }
else if (serverMove.equals("kağıt") && playerMove.equals("taş")) {
winner = sonuc[1];}
else {
winner = sonuc[2];
}
 return winner;
}}
