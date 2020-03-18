package haik.demo.ride;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column (name = "created")
    private Date created;
    @Column (name = "startdate")
    private String startDate;
    @Column (name = "time")
    private int time;
    @Column (name = "seatsavailable")
    private int seatsavailable;
    @Column (name = "startlocation")
    private String startlocation;
    @Column (name = "destination")
    private String destination;
    @Column (name = "comment")
    private String comment;


// fjernet id fra construktur da denne opprettes i Db (Karoline)
  public Ride (String startDate, int seatsavailable, String startlocation, String destination, String comment, int time){
        this.comment = comment;
        this.created = new Date();
        this.startDate = startDate;
        this.destination = destination;
        this.seatsavailable = seatsavailable;
        this.startlocation = startlocation;
        this.time = time;
    }

    public Ride() {
    }

    // sett created dato til nå
    @PrePersist
    protected void onCreate() { this.created = new Date(); }


    public int getTime() {return time;}

    public void setTime(int time) {
      this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", created='" + created + '\'' +
                ", startDate='" + startDate + '\'' +
                ", seatsavailable=" + seatsavailable +
                ", startlocation='" + startlocation + '\'' +
                ", destination='" + destination + '\'' +
                ", comment='" + comment + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
