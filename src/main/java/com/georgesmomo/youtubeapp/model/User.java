package com.georgesmomo.youtubeapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private String userHashtag;
    private String userName;
    private String userRole;
}
