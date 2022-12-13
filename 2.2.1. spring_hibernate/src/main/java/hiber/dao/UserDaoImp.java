package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Repository
public class UserDaoImp implements UserDao {


   SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String model, int series) {
      String query = "FROM Car WHERE model = :model AND series = :series";
      TypedQuery<Car> userQuery = sessionFactory.getCurrentSession().createQuery(query)
              .setParameter("model", model)
              .setParameter("series", series);

      Car car = userQuery.setMaxResults(1).getSingleResult();

      return car.getUser();
   }

}
