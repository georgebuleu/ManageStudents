package DAO;

import Database.Database;
import beans.StudentBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements DAO{

    @Override
    public StudentBean getStudent(int id) {
        StudentBean student = new StudentBean();
        try {
            Connection con = DriverManager.getConnection(Database.URL);
            PreparedStatement stmt = con.prepareStatement("Select * from students where id = ?;");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
               student.setId(resultSet.getInt("id"));
               student.setYear(resultSet.getInt("year"));
               student.setAge(resultSet.getInt("age"));
               student.setSurname(resultSet.getString("surname"));
               student.setName(resultSet.getString("name"));
               student.setCollege(resultSet.getString("college"));
            }
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<StudentBean> getStudents() {
       List<StudentBean> students = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(Database.URL);
            PreparedStatement stmt = con.prepareStatement("Select * from students;");
            ResultSet resultSet = stmt.executeQuery();
            int count = 0;
            while(resultSet.next()) {
                students.add(new StudentBean());

                students.get(count).setId(resultSet.getInt("id"));
                students.get(count).setYear(resultSet.getInt("year"));
                students.get(count).setAge(resultSet.getInt("age"));
                students.get(count).setSurname(resultSet.getString("surname"));
                students.get(count).setName(resultSet.getString("name"));
                students.get(count).setCollege(resultSet.getString("college"));
            }
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void addStudent(StudentBean studentBean) {
        try {
            Connection con = DriverManager.getConnection(Database.URL);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO STUDENTS(ID, NAME, SURNAME, AGE, COLLEGE, YEAR) VALUES(?,?,?,?,?,?);");
            stmt.setInt(1, studentBean.getId());
            stmt.setString(2, studentBean.getName());
            stmt.setString(3, studentBean.getSurname());
            stmt.setInt(4, studentBean.getAge());
            stmt.setString(5, studentBean.getCollege());
            stmt.setInt(6, studentBean.getYear());
            stmt.executeUpdate();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(StudentBean studentBean) {

    }

    @Override
    public void deleteStudent(String name, String surName) {

    }
}
