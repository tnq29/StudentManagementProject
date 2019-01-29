package model;

import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private float score;
    private Faculty faculty;

    public Student(int id, String name, float score, Faculty faculty) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "[ " +
                " id = " + id +
                " | name = " + name +
                " | score = " + score +
                " | faculty = " + faculty +
                " ]";
    }
}
