package com.georgesmomo.youtubeapp.repository;

import com.georgesmomo.youtubeapp.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, String> {
    List<Video> findByPublishDateBetween(String startDate, String endDate);
}
