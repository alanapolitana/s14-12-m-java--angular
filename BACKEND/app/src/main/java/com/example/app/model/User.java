package com.example.app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name", unique = true)
    private String userName;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
    private String hash;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Role role;

    /* One User has many Addresses (A user row can be referenced by multiple address rows)
     * The "user_id" column in the "address" table column maps this relationship via a foreign key that references the primary key of the "users" table.
     * An Address cannot exist without a User, so the CascadeType.ALL and orphanRemoval = true options are set to ensure
     * that the Address entity is deleted when the User entity is deleted.
     * The `User` entity is the parent side of the relationship, so it is the owning side of the relationship.
     * While the `Address` entity is the child side of the relationship, so it is the inverse side of the relationship.

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    */

    /* One User has many Orders (A user row can be referenced by multiple order rows)
     * The "user_id" column in the "order" table column maps this relationship via a foreign key that references the primary key of the "users" table.
     * An Order cannot exist without a User, so the CascadeType.ALL and orphanRemoval = true options are set to ensure
     * that the Order entity is deleted when the User entity is deleted.
     * The `User` entity is the parent side of the relationship, so it is the owning side of the relationship.
     * While the `Order` entity is the child side of the relationship, so it is the inverse side of the relationship.

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
    */
}
