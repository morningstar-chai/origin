package signDocuments;

import Utils.URLs;
import org.junit.Test;
import pages.JustMeSignPage;
import pages.LoginPage;
import pages.SignDocumentsPage;
import pages.UIUtilsPage;
import utils.BaseTest;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class JustMeSignPageTest extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    SignDocumentsPage signDocumentsPage = new SignDocumentsPage(driver);
    UIUtilsPage uiUtilsPage = new UIUtilsPage(driver);
    JustMeSignPage justMeSignPage = new JustMeSignPage(driver);

    @Test
    public void verify_file_upload() throws Exception{

        String filePath = propertiesUtil.getProperty("filePath");
        /*
          Login as existing user with valid credentials
          Go to Just Me Sign page
          Wait for the Just me sign page to load
          Click on Add file
          Upload File
         */
        loginPage.goToLoginPage();
        loginPage.login_existing_user(propertiesUtil.getProperty(URLs.HS_USER_NAME), propertiesUtil.getProperty(URLs.HS_USER_PWD));
        signDocumentsPage.click_on_just_me_sign_method();
        signDocumentsPage.get_main_div_just_me_sign_page();
        uiUtilsPage.upload_file(filePath);

    }

    @Test
    public void verify_document_is_viewable() throws Exception{

        /*
          Upload file
          Click on fill out and sign
          Verify that document is available for viewing and editing
         */
        verify_file_upload();
        justMeSignPage.click_fill_out_sign_button();
        assertThat(justMeSignPage.click_on_continue_button(), is(equalToIgnoringCase(propertiesUtil.getProperty(URLs.HS_CONTINUE))));

    }

    @Test
    public void verify_document_is_editable() throws Exception{
        /*
          Upload file
          Click on fill out and sign
          Drag and drop date text box on the doc
          Click on continue
          Verify that document is edited by verifying text on button ="Re-Edit"
         */
        verify_file_upload();
        justMeSignPage.click_fill_out_sign_button();
        justMeSignPage.drag_and_drop_date_text_box();
        justMeSignPage.click_on_continue_button();
        assertThat(justMeSignPage.get_reEdit_Button_Text(), is(equalToIgnoringCase(propertiesUtil.getProperty(URLs.HS_REEDIT))));

    }

    @Test
    public void verify_just_me_send_sign_request() throws Exception{

        /*
          Upload file
          Click on fill out and sign
          Drag and drop date text box on the doc
          Click on continue
          Send Just me sign request
         */
        verify_file_upload();
        justMeSignPage.click_fill_out_sign_button();
        justMeSignPage.drag_and_drop_date_text_box();
        justMeSignPage.click_on_continue_button();
        justMeSignPage.send_sign_request();
    }
}
