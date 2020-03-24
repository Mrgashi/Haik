package haik.demo.ride;


import haik.demo.user.User;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "Ride")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable=false)
    private Long ride_id;

    @Temporal(DATE)
    @Column (name = "created")
    private Date created = new Date();

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "User_Ride",
            joinColumns = {@JoinColumn(name = "ride_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> passengers = new HashSet<>();


    @ManyToOne
    @JoinColumn(name="createdbyid"
    )
    private User driver;

    @Column (name = "startdate")
    private String startDate;
    @Column (name = "starttime")
    private String starttime;
    @Column (name = "seatsavailable")
    private int seatsavailable;
    @Column (name = "startlocation")
    private String startlocation;
    @Column (name = "destination")
    private String destination;
    @Column (name = "comments")
    private String comments;


    public Ride() {
    }

    // sett created dato til nå
    @PrePersist
    protected void onCreate() {
        this.created = new Date();
    }


    public Long getRide_id() {
        return ride_id;
    }

    public void setRide_id(Long id) {
        this.ride_id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User createdbyid) {
        this.driver = createdbyid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public int getSeatsavailable() {
        return seatsavailable;
    }

    public void setSeatsavailable(int seatsavailable) {
        this.seatsavailable = seatsavailable;
    }

    public String getStartlocation() {
        return startlocation;
    }

    public void setStartlocation(String startlocation) {
        this.startlocation = startlocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<User> users) {
        this.passengers = users;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + ride_id +
                ", created=" + created +
                ", users=" + passengers +
                ", createdbyid=" + driver +
                ", startDate='" + startDate + '\'' +
                ", starttime='" + starttime + '\'' +
                ", seatsavailable=" + seatsavailable +
                ", startlocation='" + startlocation + '\'' +
                ", destination='" + destination + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
