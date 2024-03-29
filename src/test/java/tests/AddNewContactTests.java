package tests;

import manager.ProviderData;
import models.Contact;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewContactTests extends TestBase {

    Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (!app.getUser().isLogged()) {
            User user = User.builder()
                    .email("marzh@com")
                    .password("Qwe1234$")
                    .build();
            app.getUser().login(user);
        }
    }


    @Test(invocationCount = 3, groups = {"positive"})
    public void addNewContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Sara" + i)
                .lastName("Green" + i)
                .phone("12333" + i + "034")
                .email("sara_" + i + "@mail.com")
                .address("Rehovot")
                .description("friend from job")
                .build();

        logger.info("Phone number is " + contact.getPhone());
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();


        Assert.assertTrue(app.getContact().isContactCreated(contact));
    }

    @Test(dataProvider = "contactsDTO", dataProviderClass = ProviderData.class, groups = {"positive"})
    public void addNewContactPositiveAddition(Contact contact) {
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        Contact contact = Contact.builder()
//                .name("Sara" + i)
//                .lastName("Green" + i)
//                .phone("12333" + i + "034")
//                .email("sara_" + i + "@mail.com")
//                .address("Rehovot")
//                .description("friend from job")
//                .build();

        logger.info("Phone number is " + contact.getPhone());
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();


        Assert.assertTrue(app.getContact().isContactCreated(contact));


    }

//    @AfterMethod
//    public void postcondition(){
//        app.getUser().logOut();
//    }


}

