package com.example.ems.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // generates all the constructor,getter,setter using lombok
@Entity //makes employee as jpa entity
@Table(name= "employees") //creates table in mysql
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //setting primary key in table and is auto-incremented
    private Long id;

    @Column(name = "first_name") //name of the column ,if not given then spring gives parameter name to the column
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_id",nullable = false,unique = true) //column cannot be null and should have unique values
    private String email;
}
