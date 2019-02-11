package com.events.apievents.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;


    @Column(name = "event_type")
    private Integer event_type;

    @Column(name = "event_description")
    private  String event_description;

    @Column(name = "event_date")
    private Date event_date;

    @Column(name = "created_at")
    private  Date created_at;

    @Column(name = "is_finish")
    private  Boolean is_finish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEvent_type() {
        return event_type;
    }

    public void setEvent_type(Integer event_type) {
        this.event_type = event_type;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Boolean getIs_finish() {
        return is_finish;
    }

    public void setIs_finish(Boolean is_finish) {
        this.is_finish = is_finish;
    }
}
