package com.poorjar.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poorjar.sqlite.hibernate.entities.Track;
import com.poorjar.sqlite.hibernate.utils.HibernateUtil;

/**
 * @author Swaroop
 */
@RestController
@EnableAutoConfiguration
public final class TrackController
{
    @RequestMapping("/track")
    public String handleRequest()
    {
        queryDB();
        return "Hello Spring Boot!";
    }

    private void queryDB()
    {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            // Print data
            @SuppressWarnings("unchecked")
            List<Track> trackList = session.createQuery("from Track").list();

            for (Track track : trackList)
            {
                System.out.println(track.toString());
            }

        }
        catch (Exception e)
        {
            System.out.println("ERRRRRROOORRRR!");
            System.out.println(e.getMessage());
            if (tx != null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }
}