package bankai.sec02;

import bankai.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger logger = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
        Person person1 = getPerson();

        Person person2 = getPerson();

        logger.info("Equals {}", person1.equals(person2)); // true

        logger.info(" === {}", (person1 == person2)); // false


        // mutable ?? -> not mutable
        // create another instance with diff value
        Person person3 = person1.toBuilder().setName("Jacob").build();

        logger.info("Person3 {}", person3);

        // clear

        Person person4 = person1.toBuilder().clearName().build();

        logger.info("Person4 {}", person4);
    }


    private static Person getPerson() {
        return Person.newBuilder()
                .setName("Aditya")
                .setAge(25)
                .build();
    }


}
