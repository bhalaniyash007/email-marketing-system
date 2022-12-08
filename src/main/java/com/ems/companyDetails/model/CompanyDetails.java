package com.ems.companyDetails.model;

import com.ems.companyDetails.persistence.ICompanyDetailsPersistence;

public class CompanyDetails {
    public String company_id;
    public String company_name;
    public String website_link;
    public String company_email;
    public String  owner_name;
    public String facebook_link;
    public String instagram_link;
    public String twitter_url;
    public String getCompany_id() {
        return company_id;
    }

    @Override
    public String toString() {
        return "CompanyDetails{" +
                "company_id='" + company_id + '\'' +
                ", company_name='" + company_name + '\'' +
                ", website_link='" + website_link + '\'' +
                ", company_email='" + company_email + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", facebook_link='" + facebook_link + '\'' +
                ", instagram_link='" + instagram_link + '\'' +
                ", twitter_url='" + twitter_url + '\'' +
                '}';
    }

    public CompanyDetails(){

    }
    public CompanyDetails(String company_name, String website_link, String company_email, String owner_name, String facebook_link, String instagram_link, String twitter_url) {
        setCompany_name(company_name);
        setWebsite_link(website_link);
        setCompany_email(company_email);
        setOwner_name(owner_name);
        setFacebook_link(facebook_link);
        setInstagram_link(instagram_link);
        setTwitter_url(twitter_url);
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        if(!company_name.isEmpty()){
            this.company_name = company_name;
        }
    }

    public String getWebsite_link() {
        return website_link;
    }

    public void setWebsite_link(String website_link) {
        if(!website_link.isEmpty()) {
            this.website_link = website_link;
        }
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        if(!company_email.isEmpty()) {
            this.company_email = company_email;
        }
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        if(!owner_name.isEmpty()) {
            this.owner_name = owner_name;
        }
    }

    public String getFacebook_link() {
        return facebook_link;
    }

    public void setFacebook_link(String facebook_link) {
        if(!facebook_link.isEmpty()) {
            this.facebook_link = facebook_link;
        }
    }

    public String getInstagram_link() {
        return instagram_link;
    }

    public void setInstagram_link(String instagram_link) {
        if(!instagram_link.isEmpty()) {
            this.instagram_link = instagram_link;
        }
    }

    public String getTwitter_url() {
        return twitter_url;
    }

    public void setTwitter_url(String twitter_url) {
        if(!twitter_url.isEmpty()) {
            this.twitter_url = twitter_url;
        }
    }

    public CompanyDetails loadCompanyDetails (ICompanyDetailsPersistence persistence) throws java.lang.Exception {
        return persistence.loadcompanyDetails(this);
    }
    public int saveCompanyDetails (ICompanyDetailsPersistence persistence) throws Exception{
        return persistence.saveCompanyDetails(this);
    }
}
