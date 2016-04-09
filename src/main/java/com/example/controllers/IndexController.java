package com.example.controllers;

import com.example.beans.hello.HelloBean;
import com.example.beans.hello.HelloBeanImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.entities.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Mateusz Purgał on 2016-04-08.
 */
@Controller
public class IndexController {

    @Autowired
    private HelloBeanImplementation helloBean;

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping("/")
    String index()
    {

        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        AppUser user = new AppUser("firstuser");
        session.save(user);
        session.persist(user);


        session.getTransaction().commit();
        session.close();





        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/spring-config.xml");
        HelloBean obj = (HelloBean) context.getBean("HelloBean");
        obj.sayHello();

        return "stronaGlowna";
    }

    @RequestMapping("/rezerwacja")
    String index2()
    {
        helloBean.sayHello();
        return "rezerwacjaMiejsca";
    }

    @RequestMapping("/kot/{imie}")
    public String szczegolyKota(@PathVariable("imie") String imie) {
        System.out.println(imie);

        return "stronaGlowna";
    }

}
