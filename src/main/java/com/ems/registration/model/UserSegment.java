package com.ems.registration.model;

import java.util.UUID;

public class UserSegment {
    public String userSegmentId;
    public String applicationName;
    public String apiKey;
    public String userId;

    public UserSegment(String userId) {
        this.userSegmentId = "us-" + UUID.randomUUID().toString();
        this.applicationName = "ALL";
        this.apiKey = UUID.randomUUID().toString();
        this.userId = userId;
    }


}
