package com.springboot.booking.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @Column
    @NotNull
    private String bookingCategory;

    @Column
    @NotNull
    private long price;

    @Column
    @NotNull
    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private String date;

    @Column
    @NotNull
    @Size(min = 2, max = 20)
    private String passengerName;
}
