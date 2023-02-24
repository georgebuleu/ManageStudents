package DAO;

import beans.StudentBean;

import java.util.List;

public interface DAO {
    StudentBean getStudent(int id);
    List<StudentBean> getStudents();
    void addStudent(StudentBean studentBean);
    void updateStudent(StudentBean studentBean);
    void deleteStudent(String name, String surName);

}
