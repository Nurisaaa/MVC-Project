package peaksoft.dto;

public class RequestGroup {
    private String name;
    private String dateOfStart;
    private String dateOfFinis;
    private String courseName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getDateOfFinis() {
        return dateOfFinis;
    }

    public void setDateOfFinis(String dateOfFinis) {
        this.dateOfFinis = dateOfFinis;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
