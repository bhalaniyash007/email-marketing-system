package com.ems.bulkEmail.model;

import com.ems.DbConnection.MySqlPersistenceConnection;
import com.ems.bulkEmail.persistence.EmailDetailsDb;
import com.ems.campaign.model.Campaign;
import com.ems.campaign.model.IObserver;
import com.ems.campaign.model.Subject;
import com.ems.subscriberList.model.Subscriber;
import com.ems.subscriberList.model.SubscriberList;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BulkEmail implements IObserver {
    Campaign campaign;
    List<Subscriber> subscribers;

    List<EmailDetails>emailDetailsList;
    SubscriberList subscriberList;
    public BulkEmail(Campaign campaign,SubscriberList subscriberList){
        this.campaign=campaign;
        this.subscriberList=subscriberList;
        emailDetailsList=new ArrayList<>();

    }

    @Override
    public void update(Subject s) {
<<<<<<< HEAD
        emailDetailsList=generateEmailDetailList();
        for(int i=0;i<emailDetailsList.size();i++){
           EmailDetails emailDetail=emailDetailsList.get(i);
           sendEmail(emailDetail);
           emailDetail.sentTime= new Date();
            try {
                emailDetail.saveEmailDetails(new EmailDetailsDb(MySqlPersistenceConnection.getInstance().getConnection()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private List<EmailDetails> generateEmailDetailList(){
        subscribers=subscriberList.getSubscriberByCampaignID(campaign.getCampaignId());
        List<EmailDetails> emailList=new ArrayList<>();
        EmailDetailBuilder emailDetailBuilder= new SimpleEmailDetailBuilder();
        for (Subscriber subscriber:subscribers){
            EmailDetails emailDetails=emailDetailBuilder.buildEmailDetail(subscriber);
            emailDetails.campaignId=campaign.getCampaignId();
            Mail mail=emailDetailBuilder.buildEmail(campaign.getTemplate(),new HtmlFormatter());
            emailDetails.mail=mail;
            emailList.add(emailDetails);
        }
        return emailList;
    }
    private void sendEmail(EmailDetails emailDetail){
        ISendEmail sendEmail= new Gmail("emsprojectasdc@gmail.com","jtuagavmuwwqzkxt",emailDetail);
        sendEmail.sendEmail(emailDetail);
=======
//        subscribers=subscriberList.getSubscriberByCampaignID(campaign.getCampaignId());
>>>>>>> origin/develop
    }
}
