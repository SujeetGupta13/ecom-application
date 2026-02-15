package com.app.ecom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor // Mandatory As JPA looks for noArgs constructor while fetching data from DB and mapping.
@Entity(name = "user_table")
//@Entity // With this table name will be user. and in some DB, user is reserved keyword.So, it will give error.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role = UserRole.CUSTOMER;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) //CascadeType.ALL-> all opn done on user table applied on address table as well and if any address record is without user then it shud be removed
    @JoinColumn(name = "address_id", referencedColumnName = "id") // address_id will be foreign key in user table with address's column id.
    private Address address;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
