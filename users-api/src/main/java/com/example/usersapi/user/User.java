package com.example.usersapi.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "posterId", cascade=CascadeType.ALL)
//    @JsonIgnoreProperties("posterId")
//    private Set<Post> posts = new HashSet<> ();
//
//    @OneToMany(mappedBy = "friendSentRequest", cascade=CascadeType.ALL)
//    @JsonIgnoreProperties("friendSentRequest")
//    private Set<Friend> sentRequest = new HashSet<> ();
//
//    @OneToMany(mappedBy = "friendReceivedRequest", cascade=CascadeType.ALL)
//    @JsonIgnoreProperties("friendReceivedRequest")
//    private Set<Friend> receivedRequest = new HashSet<> ();

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "ABOUT_ME")
    private String aboutMe;

    @Column(name = "PASSWORD")
    private String password;
}