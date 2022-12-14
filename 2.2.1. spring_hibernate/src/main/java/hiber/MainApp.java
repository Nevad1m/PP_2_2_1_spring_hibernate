package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new Car("Audi", 5));
      userService.add(new Car("Lada", 2110));
      userService.add(new Car("Porsche", 123));
      userService.add(new Car("Renault", 1));

      List<User> users = userService.listUsers();
      List<Car> cars = userService.listCars();

      for (int i = 0; i < users.size(); i++) {
         users.get(i).setUserCar(cars.get(i));
         userService.update(users.get(i));
      }

      context.close();
   }
}
