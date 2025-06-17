package pages;

public class EmployeePage extends BasePage {

    private final String employeeTab = "[data-tab='employees']";
    private final String addEmployeeBtn = "button:has-text('Add employee')";
    private final String firstNameField = "input[name='firstName']";
    private final String lastNameField = "input[name='lastName']";
    private final String emailField = "input[name='email']";
    private final String phoneField = "input[name='phone']";
    private final String saveBtn = "button:has-text('Save')";

    public EmployeePage(com.microsoft.playwright.Page page) {
        super(page);
    }

    public void goToEmployeeTab() {
        page.click(employeeTab);

    }

    public void addEmployee(String firstName, String lastName, String email, String phone) {
        page.click(addEmployeeBtn);
        page.fill(firstNameField, firstName);
        page.fill(lastNameField, lastName);
        page.fill(emailField, email);
        page.fill(phoneField, phone);
        page.click(saveBtn);
    }

    public boolean verifyEmployeeExists(String name) {
        return page.locator("text=" + name).isVisible();
    }
}
