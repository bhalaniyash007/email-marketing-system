package com.ems.subscriberList.controller;

import com.ems.DbConnection.MySqlPersistenceConnection;
import com.ems.subscriberList.model.Subscriber;
import com.ems.subscriberList.persistence.ISubscriberPersistence;
import com.ems.subscriberList.persistence.SubscriberDB;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subscriber")
public class SubscriberListController {

    private Subscriber subscriberDetails = new Subscriber();

    @GetMapping("/getsubscribers")
    public List<Subscriber> getSubscribers()
    {
        try
        {
            return subscriberDetails.loadSubscriber(new SubscriberDB(MySqlPersistenceConnection.getInstance().getConnection()));

        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping("/savesubscriber")
    public String createSubscriberList(@RequestBody JsonNode body)
    {
     try
     {
         String Subscriber_email = body.get("sub_email").asText();
         String Subscriber_firstname = body.get("sub_first_name").asText();
         String Subscriber_lastname = body.get("sub_last_name").asText();
         String Subscriber_location = body.get("sub_location").asText();
         String Subscriber_date = body.get("subscription_date").asText();
         String Subsciber_status = body.get("sub_status").asText();

         Subscriber addSubscriber = new Subscriber(Subscriber_email,Subscriber_firstname,Subscriber_lastname,Subscriber_location,Subscriber_date,Subsciber_status);
         int responseCode = addSubscriber.saveSubscriber(new SubscriberDB(MySqlPersistenceConnection.getInstance().getConnection()));
         if(responseCode == -1)
         {
             return "Error in inserting company details";
         }
         else
         {
             return "Success: " + addSubscriber.toString();
         }
     }
     catch(Exception exception)
     {
      return "Exception" + exception.getMessage();
     }
    }

}