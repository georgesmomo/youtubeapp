package com.georgesmomo.youtubeapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "videos")
public class Video {
    @Id
    private String videoId;
    private String channelId;
    private String channelName;
    private String userHashtag;
    private String title;
    private String description;
    private int nbView;
    private int nbLike;
    private int nbComment;
    private String publishDate;
}
