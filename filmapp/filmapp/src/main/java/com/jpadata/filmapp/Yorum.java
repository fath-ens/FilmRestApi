package com.jpadata.filmapp;

import javax.persistence.*;

import javax.persistence.Entity;

@Entity
public class Yorum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "y_id", nullable = false)
    private Integer y_id;

    @Column(name = "fid")
    private Integer fid;

    @Column(name = "y_shb")
    private String y_shb;

    @Column(name = "y_msg")
    private String y_msg;

    public Yorum(Integer fid, String y_shb, String y_msg) {
        this.fid = fid;
        this.y_shb = y_shb;
        this.y_msg = y_msg;
    }

    public Yorum(){

    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getY_shb() {
        return y_shb;
    }

    public void setY_shb(String y_shb) {
        this.y_shb = y_shb;
    }

    public String getY_msg() {
        return y_msg;
    }

    public void setY_msg(String y_msg) {
        this.y_msg = y_msg;
    }

    @Override
    public String toString() {
        return "Yorum{" +
                ", f_id=" + fid +
                ", y_shb='" + y_shb + '\'' +
                ", y_msg='" + y_msg + '\'' +
                '}';
    }
}
