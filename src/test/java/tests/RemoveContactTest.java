package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest  extends TestBase {


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

//     @Test
//    public void removeContact(){
//
//       int contactsBeforeRemove = app.getContact().contactList();
//
//        logger.info("Contacts list before remove " + contactsBeforeRemove);
//
//        app.getContact().choiceContact();
//        app.getContact().clickRemoveButton();
//
//        app.getContact().pause(3000);
//
//        int contactsAfterRemove = app.getContact().contactList();
//
//        logger.info("Contacts list after remove " + contactsAfterRemove);
//
//        Assert.assertTrue(contactsBeforeRemove > contactsAfterRemove);
//
//        }

    @Test
    public void removeOneContactPositive() {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Sara" + i)
                .lastName("Green" + i)
                .phone("12333" + i + "034")
                .email("sara_" + i + "@mail.com")
                .address("Rehovot")
                .description("friend from job")
                .build();
        app.getContact().addContact(contact);
        int res = app.getContact().removeOneContact();
        if(res == 0) {
            Assert.assertTrue(app.getContact().isNoContacts());
            return;
        }
        Assert.assertEquals(1, res);
    }
        @Test
        public void removeContactsPositive () {
            app.getContact().removeAllContacts();
            Assert.assertTrue(app.getContact().isNoContacts());
        }

        @AfterMethod(alwaysRun = true)
        public void postCondition () {
            app.getUser().logOut();
        }


    }
