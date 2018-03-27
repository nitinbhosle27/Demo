package com.springboot.booking.controller;

import com.springboot.booking.bean.Booking;
import com.springboot.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Booking> getBookings() {
        return bookingService.getBookings();

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addBooking(@RequestBody @Validated Booking booking) {

        bookingService.addBooking(booking);
    }

    @RequestMapping(value = "/{bookingId}", method = RequestMethod.GET)
    public Booking getById(@PathVariable int bookingId) {
        return bookingService.getById(bookingId);
    }

    @RequestMapping(value = "/{bookingId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int bookingId) {
        bookingService.delete(bookingId);
    }

    @RequestMapping(value = "/{bookingId}", method = RequestMethod.PUT)
    public void update(@PathVariable int bookingId, @Validated @RequestBody Booking booking) {
        bookingService.update(bookingId, booking);
    }

}
