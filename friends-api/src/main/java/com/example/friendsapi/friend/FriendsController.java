package com.example.users.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FriendsController {

    @Autowired
    private FriendRepository friendRepository;

    @GetMapping("/api/friends")
    public Iterable<Friend> findAllFriends () {
        return friendRepository.findAll ();
    }

    @GetMapping("/api/friends/{friendId}")
    public Optional<Friend> findFriendById(@PathVariable Long friendId) {
        return friendRepository.findById(friendId);
    }

    @DeleteMapping("/api/friends/{friendId}")
    public HttpStatus deleteFriendById(@PathVariable Long friendId) {
        friendRepository.deleteById(friendId);
        return HttpStatus.OK;
    }

    @PostMapping("/api/friends")
    public Friend createNewFriend(@RequestBody Friend newFriend) {
        return friendRepository.save(newFriend);
    }

    @PutMapping("/api/friends/{friendId}")
    public Friend updateFriendById(@PathVariable Long friendId, @RequestBody Friend friendRequest) {
        Friend friendFromDb = friendRepository.findById(friendId).get();

        friendFromDb.setStatus(friendRequest.getStatus());

        return friendRepository.save(friendFromDb);
    }

    @GetMapping("/api/friends/status/{status}")
    public Iterable<Friend> findByStatus(@PathVariable int status) { return friendRepository.findByStatus(status); }

    /*
    //  These two methods query the database for either
    //  sent friend requests or received friend requests
    //  to assist in displaying the results on the front
    //  end. Aka having both 'sentFriendRequests' and
    //  'receivedFriendRequests' in state to properly update
    //  the view.
     */
    @GetMapping("/api/friends/sent/{friendSentRequest}")
    public Iterable<Friend> findByFriendSentRequest(@PathVariable int friendSentRequest) { return friendRepository.findByFriendSentRequest(friendSentRequest); }

    @GetMapping("/api/friends/received/{friendReceivedRequest}")
    public Iterable<Friend> findByFriendReceivedRequest(@PathVariable int friendReceivedRequest) { return friendRepository.findByFriendReceivedRequest(friendReceivedRequest); }

    @GetMapping("/api/friends/sent/{sentRequestUsername}")
    public Iterable<Friend> findBySentRequestUsername(@PathVariable String sentRequestUsername) { return friendRepository.findBySentRequestUsername(sentRequestUsername); }

    @GetMapping("/api/friends/received/{receivedRequestUsername}")
    public Iterable<Friend> findByReceivedRequestUsername(@PathVariable String receivedRequestUsername) { return friendRepository.findByReceivedRequestUsername(receivedRequestUsername); }
}