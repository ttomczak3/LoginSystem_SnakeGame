package loginSystem;

public class Main {

	public static void main(String[] args) {
		
		IDandPasswords idandPasswords = new IDandPasswords();
		
		// Instance of our login page
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

	}

}
