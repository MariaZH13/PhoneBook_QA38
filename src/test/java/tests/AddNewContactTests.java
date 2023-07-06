package tests;

import models.Contact;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewContactTests extends TestBase{

    Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);

    @BeforeMethod
    public void precondition(){
            if(!app.getUser().isLogged()){
                User user = User.builder()
                        .email("marzh@com")
                        .password("Qwe1234$")
                        .build();
                app.getUser().login(user);
            }
        }




    @Test(invocationCount = 5)
    public void addNewContactPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
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

    @Test
    public void removeContact(){

       int contactsBeforeRemove = app.getContact().contactList();

        System.out.println(contactsBeforeRemove);

        app.getContact().choiceContact();
        app.getContact().clickRemoveButton();

        app.getContact().pause(3000);

        int contactsAfterRemove = app.getContact().contactList();

        System.out.println(contactsAfterRemove);

        Assert.assertTrue(contactsBeforeRemove != contactsAfterRemove);





        }

    }




