package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      User user1 = new User("Garry", "Potter", "Hogwarts@magic.uk");
      User user2 = new User("Gaius Iulius", "Caesar", "Roma@romail.it");
      User user3 = new User("Napoleon", "Bonaparte", "Waterloo@imper.be");
      User user4 = new User("Benjamin", "Franklin", "Benya$100@gmial.com");

      Car car1 = new Car("Nimbus",2000);
      Car car2 =  new Car("Alfa Romeo",159);
      Car car3 =  new Car("Alpine A",110);
      Car car4 =   new Car("Cadillac TX",6);

      car1.setUser(user1);
      car2.setUser(user2);
      car3.setUser(user3);
      car4.setUser(user4);

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);

      List<User> users = userService.listUsers();
      for (User user : users) {
          System.out.println("Id = "+user.getId());
          System.out.println("First Name = "+user.getFirstName());
          System.out.println("Last Name = "+user.getLastName());
          System.out.println("Email = "+user.getEmail());
          System.out.println();
      }
      System.out.println(userService.getUserByCar("Nimbus", 2000));
      System.out.println();

      context.close();
   }
}
