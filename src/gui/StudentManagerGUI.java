package gui;

import manager.StudentManager;
import model.Faculty;
import model.Student;

import java.util.Scanner;

public class StudentManagerGUI {

    private StudentManager studentManager  = new StudentManager();
    private Scanner scanner = new Scanner(System.in);

    private short inputCaseNumber() {
        return scanner.nextShort();
    }

    public void mainGUI() {
        menu();
        while (true) {
            switch (inputCaseNumber()) {
                case 1:
                    addGUI();
                    menu();
                    break;

                case 2:
                    removeGUI();
                    menu();
                    break;

                case 3:
                    editGUI();
                    menu();
                    break;

                case 4:
                    showStudentWithHighestScoreGUI();
                    menu();
                    break;

                case 5:
                    showStudentGUI();
                    menu();
                    break;

                case 6:
                    showAllStudentsGUI();
                    menu();
                    break;

                case 7:
                    showStudentsByFaculty();
                    menu();
                    break;

                case 8:
                    showExcellentStudentGUI();
                    menu();
                    break;

                case 9:
                    showSeeYouNextYearStudentGUI();
                    menu();
                    break;

                case 10:
                    exitGUI();
                    break;

                default:
                    defaultGUI();
                    menu();
            }
        }
    }

    private void menu() {
        System.out.println(" ");
        System.out.println("=================== STUDENT MANAGER =======================");
        System.out.println("  1. Press 1 to ADD student                                ");
        System.out.println("  2. Press 2 to REMOTE student                             ");
        System.out.println("  3. Press 3 to EDIT student                               ");
        System.out.println("  4. Press 4 to SEE the student getting the HIGHEST SCORE  ");
        System.out.println("  5. Press 5 to PRINT student                              ");
        System.out.println("  6. Press 6 to SEE list of all students                   ");
        System.out.println("  7. Press 7 to SEE list of students by faculty            ");
        System.out.println("  8. Press 8 to SEE list of EXCELLENT students             ");
        System.out.println("  9. Press 9 to SEE list of 'SEE YOU NEXT YEAR' students   ");
        System.out.println("  10. Press 10 to QUIT                                     ");
        System.out.println("===========================================================");
        System.out.print("Please choose one option : ");

    }

    // input
    private int inputID() {
        System.out.print("Input ID: ");
        return scanner.nextInt();
    }

    private String inputName() {
        Scanner scannerName = new Scanner(System.in);
        System.out.print("Input Name: ");
        return scannerName.nextLine();
    }

    private float inputScore() {
        System.out.print("Input Score: ");
        return scanner.nextFloat();
    }

    private String inputFaculty() {
        Scanner scannerFaculty = new Scanner(System.in);
        System.out.print("Input Faculty: ");
        return scannerFaculty.nextLine();
    }

    // case 1
    private void addGUI() {

        int id = inputID();
        String name = inputName();
        float score = inputScore();
        Faculty faculty = Faculty.valueOf(inputFaculty());

        if (studentManager.addStudent(new Student(id, name, score, faculty))) {
            System.out.println("Added successfully!");
        }
        else {
            System.out.println("Already Exist! Please Input Again!");
        }
    }

    // case 2
    private void removeGUI() {
        int id = inputID();
        if (studentManager.removeStudent(id)) {
            System.out.println("Removed Successfully!");
        }
        else {
            System.out.println("Student is not exist!");
        }
    }

    // case 3
    private void editGUI() {
        int id = inputID();
        String name = inputName();
        float score = inputScore();
        Faculty faculty = Faculty.valueOf(inputFaculty());
        if (studentManager.editStudent(new Student(id, name, score, faculty))) {
            System.out.println("Edited Successfully!");
        } else {
            System.out.println("Student is already exist!");
        }
    }

    // case 4
    private void showStudentWithHighestScoreGUI() {
        System.out.println("Student with the highest score: ");
        studentManager.getStudentsByScore();
    }

    // case 5
    private void showStudentGUI() {
        int id = inputID();
        if (studentManager.isExist(studentManager.getStudent(id))) {
            System.out.println(studentManager.getStudent(id));
        } else {
            System.out.println("Student is not exist");
        }

    }

    // case 6
    private void showAllStudentsGUI() {
        System.out.println("\nLIST OF STUDENT\n");
        for (Student student : studentManager.getStudents()) {
            System.out.println(student);
        }
        System.out.println(" ");
    }

    // case 7
    private void showStudentsByFaculty() {
        String faculty = inputFaculty();
        if (studentManager.getStudentsByFaculty(faculty) != null) {
            for (Student student : studentManager.getStudentsByFaculty(faculty)) {
                System.out.println(student);
            }
        }
        else {
            System.out.println("NO DATA");
        }
    }

    // case 8
    private void showExcellentStudentGUI() {
        System.out.println(" ");
        System.out.println("EXCELLENT STUDENTS (SCORE >= 9.9)");
        for (Student student : studentManager.getExcellentStudents()) {
            System.out.println(student);
        }
    }

    // case 9
    private void showSeeYouNextYearStudentGUI() {
        System.out.println(" ");
        System.out.println("'SEE YOU NEXT YEAR' STUDENTS (SCORE < 4.0)");
        for (Student student : studentManager.getSeeYouNextYearStudents()) {
            System.out.println(student);
        }

    }

    // case 10
    private void exitGUI() {
        System.out.println("\n END");
        System.exit(1);
    }

    // default
    private void defaultGUI() {
        System.out.println("Please choose option 1 - 10");
    }

}
