package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fname;

    private String lname;

    @Column(unique = true, length = 512)
    private String email;

    @Column(length = 16)
    private String gender;

    @Column(length = 16)
    private String mobile;

    @Column(unique = true, length = 16)
    private String nic;

    @Column(name = "dob", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "registered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @Column(length = 1)
    private int status;

    private String password;

}
