package com.example.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
                new Topic("A", "B", "C"),
                new Topic("D", "E", "F"),
                new Topic("G", "H", "I")
        ));

    public List<Topic> getAllTopics(){

//        return topics;
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopic(String id){
//        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic){

        topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic, String id){
//        for(int i = 0; i < topics.size(); ++i){
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
        Topic existingTopic = topicRepository.findById(id).orElseThrow(RuntimeException::new);
        existingTopic.setName(topic.getName());
        existingTopic.setDescription(topic.getDescription());
        existingTopic = topicRepository.save(topic);

        return existingTopic;

    }

    public void deleteTopic(String id){
//        for(int i = 0; i < topics.size(); ++i){
//            Topic t = topics.get(i);
//            if (t.getId().equals(id))
//                topics.remove(i);
//            return;
//        }
        topicRepository.deleteById(id);
    }
}
