package com.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getAllTopics(){

        return ResponseEntity.ok().body(topicService.getAllTopics());
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable String id){

        Optional<Topic> topicOptional = topicService.getTopic((id));
        if (topicOptional.isPresent()){
            return ResponseEntity.ok().body(topicOptional.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }


    }

    @PostMapping(value = "/topics")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic){

        topicService.addTopic(topic);
        return ResponseEntity.ok(topic);
    }

    @PutMapping(value = "/topics/{id}")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic, @PathVariable String id){

        topic = topicService.updateTopic(topic, id);

        return ResponseEntity.ok(topic);

    }

    @DeleteMapping(value = "/topics/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable String id){

        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();

    }
}
