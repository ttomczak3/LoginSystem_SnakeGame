package loginSystem;

import java.util.HashMap;

public class IDandPasswords {

	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	IDandPasswords() {
		
		logininfo.put("Bob", "coffee");
		logininfo.put("Onn", "password");
		
	}
	
	protected HashMap getLoginInfo() {
		
		return logininfo;
		
	}
	
}
