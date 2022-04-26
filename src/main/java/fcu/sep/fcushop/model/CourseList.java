package fcu.sep.fcushop.model;

public class CourseList {
  private int Course_ID;
  private String Class_Name;
  private String Course_Name;
  private int Capacity;
  private int Numbers;
  private int credits;
  private String Required_Elective_subject;
  private String Dep_Name;

  public int getCourse_ID() {
    return Course_ID;
  }

  public void setCourse_ID(int course_ID) {
    Course_ID = course_ID;
  }

  public String getClass_Name() {
    return Class_Name;
  }

  public void setClass_Name(String class_Name) {
    Class_Name = class_Name;
  }

  public String getCourse_Name() {
    return Course_Name;
  }

  public void setCourse_Name(String course_Name) {
    Course_Name = course_Name;
  }

  public int getCapacity() {
    return Capacity;
  }

  public void setCapacity(int capacity) {
    Capacity = capacity;
  }

  public int getNumbers() {
    return Numbers;
  }

  public void setNumbers(int numbers) {
    Numbers = numbers;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public String getRequired_Elective_subject() {
    return Required_Elective_subject;
  }

  public void setRequired_Elective_subject(String required_Elective_subject) {
    Required_Elective_subject = required_Elective_subject;
  }

  public String getDep_Name() {
    return Dep_Name;
  }

  public void setDep_Name(String dep_Name) {
    Dep_Name = dep_Name;
  }

  public CourseList(int Course_ID, String Class_Name, String Course_Name, int Capacity, int Numbers, int credits, String Required_Elective_subject, String Dep_Name){
    this.Course_ID = Course_ID;
    this.Class_Name = Class_Name;
    this.Course_Name = Course_Name;
    this.Capacity = Capacity;
    this.Numbers = Numbers;
    this.credits = credits;
    this.Required_Elective_subject = Required_Elective_subject;
    this.Dep_Name = Dep_Name;
  }
}
