package com.ilya.services;

import com.ilya.dao.CourseDao;
import com.ilya.entities.Course;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CourseService {

    private final CourseDao courseDao;

    private final Logger logger = Logger.getLogger(CourseService.class.getName());

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<Course> getAllCourses() {
        logger.info("Requesting all courses");
        try {
            return courseDao.findAllCourses();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Something went wrong");
            return Collections.emptyList();
        }
    }

    public Course getOneCourse(Integer category) {
        logger.info("Requesting category with category: " + category);
        try {
            return courseDao.findCourseByCategory(category);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Something went wrong");
            return null;
        }
    }

}
