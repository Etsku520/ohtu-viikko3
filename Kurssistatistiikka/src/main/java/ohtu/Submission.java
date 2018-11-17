package ohtu;

public class Submission {
    private int week;
    private int hours;
    private String course;
    private int[] exercises;

    public void setWeek(int week) {
        this.week = week;
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

    @Override
    public String toString() {
        String lause = course + ", viikko " + week + " tehtyhä tehtäviä yhteensä " + exercises.length + " aikaa kului yhteensä " + hours + " tehdyt tehtävät ";
        
        for (int ex : exercises) {
            lause += ex + ", ";
        }
        
        return lause;
    }
    
}