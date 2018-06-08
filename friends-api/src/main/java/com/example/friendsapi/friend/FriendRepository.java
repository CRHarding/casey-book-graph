package com.example.users.friend;
import java.util.List;
import java.util.Optional;

import com.example.users.friend.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findByStatus(int status);
    List<Friend> findByFriendSentRequest(int sentRequestFriend);
    List<Friend> findByFriendReceivedRequest(int receivedRequestFriend);
    List<Friend> findBySentRequestUsername(String sentRequestUsername);
    List<Friend> findByReceivedRequestUsername(String receivedRequestUsername);
    Optional<Friend> findById(long friendId);
    HttpStatus deleteById(long friendId);
}