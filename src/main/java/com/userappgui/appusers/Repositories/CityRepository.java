package com.userappgui.appusers.Repositories;

import com.userappgui.appusers.Utility.HibernateHelper;
import com.userappgui.appusers.models.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CityRepository {

    public static void Add(City city) {
        SessionFactory factory = HibernateHelper.GetSessionFactory();
        System.out.println(1);
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        factory.close();
    }

    public static List<City> getAll() {
        SessionFactory factory = HibernateHelper.GetSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<City> cities = session.createQuery("FROM City", City.class).getResultList();
        session.getTransaction().commit();
        factory.close();

        return cities;
    }

}
