package com.springboot.booking.dao;

import com.springboot.booking.bean.Booking;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BookingDao {

    List<Booking> getBookings();

    void addBookings(Booking booking);

    Booking getById(int bookingId);

    void delete(@PathVariable int bookingId);

    void update(int bookingId, Booking booking);
}
