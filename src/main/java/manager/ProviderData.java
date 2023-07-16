package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider

    public Iterator<Object[]> userDTO() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{User.builder()
                .email("marge@mail.com")
                .password("Simpson1234$")
                .build()

        });
        list.add(new Object[]{User.builder()
                .email("homer@mail.com")
                .password("Simpson125$")
                .build()
        });
        list.add(new Object[]{User.builder()
                .email("liza@mail.com")
                .password("Simpson14$")
                .build()
        });
        list.add(new Object[]{User.builder()
                .email("bart@mail.com")
                .password("Simpson11$")
                .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userDTOcsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/reg_phonebook.csv")));
        String line = reader.readLine();
        while(line != null){
            String[] split = line.split(",");
            list.add(new Object[]{ User.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactsDTO() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/contacts_phonebook.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()
            });
            line = reader.readLine();
        }
            return list.iterator();
        }


    }
