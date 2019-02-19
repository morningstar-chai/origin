package login;

import Utils.URLs;
import org.junit.Test;
import pages.LoginPage;
import utils.BaseTest;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void verify_login_as_valid_user_from_login_page(){

        /*
            Go to login page
            Verify user is on login page
            Verify user login with valid credentials
            Logout User
         */

        String current_page_url = loginPage.goToLoginPage();
        assertTrue(current_page_url.contains(propertiesUtil.getProperty(URLs.HS_LOGIN_URL_KEY)));
        verify_login_as_valid_user();
        loginPage.logout_user();

    }

    @Test
    public void verify_login_as_valid_user_from_home_page(){

        /*
            Go to hello sign home page
            Hover over Login Button on top right corner
            Click on Hello Sign
            Verify user login with valid credentials
            Logout User
         */

        homePage.goToHelloSignHomePage();
        homePage.hover_over_login();
        homePage.click_on_helloSign_login();
        verify_login_as_valid_user();
        loginPage.logout_user();

    }

    @Test
    public void verify_logout_user(){

        /*
            Verify user login with valid credentials from login page
            Logout User
         */
        verify_login_as_valid_user_from_login_page();
        loginPage.logout_user();

    }

    public void verify_login_as_valid_user(){

        /*
            Login as existing user with valid credentials
            Verify user has successfully logged into hello sign
         */
        String signedInWelcomeMessage =
                loginPage.login_existing_user(propertiesUtil.getProperty(URLs.HS_USER_NAME), propertiesUtil.getProperty(URLs.HS_USER_PWD));

        System.out.println("signedInWelcomeMessage: " + signedInWelcomeMessage);
        assertThat(signedInWelcomeMessage, is(equalToIgnoringCase(propertiesUtil.getProperty(URLs.HS_WHO_NEEDS_TO_SIGN))));

    }
}
