package com.example.users.friend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FRIENDS")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FRIEND_SENT_REQUEST")
    private int friendSentRequest;

    @Column(name = "FRIEND_RECEIVED_REQUEST")
    private int friendReceivedRequest;

    @Column(name = "SENT_REQUEST_USERNAME")
    private String sentRequestUsername;

    @Column(name = "RECEIVED_REQUEST_USERNAME")
    private String receivedRequestUsername;

    @Column(name = "STATUS")
    private int status;
}

//    private String sentUri;
//    private String receivedUri;
//
//    public Friend(final ApplicationUser friendSentRequest, final String sentUri, final int status,
//                  final String sentRequestUsername) {
//        this.friendSentRequest = friendSentRequest;
//        this.sentUri = sentUri;
//        this.status = status;
//        this.sentRequestUsername = sentRequestUsername;
//    }
//
//    public Friend(final ApplicationUser friendRecievedRequest, final String receivedUri, final int status,
//                  final String receivedRequestUsername, final String indicatesReceived) {
//        this.friendReceivedRequest = friendRecievedRequest;
//        this.receivedUri = receivedUri;
//        this.status = status;
//        this.receivedRequestUsername = receivedRequestUsername;
//    }
//
//    public Friend(final ApplicationUser sentFriend, final String sentUri, final int status) {
//        this.friendSentRequest = sentFriend;
//        this.sentUri = sentUri;
//        this.status = status;
//    }
//
//    public Friend(final ApplicationUser receievedFriend, final String receivedUri, final int status, final String indicatesReceived) {
//        this.friendReceivedRequest = receievedFriend;
//        this.receivedUri = receivedUri;
//        this.status = status;
//    }
//
//    public static Friend from(ApplicationUser friendSentRequestUser, Friend sentFriend) {
//        return new Friend(friendSentRequestUser, sentFriend.sentUri, sentFriend.getStatus ());
//    }