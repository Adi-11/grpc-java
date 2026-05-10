package bankai.sec03;

import bankai.models.sec03.BodyType;
import bankai.models.sec03.Car;
import bankai.models.sec03.Cars;
import bankai.models.sec03.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarDemo {
    private static final Logger logger = LoggerFactory.getLogger(CarDemo.class);

    public static void main(String[] args) {
        Car car1 = getCar("Honda", "City", BodyType.SEDAN, 2002);
        Car car2 = getCar("Ford", "Mustang", BodyType.COUPE, 1997);
        Car car3 = getCar("Mahindra", "XUV 700", BodyType.SUV, 2001);
        Car car4 = getCar("Ford", "Fortuner", BodyType.SUV, 1998);

        List<Car> cars = List.of(car1, car2, car3, car4);


        Map<String, Cars.Builder> carTypeMap = new HashMap<>();

        cars.forEach(car -> {
            carTypeMap.computeIfAbsent(car.getBodyStyle().name(), k -> Cars.newBuilder()).addCar(car);
        });

        Dealer.Builder typeDealerBuilder = Dealer.newBuilder();


        carTypeMap.forEach((key, value) -> {
            typeDealerBuilder.putInventory(key, value.build());
        });

        Dealer typeDealer = typeDealerBuilder.build();

        logger.info("dealer by type {}", typeDealer);


        Map<String, Cars.Builder> carYearMap = new HashMap<>();

        cars.forEach(car -> carYearMap.put(String.valueOf(car.getYear()), Cars.newBuilder().addCar(car)));


        Dealer.Builder yearDealerBuilder = Dealer.newBuilder();
        carYearMap.forEach((key, value) -> {
            yearDealerBuilder.putInventory(key, value.build());
        }) ;

        Dealer yearDealer = yearDealerBuilder.build();

        logger.info("dealer by year {}", yearDealer);

    }


    private static Car getCar(String make, String model, BodyType bodyType, int year) {
        return Car.newBuilder()
                .setMake(make)
                .setModel(model)
                .setBodyStyle(bodyType)
                .setYear(year)
                .build();
    }


}
