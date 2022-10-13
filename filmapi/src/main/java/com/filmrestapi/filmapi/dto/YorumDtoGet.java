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
public class YorumDtoGet implements Serializable {
    private String user;
    private String icerig;

    public YorumDtoGet(String user, String icerig) {
        this.user = user;
        this.icerig = icerig;
    }

    public YorumDtoGet() {
    }

    public String getUser() {
        return user;
    }

    public String getIcerig() {
        return icerig;
    }
}