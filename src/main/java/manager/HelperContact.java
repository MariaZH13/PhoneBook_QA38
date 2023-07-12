package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperContact extends HelperBase {

    Logger logger = LoggerFactory.getLogger(HelperContact.class);
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        wd.findElement(By.xpath("//*[.='ADD']")).click();
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }

    public void submitContactForm() {
        click(By.xpath("//button[.='Save']"));
    }

    public boolean isContactCreated(Contact contact) {
        String phone = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3"))
                .getText();
        return phone.equals(contact.getPhone());

    }

    public void choiceContact() {
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
    }

    public void clickRemoveButton() {
        click(By.xpath("//button[.='Remove']"));
    }

    public int contactList() {
        return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"))
                .size();

    }

    public int removeOneContact() {

        int countBefore = countContacts();
        logger.info("Amount of contacts before is " + countBefore);
        if (countBefore == 0){
            logger.info("No contacts");
        return 0;
    }


        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        click(By.xpath("//button[.='Remove']"));

        pause(3000);

        int countAfter = countContacts();
        logger.info("Amount of contacts after is " + countAfter);

        return countBefore - countAfter;

    }

    public int countContacts(){
       return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"))
                .size();
    }

    public void removeAllContacts(){
        while(wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"))
                .size() > 0){
            removeOneContact();
        }
    }
    public boolean isNoContacts(){
       return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"))
                .size() == 0;
    }

    public void addContact(Contact contact){
        openContactForm();
        fillContactForm(contact);
        submitContactForm();

    }



}