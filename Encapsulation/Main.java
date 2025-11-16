// TestStudent.java
package Encapsulation;

public class Main {
    public static void main(String[] args) {
        // Create student
        Student student = new Student("John", 20, 3.5);
        
        // ✅ Access via getters (CONTROLLED READ)
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("GPA: " + student.getGpa());
        
        // ✅ Modify via setters (CONTROLLED WRITE)
        student.setAge(21);           // Valid
        student.setGpa(3.8);          // Valid
        student.setAge(-5);           // Invalid - validation prevents it
        student.setGpa(5.0);          // Invalid - validation prevents it
        
        //  Cannot access private fields directly
        // student.name = "Hacker";   // Compilation ERROR!
        // student.age = -999;        // Compilation ERROR!
        
        student.displayInfo();
    }
}