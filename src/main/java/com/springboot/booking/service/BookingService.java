package com.springboot.booking.service;

import com.springboot.booking.bean.Booking;
import com.springboot.booking.dao.BookingDao;
import com.springboot.booking.daoimpl.BookingRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingDao dao;

    @Autowired
    private BookingRepoImpl bookingRepo;

    public List<Booking> getBookings() {
        return bookingRepo.getBookings();
//        return dao.getBookings();
    }

    public void addBooking(Booking booking) {
        bookingRepo.addBookings(booking);
//        dao.addBookings(booking);
    }

    public Booking getById(int bookingId) {
        return bookingRepo.getById(bookingId);
//        return dao.getById(bookingId);
    }

    public void delete(@PathVariable int bookingId) {
        bookingRepo.delete(bookingId);
//        dao.delete(bookingId);
    }

    public void update(int bookingId, Booking booking) {
        bookingRepo.update(bookingId, booking);
//        dao.update(bookingId, booking);
    }
}
