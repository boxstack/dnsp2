package com.appspot.trent.denis;

import java.util.ArrayList;

public class HostRecord implements Comparable<HostRecord> {
	public HostRecord(String _domainName) {
		domainName = _domainName;
	}
	
	public void addIpAddress(IPAddress address) {
		for (IPAddress a: ipAddresses) {
			if (a.equals(address)) {
				return;
			}
		}
		ipAddresses.add(address);
	}
	
	public String getDomainName() {
		return domainName;
	}

	public ArrayList<IPAddress> getIpAddresses() {
		return ipAddresses;
	}
	
	public String toString() {
		return ipAddresses.toString();
	}

	String domainName = null;
	ArrayList<IPAddress> ipAddresses = new ArrayList<IPAddress>();
	
	public int compareTo(HostRecord o) {
		String revStr = new StringBuffer(domainName).reverse().toString();
		String otherRev = (new StringBuffer(o.domainName)).reverse().toString();
			
		return revStr.compareTo(otherRev);
	}
}
