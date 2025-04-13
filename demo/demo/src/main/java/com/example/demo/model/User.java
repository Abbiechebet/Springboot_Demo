package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private ActiveStatus active = ActiveStatus.YES;

    private double balance;

    public enum ActiveStatus {
        YES,
        NO
    }

    @PrePersist
    protected void onCreate() {
        ZonedDateTime utcPlus3Time = ZonedDateTime.now(ZoneId.of("UTC+3"));
        this.createdAt = Date.from(utcPlus3Time.toInstant());

        // Debugging logs to confirm timezone change
        System.out.println("Timestamp in UTC+3: " + utcPlus3Time);
        System.out.println("Converted to Date: " + this.createdAt);


        // todo displayed timezone
    }
}