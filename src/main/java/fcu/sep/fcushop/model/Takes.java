package fcu.sep.fcushop.model;

public class Takes {
  private String Student_ID;
  private int Course_ID;
  private String Course_Name;

  public Takes(String Student_ID, int Course_ID, String Course_Name){
    this.Student_ID = Student_ID;
    this.Course_ID = Course_ID;
    this.Course_Name = Course_Name;
  }

  public String getStudent_ID() {
    return Student_ID;
  }

  public void setStudent_ID(String student_ID) {
    Student_ID = student_ID;
  }

  public int getCourse_ID() {
    return Course_ID;
  }

  public void setCourse_ID(int course_ID) {
    Course_ID = course_ID;
  }

  public String getCourse_Name() {
    return Course_Name;
  }

  public void setCourse_Name(String course_Name) {
    Course_Name = course_Name;
  }
}

