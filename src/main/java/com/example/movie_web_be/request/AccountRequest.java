package com.example.movie_web_be.request;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccountRequest {

    private String password;

    private String email;

    private String name;

    private Boolean gender;

    private Date createDate;

    private Date updateDate;

    private Date birthDay;

    private String phoneNumber;

    private String avatar;

    private Boolean isActive;

    private Integer rankCustomerId;

    private Integer roleId;
}
