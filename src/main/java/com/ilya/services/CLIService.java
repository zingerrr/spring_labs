package com.ilya.services;

import com.ilya.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CLIService {

    private final CourseService courseService;

    private final Logger logger = Logger.getLogger(CLIService.class.getName());

    public CLIService(CourseService courseService) {
        this.courseService = courseService;
    }

    public void execute(String command) {
        String[] tokens = command.split(" ");
        if ("find-all".equals(tokens[0])) {
            List<Course> courses = courseService.getAllCourses();
            for (Course course : courses) {
                System.out.println(course);
            }
        } else if ("find".equals(tokens[0])) {
            int category;
            try {
                category = Integer.parseInt(tokens[1]);
            } catch (IndexOutOfBoundsException e) {
                logger.log(Level.WARNING, "Too few args");
                return;
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "Argument isn't a number");
                return;
            }
            Course course = courseService.getOneCourse(category);
            System.out.println(course);
        } else {
            System.out.println("Unknown command");
        }
    }

}
