package com.nabang97.bookrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 9:45
 */

@Data
@Entity @NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
    @Id
    private String username;
    private String password;
    private Boolean enabled;
    @ManyToMany(fetch = FetchType.EAGER )
    private Collection<Role> roles = new ArrayList<>();
    private String groupUser;
    @Temporal(TemporalType.DATE)
    private Date lastLogin;
}
