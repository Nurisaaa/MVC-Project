package peaksoft.model;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",sequenceName = "teacher_sequence",allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_sequence")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @OneToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    @Transient
    private String courseName;
    @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_id")
    private Company company;

    public Teacher() {
    }

    public String getCourseName() {
        return courseName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
