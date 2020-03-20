package haik.demo.ride;


import haik.demo.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(DATE)
    @Column (name = "created")
    private Date created;


    @Column (name="createdbyid") // må denne annoteres som foreign key
    private Long createdbyid;

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


// fjernet id fra construktur da denne opprettes i Db (Karoline)
//  public Ride (Long createdbyid, String startDate, Date starttime,  int seatsavailable, String startlocation, String destination, String comments){
////      this.created = new Date();
//      this.createdbyid = createdbyid;
//      this.startDate = startDate;
//      this.starttime = starttime;
//      this.seatsavailable = seatsavailable;
//      this.startlocation = startlocation;
//      this.destination = destination;
//      this.comments = comments;
//
//    }

    public Ride() {
    }

    // sett created dato til nå
    @PrePersist
    protected void onCreate() {
      this.created = new Date();
  }



    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getCreatedbyid() {
        return createdbyid;
    }

    public void setCreatedbyid(Long createdbyid) {
        this.createdbyid = createdbyid;
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

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", created=" + created +
                ", createdbyid=" + createdbyid +
                ", startDate=" + startDate +
                ", starttime=" + starttime +
                ", seatsavailable=" + seatsavailable +
                ", startlocation='" + startlocation + '\'' +
                ", destination='" + destination + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
