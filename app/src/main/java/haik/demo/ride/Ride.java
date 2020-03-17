package haik.demo.ride;


import javax.persistence.*;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column (name = "created")
    private String created;
    @Column (name = "startdate")
    private String startDate;
    @Column (name = "seatsavailable") // ride
    private int seatsavailable;
    @Column (name = "startlocation")
    private String startlocation;
    @Column (name = "destination")
    private String destination;
    @Column (name = "comment")
    private String comment;



  public Ride (Long id, String created, String startDate, int seatsavailable, String startlocation, String destination, String comment){
        this.comment = comment;
        this.created = created;
        this.startDate = startDate;
        this.destination = destination;
        this.id = id;
        this.seatsavailable = seatsavailable;
        this.startlocation = startlocation;
    }

    public Ride() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
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
                '}';
    }
}
