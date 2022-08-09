package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fname;

    private String lname;

    @Column(unique = true, length = 512)
    private String email;

    @Column(length = 16)
    private String gender;

    @Column(unique = true, length = 16)
    private String nic;

    @Column(name = "registered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @Column(length = 1)
    private int status;

    @Column(name = "user_role_id")
    private int userRoleId;

    @Column(name = "city_id")
    private int cityId;

}
