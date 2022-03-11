package peaksoft.model;
import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",sequenceName = "course_sequence",allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_sequence")
    private long id;
    private String name;
    private String duration;

    @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = {MERGE,PERSIST,DETACH,REFRESH,REMOVE},mappedBy = "course")
    private Teacher teacher;

    @ManyToMany(cascade = {MERGE, REFRESH, DETACH, PERSIST,REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "course_group"
            , joinColumns = @JoinColumn(name = "course_id")
            , inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> group;


    public Course() {
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teachers) {
        this.teacher = teachers;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
