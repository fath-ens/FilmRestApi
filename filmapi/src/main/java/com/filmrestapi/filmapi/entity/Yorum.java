package com.filmrestapi.filmapi.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Yorum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fid;
    private String user;
    private String icerig;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIcerig() {
        return icerig;
    }

    public void setIcerig(String icerig) {
        this.icerig = icerig;
    }

    public Yorum(int fid, String user, String icerig) {
        this.fid = fid;
        this.user = user;
        this.icerig = icerig;
    }

    public Yorum() {
    }
}