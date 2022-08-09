package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookingStatusHistory implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Column(name = "booking_status_id")
    private int bookingStatusId;

    @Column(name = "booking_id")
    private int bookingId;
}
