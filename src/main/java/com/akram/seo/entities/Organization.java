package com.akram.seo.entities;





import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "organizations")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(name = "industry_type", nullable = false, length = 100)
    private String industryType;

    @Column(name = "contact_email", nullable = false, length = 150)
    private String contactEmail;

    @Column(name = "contact_phone", nullable = false, length = 20)
    private String contactPhone;

    @Column(name = "subscription_plan", nullable = false, length = 50)
    private String subscriptionPlan;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(name = "energy_cost_per_kwh", nullable = false)
    private double energyCostPerKwh;

    @CreationTimestamp
    @Column(name="created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Instant updatedAt;


    public UUID getId(){return id;}
    public void setId(UUID id){this.id = id;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getIndustryType() { return industryType; }
    public void setIndustryType(String industryType) { this.industryType = industryType; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public String getSubscriptionPlan() { return subscriptionPlan; }
    public void setSubscriptionPlan(String subscriptionPlan) { this.subscriptionPlan = subscriptionPlan; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getEnergyCostPerKwh() { return energyCostPerKwh; }
    public void setEnergyCostPerKwh(double energyCostPerKwh) { this.energyCostPerKwh = energyCostPerKwh; }


}



