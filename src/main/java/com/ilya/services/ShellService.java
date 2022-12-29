package com.ilya.services;

import com.ilya.entities.Course;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class ShellService {

    private final CourseService service;

    public ShellService(CourseService service) {
        this.service = service;
    }

    @ShellMethod("Find all courses")
    public String findAll() {
        List<Course> courses = service.getAllCourses();
        StringBuilder res = new StringBuilder();
        for (Course course : courses) {
            res.append(course).append("\n");
        }
        return res.toString();
    }

    @ShellMethod("Find one course with given category")
    public String find(@ShellOption String cat) {
        int category;
        try {
            category = Integer.parseInt(cat);
        } catch (IndexOutOfBoundsException e) {
            return "Too few args";
        } catch (NumberFormatException e) {
            return "Argument isn't a number";
        }
        Course course = service.getOneCourse(category);
        if (course == null) {
            return "No courses";
        }
        return course.toString();
    }

}
