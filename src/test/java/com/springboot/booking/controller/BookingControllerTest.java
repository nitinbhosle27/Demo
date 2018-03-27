package com.springboot.booking.controller;

import com.google.gson.Gson;
import com.springboot.booking.bean.Booking;
import com.springboot.booking.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = BookingController.class, secure = false)
@Slf4j
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Test
    public void testBookingSuccess() {

        try {
            //given
            Booking booking = new Booking(1, "sleeper", 5000L, "27/01/2018", "Nitin");

//            String booking = "{\n" +
//                    "\t\"bookingCategory\" : \"luxury\",\n" +
//                    "\t\"price\" : 3000,\n" +
//                    "\t\"date\" : \"25/01/2018\",\n" +
//                    "\t\"passengerName\" : \"Nitin\"\n" +
//                    "\t\n" +
//                    "}";
            //then
            this.mockMvc.perform(post("/booking/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(booking)))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            log.info("Exception occured in testBookingSuccess", e);
        }
    }

    @Test
    public void testGetBooking() {
        //given
//        String booking = "{\n" +
//                "\t\"bookingCategory\" : \"luxury\",\n" +
//                "\t\"price\" : 3000,\n" +
//                "\t\"date\" : \"25/01/2018\",\n" +
//                "\t\"passengerName\" : \"Nitin\"\n" +
//                "\t\n" +
//                "}";
        Booking booking = new Booking(1, "sleeper", 5000L, "27/01/2018", "Nitin");
        try {
            when(bookingService.getById(1)).thenReturn(booking);
            this.mockMvc.perform(get("/booking/1")).andExpect(content().json(new Gson().toJson(booking)));
        } catch (Exception e) {
            log.info("Exception occured in testGetBooking", e);
        }
    }

    @Test
    public void testDeleteById() {
        try {
            this.mockMvc.perform(delete("/booking/1")).andExpect(status().isOk());
        } catch (Exception e) {
            log.info("Exception occured in testDeleteById");
        }
    }

    @Test
    public void testUpdate() {
        try {
            Booking booking = new Booking(1, "sleeper", 5000L, "27/01/2018", "Nitin");
            this.mockMvc.perform(put("/booking/1").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(booking))).andExpect(status().isOk());
        } catch (Exception e) {
            log.info("Exception occured in testUpdate");
        }
    }

}