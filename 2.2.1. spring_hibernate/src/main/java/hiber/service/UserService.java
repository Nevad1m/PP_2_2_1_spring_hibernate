package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();
    void add(User user);
    void update(User user);
    List<Car> listCars();
    void add(Car car);

    User getUserWithCar();
}
