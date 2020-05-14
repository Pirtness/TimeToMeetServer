package springBootRestService.entities;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    protected String name;
    protected String description;
    protected String country, city, street, house, building;
    protected String time;
    protected String date;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "user_id")
    private String username;


    public void change(Event event) {
        this.name = event.name;
        this.description = event.description;
        this.country = event.country;
        this.city = event.city;
        this.street = event.street;
        this.house = event.house;
        this.building = event.building;
        this.time = event.time;
        this.date = event.date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
