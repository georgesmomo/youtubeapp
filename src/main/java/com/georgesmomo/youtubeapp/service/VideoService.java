package com.georgesmomo.youtubeapp.service;

import com.georgesmomo.youtubeapp.model.Video;
import com.georgesmomo.youtubeapp.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

    public List<Video> getVideosBetweenDates(String startDate, String endDate) {
        return videoRepository.findByPublishDateBetween(startDate, endDate);
    }

    public void deleteVideo(String videoId) {
        videoRepository.deleteById(videoId);
    }
}
