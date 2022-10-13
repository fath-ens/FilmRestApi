package com.filmrestapi.filmapi.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Yorum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "fid")
    private Film fid;
    private String user;
    private String icerig;

    public Yorum(Film fid, String user, String icerig) {
        this.fid = fid;
        this.user = user;
        this.icerig = icerig;
    }

    public Yorum() {
    }

    public Film getFid() {
        return fid;
    }

    public String getUser() {
        return user;
    }

    public String getIcerig() {
        return icerig;
    }
}