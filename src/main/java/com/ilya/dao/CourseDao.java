package com.ilya.dao;

import com.ilya.entities.Course;
import com.ilya.services.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDao {

    private final Connection connection;

    public CourseDao(DatabaseConnection databaseConnection) {
        this.connection = databaseConnection.getConnection();
    }

    public List<Course> findAllCourses() throws SQLException {
        List<Course> result = new ArrayList<>();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM course");

        while (rs.next()) {
            Course course = buildCourse(rs);
            result.add(course);
        }
        rs.close();
        st.close();

        return result;
    }

    public Course findCourseByCategory(Integer category) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM course WHERE cour_id = ?");
        st.setInt(1, category);

        ResultSet rs = st.executeQuery();

        Course res = null;
        if (rs.next()) {
            res = buildCourse(rs);
        }

        rs.close();
        st.close();

        return res;
    }

    private Course buildCourse(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getInt("cour_id"));
        course.setName(rs.getString("nameCour"));
        course.setCategory(rs.getInt("category"));
        course.setCountry(rs.getString("countryCour"));
        course.setCook(rs.getInt("cook"));
        return course;
    }

}
