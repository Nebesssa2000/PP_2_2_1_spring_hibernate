package hiber.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   Long id;

   @Column(name = "name")
   String firstName;

   @Column(name = "last_name")
   String lastName;

   @Column(name = "email")
   String email;

   @OneToOne(cascade = CascadeType.ALL, targetEntity = Car.class)
   @JoinColumn(name = "cars_id")
   Car usercar;

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public User(String firstName, String lastName, String email, Car usercar) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.usercar = usercar;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", usercar=" + usercar +
              '}';
   }
}
