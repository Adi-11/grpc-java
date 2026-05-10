package bankai.sec03;

import bankai.models.sec03.Address;
import bankai.models.sec03.Car;
import bankai.models.sec03.Library;
import bankai.models.sec03.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchoolDemo {

    private static final Logger log = LoggerFactory.getLogger(SchoolDemo.class);

    public static void main(String[] args) {
        School school = School.newBuilder().build();

        log.info("school {}", school);

        log.info("school {}", school.getAddress().getStreet());

        log.info("is default {}", school.getAddress().equals(Address.getDefaultInstance()));

        log.info("has address {}", school.hasAddress());

        Library library = Library.newBuilder().build();
        log.info("library {}", library.getBooksList());

        Car car = Car.newBuilder().build();
        log.info("car type {}", car.getBodyStyle());
    }
}
