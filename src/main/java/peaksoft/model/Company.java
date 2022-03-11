package peaksoft.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",sequenceName = "company_sequence",allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "company_sequence")
    private long id;
    private String name;
    @Column(name = "located_country")
    private String locatedCountry;

    @OneToMany(cascade = ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private List<Course> courses;

    @OneToMany(cascade = ALL,mappedBy = "company")
    private List<Teacher> teacher;

    @OneToMany(cascade = ALL,mappedBy = "company")
    private List<Group> groups;

    public void setCourses(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Company() {
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

    public String getLocatedCountry() {
        return locatedCountry;
    }

    public void setLocatedCountry(String locatedCountry) {
        this.locatedCountry = locatedCountry;
    }


}
