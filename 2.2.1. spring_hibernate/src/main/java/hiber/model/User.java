package hiber.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User implements Serializable {
   static long serialVersionUID = 1L;
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

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @PrimaryKeyJoinColumn
   Car usercar;

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
