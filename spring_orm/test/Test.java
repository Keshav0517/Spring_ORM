package org.example.spring_orm.test;

import org.example.spring_orm.dao.StudentDao;
import org.example.spring_orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);

        Student student=new Student(101,"Keshav","Core Java");
        int result=studentDao.insert(student);
        System.out.println("Done:"+result);

        Student read=studentDao.getStudent(101);
        System.out.println("Read Done:"+read);
    }
}
