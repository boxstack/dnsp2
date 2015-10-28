package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.StringTokenizer;
import com.appspot.trent.denis.*;

/*
 * DNS Poisoner
 * Jacob Saunders
 * This program will attempt to poison a DNS server. It does this by
 *  sending forged DNS responses to it on random ports. 
 * It will keep running indefinitely, you have to use dig or other
 * such programs to launch the query to let the poisoning go off and
 * check for success.
 * Parameters: dnsServer hostname poisonIP
 * dnsServer: IP address[:port] of the DNS server to poison
 * hostname: URL to hijack
 * poisonIP: IP address to inject as the poisoning attempt.
 */
@SuppressWarnings("unused")
public class Main {

	/*
	 * This method calls the various other functions to accomplish the poisoning
	 * after handling the command line arguments.
	 */
	public static void main(String[] args) {
		System.out.println("DNS Poisoner");
		if (args.length != 3) {
			System.out.println("Invalid quantity of arguments.");
			System.out.println
			("dnsServer: IP address of the DNS server to poison\n"
					+ "hostname: URL to hijack\n"
					+ "poisonIP: IP address to inject as the poisoning attempt.\n");
			System.exit(-1);
		}
		
		String dnsAddressString = args[0];
		String hostname = args[1];
		String poisonIPstring = args[2];
		
		//Get the byte representation of the IP addresses.
		byte[] dnsAddress = ip4StringToByte(dnsAddressString);
		byte[] poisonIP = ip4StringToByte(poisonIPstring);
		
		//Spam the poisoned DNS replies until reply.
		while (true) {
			//Set port and ID distribution here.
			int destPort = 0;
			int transactionID = 0;
			
			System.out.println("STUBBED PORT AND ID - IMPLEMENT!");
			//Otherwise, your code is essentially doing this: http://xkcd.com/221/
			
			launchPoisonPacket(dnsAddress, poisonIP, hostname, destPort,
					transactionID);
		}
	}
	
	/*
	 * This method converts an IPv4 address from a string representation
	 * to a byte array.
	 * ipAddress: The string representation of an IPv4 address.
	 */
	public static byte[] ip4StringToByte(String ipAddress)
	{		
		//Parse IP address.
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName(ipAddress);
		} catch (UnknownHostException e) {
			System.out.println("Unknown Host Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		
		byte[] ipByte = ip.getAddress();
		
		return ipByte;
	}
	
	public static void launchPoisonPacket(byte[] dnsAddress, 
			byte[] poisonIP, String hostname, 
			int destinationPort, int transactionID)
	{
		//Get a record to add to the packet.
		byte[] packet = null;
		
		System.out.println("STUBBED POISON PACKET GENERATION - IMPLEMENT!");
		
		try {
			//Open a socket to send it on.
            DatagramSocket socket = new DatagramSocket();
            try {		
		        //Craft a datagram to send. Changed
	    	    DatagramPacket dPacket = new DatagramPacket(packet, packet.length);
	
			    dPacket.setAddress(InetAddress.getByAddress(dnsAddress));
			    dPacket.setPort(destinationPort);
			    //Send it.
			    socket.send(dPacket);
            } finally {
            	socket.close();
            }
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to grab socket for port.");
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Port out of range");
			System.out.println(e.getMessage());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
}
