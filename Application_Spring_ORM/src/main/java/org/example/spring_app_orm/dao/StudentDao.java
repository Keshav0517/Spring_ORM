package org.example.spring_app_orm.dao;

import org.example.spring_app_orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate(){
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate=hibernateTemplate;
    }

    //insert data
    @Transactional
    public int insert(Student student){
        return (Integer) this.hibernateTemplate.save(student);
    }

    public List<Student> getAllStudent(){
        List<Student> students=this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    public Student getStudent(int id){
       Student student=this.hibernateTemplate.get(Student.class,id);
       return student;
    }

    @Transactional
    public void deleteStudent(int id){
        Student student=this.hibernateTemplate.get(Student.class,id);
        this.hibernateTemplate.delete(student);
    }

    public void updateStudent(int id){
        Student student=this.hibernateTemplate.get(Student.class,id);
        this.hibernateTemplate.update(student);
    }




}
