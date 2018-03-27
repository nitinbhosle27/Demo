package com.springboot.booking.daoimpl;

import com.springboot.booking.bean.Booking;
import com.springboot.booking.dao.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class BookingRepoImpl {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookings() {
        return bookingRepository.findBy();
    }

    public ResponseEntity<Booking> addBookings(Booking booking) {
        Booking booking1 = bookingRepository.saveAndFlush(booking);
        return ResponseEntity.ok(booking1);

    }

    public Booking getById(int bookingId) {
        return bookingRepository.findOne(bookingId);
    }

    public ResponseEntity<Booking> delete(@PathVariable int bookingId) {
        Booking booking = bookingRepository.findOne(bookingId);
        bookingRepository.delete(booking);
        return ResponseEntity.ok(booking);
    }

    public ResponseEntity<Booking> update(int bookingId, Booking booking) {
        Booking booking1 = bookingRepository.findOne(bookingId);
        bookingRepository.saveAndFlush(booking1);
        return ResponseEntity.ok(booking1);
    }
}
