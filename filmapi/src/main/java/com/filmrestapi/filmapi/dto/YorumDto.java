package com.filmrestapi.filmapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class YorumDto implements Serializable {

    private int fid;
    private String user;
    private String icerig;

    public int getFid() {
        return fid;
    }

    public String getUser() {
        return user;
    }

    public String getIcerig() {
        return icerig;
    }

    public YorumDto(int fid, String user, String icerig) {
        this.fid = fid;
        this.user = user;
        this.icerig = icerig;
    }

    public YorumDto() {
    }
}





