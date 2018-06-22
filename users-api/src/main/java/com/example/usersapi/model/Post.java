package com.example.usersapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="POSTER")
    private User poster;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "POST_TEXT")
    private String postText;

    @Column(name = "NUMBER_OF_LIKES")
    private int numberOfLikes;

    @Column(name = "NUMBER_OF_COMMENTS")
    private int numberOfComments;

    @Column(name = "ABLE_TO_VIEW")
    private int ableToView;
}