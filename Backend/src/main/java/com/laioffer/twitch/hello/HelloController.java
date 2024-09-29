package com.laioffer.twitch.hello;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world!!";
    }

    @GetMapping("/hello2")
    public String sayHello2() {
        return "Hello world too!!!!!!!";
    }

    @GetMapping("/hello3")
    public String sayHello3() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String company = faker.company().name();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String bookTitle = faker.book().title();
        String bookAuthor = faker.book().author();

        String template = "This is %s\n" +
                "I work at %s\n" +
                "I live at %s in %s %s\n" +
                "My favorite book is %s by %s\n";
        return String.format(template, name, company, street, city, state, bookTitle, bookAuthor);
    }
    @GetMapping("/hello4")
    public Person sayHello(@RequestParam(required = false) String locale) {
        if (locale == null) {
            locale = "en_US";
        }

        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        String company = faker.company().name();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String bookTitle = faker.book().title();
        String bookAuthor = faker.book().author();

        return new Person(name, company, new Address(street, city, state, null), new Book(bookTitle, bookAuthor));
    }
}
