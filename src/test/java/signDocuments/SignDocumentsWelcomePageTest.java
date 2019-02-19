package signDocuments;

import Utils.URLs;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.SignDocumentsPage;
import utils.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class SignDocumentsWelcomePageTest extends BaseTest {

    SignDocumentsPage signDocumentsPage = new SignDocumentsPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void verify_goto_sign_documents_welcome_page(){

        /*
           Go to login page
           Login as existing user with valid credentials
           Land on Sign Documents Welcome Page
           Verify landing on welcome page
           Logout user

         */
        loginPage.goToLoginPage();
        loginPage.login_existing_user(propertiesUtil.getProperty(URLs.HS_USER_NAME), propertiesUtil.getProperty(URLs.HS_USER_PWD));

        boolean signMethodsAvailable = signDocumentsPage.get_signing_method_options();
        assertThat(signMethodsAvailable, is(equalTo(false)));

        loginPage.logout_user();

    }

    @Test
    public void verify_goto_just_me_sign_doc_method(){

        /*
           Go to login page
           Login as existing user with valid credentials
           Click on Just Me Sign method
           Verify user is on Just Me Sign Page
           Logout user

         */
        loginPage.goToLoginPage();
        loginPage.login_existing_user(propertiesUtil.getProperty(URLs.HS_USER_NAME), propertiesUtil.getProperty(URLs.HS_USER_PWD));

        signDocumentsPage.click_on_just_me_sign_method();
        Assert.assertEquals(signDocumentsPage.get_main_div_just_me_sign_page(), propertiesUtil.getProperty(URLs.HS_SIGN_YOUR_DOCS));

        loginPage.logout_user();

        //close pricing modal
        //signDocumentsPage.wait_for__visible_pricing_modal();
        //signDocumentsPage.close_pricing_modal1();
    }

    @Test
    public void verify_goto_me_and_others_sign_doc_method(){

        /*
           Go to login page
           Login as existing user with valid credentials
           Click on Me and Others Sign method
           Verify user is on Me and Others Sign Page
           Logout user

         */
        loginPage.goToLoginPage();
        loginPage.login_existing_user(propertiesUtil.getProperty(URLs.HS_USER_NAME), propertiesUtil.getProperty(URLs.HS_USER_PWD));

        signDocumentsPage.click_on_me_and_others_sign_method();
        Assert.assertEquals(signDocumentsPage.get_main_div_me_others_sign_page(), propertiesUtil.getProperty(URLs.HS_GET_YOUR_DOCS_SIGNED));

        loginPage.logout_user();

        //close pricing modal
        //signDocumentsPage.wait_for__visible_pricing_modal();
        //signDocumentsPage.close_pricing_modal2();

    }

    @Test
    public void verify_goto_just_others_sign_doc_method(){

        /*
           Go to login page
           Login as existing user with valid credentials
           Click on Just Others Sign method
           Verify user is on Just and Others Sign Page
           Logout user
         */
        loginPage.goToLoginPage();
        loginPage.login_existing_user(propertiesUtil.getProperty(URLs.HS_USER_NAME), propertiesUtil.getProperty(URLs.HS_USER_PWD));

        signDocumentsPage.click_on_just_others_sign_method();
        Assert.assertEquals(signDocumentsPage.get_main_div_me_others_sign_page(), propertiesUtil.getProperty(URLs.HS_GET_YOUR_DOCS_SIGNED));

        loginPage.logout_user();

        //close pricing modal
        //signDocumentsPage.wait_for__visible_pricing_modal();
        //signDocumentsPage.close_pricing_modal3();

    }
}
