package com.springboot.booking.daoimpl;

import com.springboot.booking.bean.Booking;
import com.springboot.booking.dao.BookingDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class BookingDaoImpl implements BookingDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<Booking> getBookings() {
        return sessionFactory.openSession().createCriteria(Booking.class).list();
    }

    @Override
    public void addBookings(Booking booking) {
        final Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(booking);
        transaction.commit();
        session.close();
    }


    @Override
    public Booking getById(int bookingId) {
        final Session session = getSession();
        return session.get(Booking.class, bookingId);
    }

    @Override
    public void delete(@PathVariable int bookingId) {
        final Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Booking booking = session.load(Booking.class, bookingId);
        if (booking != null) {
            session.delete(booking);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void update(int bookingId, Booking booking) {
        final Session session = getSession();
        session.load(Booking.class, bookingId);
        session.getTransaction().begin();
        session.update(booking);
        session.getTransaction().commit();
        session.close();
    }
}
