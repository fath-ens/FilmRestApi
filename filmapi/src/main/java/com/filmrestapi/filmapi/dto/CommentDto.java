package com.filmrestapi.filmapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {

    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private Integer id;

    @NotNull
    private int fid;

    @NotEmpty
    @Size(max = 500)
    private String user;

    @NotEmpty
    @Size(max = 1500)
    private String msg;

}





