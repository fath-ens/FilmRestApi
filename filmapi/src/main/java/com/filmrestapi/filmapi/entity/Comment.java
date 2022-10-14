package com.filmrestapi.filmapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name = "fid")
    private Movie fid;
    @Column
    private String user;
    @Column
    private String msg;

    public Comment(Movie fid, String user, String msg) {
        this.fid = fid;
        this.user = user;
        this.msg = msg;
    }

}