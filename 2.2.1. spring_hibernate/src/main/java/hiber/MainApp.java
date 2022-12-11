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

      userService.add(new User("Benjamin", "Franklin", "Benya$100@gmial.com", new Car("Cadillac TX",6)));
      userService.add(new User("Napoleon", "Bonaparte", "Waterloo@imper.be", new Car("Alpine A",110)));
      userService.add(new User("Gaius Iulius", "Caesar", "Roma@romail.it", new Car("Alfa Romeo",159)));
      userService.add(new User("Garry", "Potter", "Hogwarts@magic.uk", new Car("Nimbus",2000)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
          System.out.println("Car = " +user.getUsercar());
         System.out.println();
      }
       userService.getUserByCar("Alpine A", 110);
       System.out.println();

      context.close();
   }
}
