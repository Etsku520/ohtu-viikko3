package ohtu;

public class Submission {
    private int week;
    private int hours;
    private String course;
    private int[] exercises;
    private String fullName;
    private String name;
    private String term;
    private String year;
    private int students;
    private int hour_total;
    private int exercise_total;

    public void setWeek(int week) {
        this.week = week;
    } 

    public void setStudents(int students) {
        this.students = students;
    }

    public void setHour_total(int hour_total) {
        this.hour_total = hour_total;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setExercise_total(int exercise_total) {
        this.exercise_total = exercise_total;
    }

    public int getStudents() {
        return students;
    }

    public int getHour_total() {
        return hour_total;
    }

    public String getFullName() {
        return fullName;
    }

    public int getExercise_total() {
        return exercise_total;
    }

    public String getYear() {
        return year;
    }

    public String getTerm() {
        return term;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public String getFullname() {
        return fullName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullname(String fullname) {
        this.fullName = fullname;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    
    public int getWeek() {
        return week;
    }

    public String getCourse() {
        return course;
    }

    public int[] getExercises() {
        return exercises;
    }

    public int getHours() {
        return hours;
    }
    

    @Override
    public String toString() {
        
        return "";
    }
    
}