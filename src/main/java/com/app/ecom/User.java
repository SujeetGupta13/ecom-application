package com.app.ecom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
