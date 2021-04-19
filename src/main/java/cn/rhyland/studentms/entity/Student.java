package cn.rhyland.studentms.entity;

public class Student {
    private int Student_ID;
    private String Student_Name;
    private int Student_Number;
    private String Student_Password;
    private int Class_ID;

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int student_ID) {
        Student_ID = student_ID;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getStudent_Number() {
        return String.valueOf(Student_Number);
    }

    public void setStudent_Number(int student_Number) {
        Student_Number = student_Number;
    }

    public String getStudent_Password() {
        return Student_Password;
    }

    public void setStudent_Password(String student_Password) {
        Student_Password = student_Password;
    }

    public String getClass_ID() {
        return String.valueOf(Class_ID);
    }

    public void setClass_ID(int class_ID) {
        Class_ID = class_ID;
    }
}
