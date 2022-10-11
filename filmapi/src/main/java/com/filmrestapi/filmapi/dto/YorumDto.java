package com.filmrestapi.filmapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class YorumDto implements Serializable {
    private int fid;
    private String user;
    private String icerig;

    public YorumDto() {
    }

    public YorumDto(int fid, String user, String icerig) {
        this.fid = fid;
        this.user = user;
        this.icerig = icerig;
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

    @Override
    public String toString() {
        return "YorumDto{" +
                "fid=" + fid +
                ", user='" + user + '\'' +
                ", icerig='" + icerig + '\'' +
                '}';
    }
}