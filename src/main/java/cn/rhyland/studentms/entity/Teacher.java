package cn.rhyland.studentms.entity;

public class Teacher {
    private int Teacher_ID;
    private int Teacher_Number;
    private String Teacher_Name;
    private String Teacher_Password;

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int teacher_ID) {
        Teacher_ID = teacher_ID;
    }

    public int getTeacher_Number() {
        return Teacher_Number;
    }

    public void setTeacher_Number(int teacher_Number) {
        Teacher_Number = teacher_Number;
    }

    public String getTeacher_Name() {
        return Teacher_Name;
    }

    public void setTeacher_Name(String teacher_Name) {
        Teacher_Name = teacher_Name;
    }

    public String getTeacher_Password() {
        return Teacher_Password;
    }

    public void setTeacher_Password(String teacher_Password) {
        Teacher_Password = teacher_Password;
    }
}
