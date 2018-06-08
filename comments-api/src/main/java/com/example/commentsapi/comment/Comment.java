package com.example.users.comment;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMMENTER_ID")
    private int commenterId;

    @Column(name = "POST_ID")
    private int postId;

    @Column(name = "COMMENTER_USERNAME")
    private String commenterUserName;

    @Column(name = "COMMENT_TEXT")
    private String commentText;

    @Column(name = "NUMBER_OF_COMMENTS")
    private int numberOfComments;

    @Column(name = "NUMBER_OF_LIKES")
    private int numberOfLikes;
}