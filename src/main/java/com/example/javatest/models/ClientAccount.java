package com.example.javatest.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Entity
@Table(name = "client_account")
@Getter
@Setter
@NoArgsConstructor
public class ClientAccount extends BaseEntity
{
    @Column(length = 1)
    private String gender;

    @Column(length = 20)
    private String status;

    @Column(name = "create_dttm", nullable = false, updatable = false)
    private Instant createDttm;

    @Column(name = "modify_dttm", nullable = false)
    private Instant modifyDttm;

    @PrePersist
    protected void onCreate()
    {
        Instant now = Instant.now();
        this.createDttm = now;
        this.modifyDttm = now;
    }

    @PreUpdate
    protected void onUpdate()
    {
        this.modifyDttm = Instant.now();
    }
}
