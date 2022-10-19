package com.filmrestapi.filmapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {
    @NotNull
    private int fid;

    @NotEmpty
    @Size(max = 500, message = " User name should have at max 500 characters")
    private String user;

    @NotEmpty
    @Size(max = 1500, message = " Comment should have at max 500 characters")
    private String msg;

}





