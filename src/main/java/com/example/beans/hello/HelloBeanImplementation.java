package com.example.beans.hello;

/**
 * Created by matipu on 2016-04-08.
 */
import org.springframework.stereotype.Repository;

@Repository
public class HelloBeanImplementation implements HelloBean{

    @Override
    public void sayHello() {
        System.out.println("no elo");
    }
}
