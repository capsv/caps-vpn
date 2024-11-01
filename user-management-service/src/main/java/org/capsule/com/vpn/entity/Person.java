package org.capsule.com.vpn.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String avatarUrl;

    private String passwordHash;
    private String salt;
    private Boolean is2FAEnabled;
    private String twoFactorSecret;
    private OffsetDateTime lastLogin;

    private String subscriptionPlan;
    private OffsetDateTime subscriptionStart;
    private OffsetDateTime subscriptionEnd;

    private String language;
    private String timezone;
    private Boolean emailNotifications;
    private Boolean pushNotifications;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Device> devices;

    private Boolean isActive;
    private Boolean isDeleted;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;
}
