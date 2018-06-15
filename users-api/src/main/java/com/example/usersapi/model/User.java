//package com.example.usersapi.user;
//
////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.*;
//import io.leangen.graphql.annotations.GraphQLQuery;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Entity;
//
//@Entity
//@Getter @Setter
//@NoArgsConstructor
//@ToString @EqualsAndHashCode
//public class User {
//
//    @Id
//    @GeneratedValue
//    @GraphQLQuery(name = "id", description = "A user's id")
//    private Long id;
//
////    @OneToMany(mappedBy = "posterId", cascade=CascadeType.ALL)
////    @JsonIgnoreProperties("posterId")
////    private Set<Post> posts = new HashSet<> ();
////
////    @OneToMany(mappedBy = "friendSentRequest", cascade=CascadeType.ALL)
////    @JsonIgnoreProperties("friendSentRequest")
////    private Set<Friend> sentRequest = new HashSet<> ();
////
////    @OneToMany(mappedBy = "friendReceivedRequest", cascade=CascadeType.ALL)
////    @JsonIgnoreProperties("friendReceivedRequest")
////    private Set<Friend> receivedRequest = new HashSet<> ();
//
//    @GraphQLQuery(name = "username", description = "A user's username")
//    private String username;
//
//    @GraphQLQuery(name = "firstName", description = "A user's first name")
//    private String firstName;
//
//    @GraphQLQuery(name = "lastName", description = "A user's last name")
//    private String lastName;
//
//    @GraphQLQuery(name = "email", description = "A user's email")
//    private String email;
//
//    @GraphQLQuery(name = "location", description = "A user's location")
//    private String location;
//
//    @GraphQLQuery(name = "aboutMe", description = "A user's about me")
//    private String aboutMe;
//
//    @GraphQLQuery(name = "password", description = "A user's password")
//    private String password;
//}
//
//
package com.example.usersapi.model;

//import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String aboutMe;
    private String password;

//    public User(String username, String firstName, String lastName, String email, String aboutMe, String password) {
//        this.username = username;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.aboutMe = aboutMe;
//        this.password = password;
//    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

//    public String getLocation() {
//        return this.location;
//    }

    public String getAboutMe() {
        return this.aboutMe;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

//    @Id
//    @GeneratedValue
//    @GraphQLQuery(name = "id", description = "A user's id")
//    private Long id;

//    @OneToMany(mappedBy = "posterId", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("posterId")
//    private Set<Post> posts = new HashSet<> ();
//
//    @OneToMany(mappedBy = "friendSentRequest", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("friendSentRequest")
//    private Set<Friend> sentRequest = new HashSet<> ();
//
//    @OneToMany(mappedBy = "friendReceivedRequest", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("friendReceivedRequest")
//    private Set<Friend> receivedRequest = new HashSet<> ();

//    @GraphQLQuery(name = "username", description = "A user's username")
//    private String username;
//
//    @GraphQLQuery(name = "firstName", description = "A user's first name")
//    private String firstName;
//
//    @GraphQLQuery(name = "lastName", description = "A user's last name")
//    private String lastName;
//
//    @GraphQLQuery(name = "email", description = "A user's email")
//    private String email;
//
//    @GraphQLQuery(name = "location", description = "A user's location")
//    private String location;
//
//    @GraphQLQuery(name = "aboutMe", description = "A user's about me")
//    private String aboutMe;
//
//    @GraphQLQuery(name = "password", description = "A user's password")
//    private String password;
//}