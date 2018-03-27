package com.springboot.booking.service;


import com.springboot.BookingApplication;
import com.springboot.booking.bean.Booking;
import com.springboot.booking.dao.BookingDao;
import com.springboot.booking.dao.BookingRepository;
import com.springboot.booking.daoimpl.BookingRepoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BookingApplication.class)
public class BookingServiceTest {

    @InjectMocks
    BookingRepoImpl bookingRepo;

    @Mock
    private BookingRepository bookingRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }
    @Test
    public void test(){
            Booking booking = new Booking(1, "sleeper", 5000L, "27/01/2018", "Nitin");
            Mockito.when(bookingRepository.findOne(1)).thenReturn(booking);

        Booking booking1= bookingRepo.getById(1);
        System.out.println(bookingRepo.getById(1) + "  "+ booking1);
        Assert.assertNotNull(booking1);

    }
}

