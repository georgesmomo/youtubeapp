package com.georgesmomo.youtubeapp.controller;

import com.georgesmomo.youtubeapp.model.Video;
import com.georgesmomo.youtubeapp.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @GetMapping("/list")
    public List<Video> listVideos(
            @RequestParam(required = false) String date_debut,
            @RequestParam(required = false) String date_fin
    ) {
        return videoService.getVideosBetweenDates(date_debut, date_fin);
    }

    @DeleteMapping("/delete")
    public String deleteVideo(@RequestParam String video_id) {
        videoService.deleteVideo(video_id);
        return "Vidéo supprimée avec succès.";
    }
}
