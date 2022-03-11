package peaksoft.model;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.*;


@Entity
@Table(name = "groups")
@ToString
public class Group {

    @Id
    @SequenceGenerator(
            name = "group_sequence",sequenceName = "group_sequence",allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "group_sequence")

    private long id;
    @Column(name = "group_name")
    private String name;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finis")
    private String dateOfFinis;
    @Transient
    private String courseName;
    @ManyToMany(cascade = {PERSIST,MERGE,REFRESH} , fetch = FetchType.EAGER)
    @JoinTable(name = "course_group"
            , joinColumns = @JoinColumn(name = "group_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @OneToMany(cascade = ALL, mappedBy = "group",fetch = FetchType.LAZY)
    private List<Student> students;

    @ManyToOne(cascade = {REFRESH,DETACH,MERGE,PERSIST})
    @JoinColumn(name = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Group() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Group(String name, String dateOfStart, String dateOfFinis) {
        this.name = name;
        this.dateOfStart = dateOfStart;
        this.dateOfFinis = dateOfFinis;
    }

    public void setCourses(Course course){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(course);
//        course.setGroups(this);
    }


    public List<Course> getCourses() {
        return courses;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setCourses1(List<Course> courses) {
        this.courses = courses;
    }
}
