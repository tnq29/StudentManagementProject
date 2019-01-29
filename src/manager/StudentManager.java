package manager;

import model.Student;
import io.FileManager;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;
    private FileManager fileManager;

    public StudentManager() {
        fileManager = new FileManager();
        students = fileManager.read();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean isExist(Student newStudent) {
        for (Student student : students) {
            if (student.getId() == newStudent.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addStudent(Student student) {
        if (isExist(student)) {
            return false;
        }
        else {
            students.add(student);
            fileManager.write(students);
            return true;
        }
    }

    public boolean removeStudent(int id) {
        if (!isExist(getStudent(id))) {
            return false;
        }
        else {
            students.remove(getStudent(id));
            fileManager.write(students);
            return true;
        }
    }

    public boolean editStudent(Student student) {
        if (isExist(student)) {
            students.set(students.indexOf(getStudent(student.getId())), student);
            fileManager.write(students);
            return true;
        }
        else {
            return false;
        }
    }

    public void getStudentsByScore() {
        float highestScore = students.get(0).getScore();
        int highestScoreIndex = 0;
        for (int i = 0 ; i < students.size() ; i++) {
            if (students.get(i).getScore() >= highestScore) {
                highestScore = students.get(i).getScore();
                highestScoreIndex = i;
            }
        }
        for (Student student : students) {
            if (student.getScore() == students.get(highestScoreIndex).getScore()) {
                System.out.println(student);
            }
        }

    }

    public ArrayList<Student> getStudentsByFaculty(String faculty) {
        ArrayList<Student> studentsByFaculty = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().toString().equals(faculty)) {
                studentsByFaculty.add(student);
            }
        }
        return studentsByFaculty;
    }

    public ArrayList<Student> getExcellentStudents() {
        ArrayList<Student> excellentStudent = new ArrayList<>();
        for (Student student : students) {
            if(student.getScore() >= 9.9) {
                excellentStudent.add(student);
            }
        }
        return excellentStudent;
    }

    public ArrayList<Student> getSeeYouNextYearStudents() {
        ArrayList<Student> seeYouNextYearStudent = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() < 4.0) {
                seeYouNextYearStudent.add(student);
            }
        }
        return seeYouNextYearStudent;
    }
}
