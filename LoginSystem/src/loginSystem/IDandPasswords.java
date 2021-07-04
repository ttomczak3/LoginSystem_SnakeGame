package loginSystem;

import java.util.HashMap;

public class IDandPasswords {

	// Storing an ID and Password in a HashMap
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	// Default constructor
	IDandPasswords() {
		
		logininfo.put("Bob", "coffee");
		logininfo.put("Onn", "password");
		
	}
	
	// Using a method for classes that request the HashMap
	protected HashMap getLoginInfo() {
		
		return logininfo;
		
	}
	
}
