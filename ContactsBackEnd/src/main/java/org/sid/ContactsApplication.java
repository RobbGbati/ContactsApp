package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsApplication  implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Afi","Pepeli",df.parse("01/07/2019"), "afi@test.com", 16812815,"afi.jpeg"));
		contactRepository.save(new Contact("Jasmine","Laura",df.parse("27/07/2019"), "laura@test.com", 10681305,"laura.jpeg"));
		contactRepository.save(new Contact("Basile","Epouh",df.parse("01/01/2019"), "basile@test.com", 8130565,"basile.jpeg"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}
}
