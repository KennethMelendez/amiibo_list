/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Dao.Dao;
import Dao.DaoImpl;
import Service.ServiceDao;
import Service.ServiceDaoImpl;
import View.UserIO;
import View.UserIOImpl;
import View.View;
import controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kmlnd
 */
public class App {
    public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Controller controller = ctx.getBean("controller" ,Controller.class);
    controller.run();

    }
}
