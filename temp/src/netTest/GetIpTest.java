package netTest;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class GetIpTest {
	public static void main(String[] args) throws SocketException, UnknownHostException {
		Enumeration<NetworkInterface> e=NetworkInterface.getNetworkInterfaces();
		//System.out.println(InetAddress.getLocalHost());
		while(e.hasMoreElements()){
			NetworkInterface ni=e.nextElement();
			Enumeration<InetAddress> eip=ni.getInetAddresses();
	        while(eip.hasMoreElements()){
	        	System.out.println(eip.nextElement().getHostAddress());
	        }
			
	    }
	}
}
