/*Michael Blackburn
  CSCI 221
  Exercise11_05.java*/

/*This is a rewrite of the Course.java listing at listing 10.6 using and ArrayList instead of the String array.*/

import java.util.ArrayList;

public class Exercise11_05 {
  public static void main(String[] args) {
    Course course1 = new Course("Data Structures");
    Course course2 = new Course("Database Systems");

    course1.addStudent("Peter Jones");
    course1.addStudent("Brian Smith");
    course1.addStudent("Anne Kennedy");
    course1.addStudent("Susan Kennedy");
    course1.addStudent("John Kennedy");
    course1.addStudent("Kim Johnson");
    course1.addStudent("S1");
    course1.addStudent("S2");
    course1.addStudent("S3");
    course1.addStudent("S4");
    course1.addStudent("S5");
    course1.addStudent("S6");
    course1.addStudent("S7");
      
    course2.addStudent("Peter Jones");
    course2.addStudent("Steve Smith");

    System.out.println("Number of students in course1: "
      + course1.getNumberOfStudents());
    ArrayList<String> students = course1.getStudents();
    for (int i = 0; i < course1.getNumberOfStudents(); i++)
      System.out.print(students + ", ");
    
    System.out.println();
    System.out.print("Number of students in course2: "
      + course2.getNumberOfStudents());
    
    course1.dropStudent("S1");
    System.out.println("Number of students in course1: "
      + course1.getNumberOfStudents());
    students = course1.getStudents();
    for (int i = 0; i < course1.getNumberOfStudents(); i++)
      System.out.print(students + ", ");
    
    course1.clear();
    System.out.println("Number of students in course1: "
      + course1.getNumberOfStudents());
  }
}

class Course {
  private String courseName;
  private ArrayList students = new ArrayList();
  private int numberOfStudents;
    
  public Course(String courseName) {
    this.courseName = courseName;
  }
  
  public void addStudent(String student) {
  	students.add(student);
  }
   
  public ArrayList getStudents() {
  	return students;
  }

  public int getNumberOfStudents() {
  	return students.size();
  
  }  

  public String getCourseName() {
    return courseName;
  }  
  
  public void dropStudent(String student) {
  	students.remove(student);
  }
  
  public void clear() {
  	students.clear();
  }
}