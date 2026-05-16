package bankai.sec04;

import bankai.models.common.Address;
import bankai.models.common.BodyStyle;
import bankai.models.common.Car;
import bankai.models.sec04.Person;
import bankai.models.sec04.Sample;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class PersonDemo {

    private static final Logger log = LoggerFactory.getLogger(PersonDemo.class);

    public static void main(String[] args) {

        var address = Address.newBuilder().setCity("atlanta").build();
        var car = Car.newBuilder().setBodyStyle(BodyStyle.COUPE).build();
        var person = Person.newBuilder()
                .setName("sam")
                .setAge(12)
                .setCar(car)
                .setAddress(address)
                .build();

        log.info("{}", person);


        Sample sample = Sample.newBuilder()
                .setAge(Int32Value.of(12))
                .setTime(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build())
                .build();

        log.info("sample {}", sample.getAge());

    }

}
