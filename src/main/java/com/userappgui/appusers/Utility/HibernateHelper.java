package com.userappgui.appusers.Utility;

import com.userappgui.appusers.models.City;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

    public static SessionFactory GetSessionFactory () {
        return new Configuration()
                .addAnnotatedClass(City.class)
                .buildSessionFactory();
    }
}
