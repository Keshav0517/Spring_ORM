package org.example.spring_orm.dao;

import org.example.spring_orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    //insert  & save data inside table
    @Transactional  //It is used to remove Read mode
    public int insert(Student student){
        Integer r=(Integer) this.hibernateTemplate.save(student);
        return r;
    }

    //get single data from table / Read
    public Student getStudent(int studentId){
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        return student ;
    }

    //get all students from table / getAll()
    public List<Student> getAllStudent(){
        List<Student> students=this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    //Deleting the data
    @Transactional
    public void deleteRow(int studentId){
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);
    }

    //Updating data
    @Transactional
    public void updateStudent(int studentId){
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.update(student);
    }



}
