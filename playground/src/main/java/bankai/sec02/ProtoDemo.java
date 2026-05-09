package bankai.sec02;

import bankai.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger logger = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setName("Aditya")
                .setAge(25)
                .build();

        logger.info("Person {} \n", person);
    }


}
