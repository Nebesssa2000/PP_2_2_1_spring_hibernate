package hiber.dao;

import hiber.model.Car;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Repository
public class CarDaoImp implements CarDao{
    SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void add(Car car) {
            sessionFactory.getCurrentSession().save(car);
    }
}
