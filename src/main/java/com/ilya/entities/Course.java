package com.ilya.entities;

public class Course {
    private Integer courseId;
    private String name;
    private Integer category;
    private String country;
    private Integer cook;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCook() {
        return cook;
    }

    public void setCook(Integer cook) {
        this.cook = cook;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", country='" + country + '\'' +
                ", cook=" + cook +
                '}';
    }
}
