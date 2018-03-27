package com.springboot.booking.dao;

import com.springboot.booking.bean.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Booking findByBookingId(int bookingId);

    List<Booking> findBy();
}
