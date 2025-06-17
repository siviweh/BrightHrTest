package pages;

public class LoginPage extends BasePage {
	private final String loginButton = "//a[normalize-space()='Log in']";
    private final String emailField = "#username";
    private final String passwordField = "#password";
    private final String login = "//button[normalize-space()='Login']";
    

    public LoginPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    public void login(String email, String password) {
    	
        page.navigate("https://sandbox-app.brighthr.com/lite");
        page.click(loginButton);
        page.fill(emailField, email);
        page.fill(passwordField, password);
        page.click(login);
    }
}
