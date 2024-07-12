package org.example.spring_app_orm.test;

import org.example.spring_app_orm.dao.StudentDao;
import org.example.spring_app_orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);

//        Student student=new Student(102,"Ram","Bholaram");
//        int result=studentDao.insert(student);
//        System.out.println("Insertion Done:"+result);

        System.out.println("********Welcome To ORM Application********");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        boolean go=true;
        while (go){
           System.out.println("Press 1 for add new student info:");
           System.out.println("Press 2 for display all student:");
           System.out.println("Press 3 for display single student:");
           System.out.println("Press 4 for delete student info:");
           System.out.println("Press 5 for Update:");
           System.out.println("Press 6 for Exit:");

           try {

               int input=Integer.parseInt(br.readLine());

               switch (input){
                   case 1:
                       //add student info
                       System.out.println("Enter student id:");
                       int sId=Integer.parseInt(br.readLine());

                       System.out.println("Enter student name:");
                       String sName=br.readLine();

                       System.out.println("Enter student city:");
                       String sCity=br.readLine();

                       Student s=new Student();
                       s.setId(sId);
                       s.setName(sName);
                       s.setCity(sCity);

                       int r=studentDao.insert(s);
                       System.out.println(r+":students added!!");

                       System.out.println("*****************************************************");
                       System.out.println();
                       break;

                   case 2:
                       //Display all student info
                       System.out.println("*****************************************************");

                       List<Student> allStudent=studentDao.getAllStudent();
                       for (Student st:allStudent){
                           System.out.println("Student ID:"+st.getId());
                           System.out.println("Student Name:"+st.getName());
                           System.out.println("Student City:"+st.getCity());
                           System.out.println("___________________________________________________");
                       }
                       System.out.println("******************************************************");
                       System.out.println();
                       break;

                   case 3:
                       //Display single student info
                       System.out.println("Enter student id:");
                       int userID=Integer.parseInt(br.readLine());
                       Student student=studentDao.getStudent(userID);

                       System.out.println("Student Id:"+student.getId());
                       System.out.println("Student Name:"+student.getName());
                       System.out.println("Student City:"+student.getCity());

                       System.out.println("*********************************************************");
                       System.out.println();
                       break;

                   case 4:
                       //Delete student info
                       System.out.println("Enter student Id:");
                       int id=Integer.parseInt(br.readLine());
                       studentDao.deleteStudent(id);
                       System.out.println("Student Deleted.....");
                       break;

                   case 5:
                       //update
                       System.out.println("Enter Student Id:");
                       int updateId=Integer.parseInt(br.readLine());

                       System.out.println("Press 1 to update Name:");
                       System.out.println("Press 2 to update City:");

                       int name_city=Integer.parseInt(br.readLine());

                       Student student1=studentDao.getStudent(updateId);

                       String updatedName=student1.getName();
                       String updatedCity=student1.getCity();

                       switch (name_city){
                           case 1:
                               System.out.println("Enter name to be Updated:");
                               updatedName=br.readLine();
                               student1=new Student(updateId,updatedName,updatedCity);
                               break;

                           case 2:
                               System.out.println("Enter city to be Updated:");
                               updatedCity= br.readLine();
                               student1=new Student(updateId,updatedName,updatedCity);
                               break;
                       }

                       studentDao.updateStudent(student1.getId());
                       System.out.println("Updated.....");
                       break;

                   case 6:
                       //Exit
                       go=false;
                       break;

               }


           }catch (Exception e){
               System.out.println("Invalid input try another one!!");
               System.out.println(e.getMessage());
           }
       }

    }
}
