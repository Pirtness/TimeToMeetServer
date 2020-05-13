package springBootRestService.entities;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    protected String name;
    protected String description;
    String country, city, street, house, building;
    protected String time;
    protected String date;

    //Image
}
