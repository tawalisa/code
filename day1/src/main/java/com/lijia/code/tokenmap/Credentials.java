package com.lijia.code.tokenmap;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class Credentials {
    OffsetDateTime created = OffsetDateTime.now().plus(3, ChronoUnit.SECONDS);
    String accessToken;

    public Credentials(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isExpried() {
        return created.isBefore(OffsetDateTime.now());
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "created=" + created +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
