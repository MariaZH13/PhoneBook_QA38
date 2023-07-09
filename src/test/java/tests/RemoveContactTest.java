package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest  extends TestBase{


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
    public void removeAOneContactPositive(){
        int res = app.getContact().removeOneContact();
        Assert.assertEquals(-1,res);

    }

    @Test
    public void removeAllContactsPositive(){
        app.getContact().removeAllContacts();
        Assert.assertTrue(app.getContact().isNoContacts());
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().logOut();
    }




}
