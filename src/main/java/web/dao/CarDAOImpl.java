package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDAOImpl implements CarDao {
    private static Long CARS_COUNT = 1L;
    private static final List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(CARS_COUNT++, "Mercedes", 2000, "black"));
        cars.add(new Car(CARS_COUNT++, "Ferrari", 2015, "red"));
        cars.add(new Car(CARS_COUNT++, "Koenigsegg", 2010, "white"));
        cars.add(new Car(CARS_COUNT++, "Dodge", 1985, "orange"));
        cars.add(new Car(CARS_COUNT++, "Bugatti", 2020, "purple"));
    }
    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return cars;
        }

        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
