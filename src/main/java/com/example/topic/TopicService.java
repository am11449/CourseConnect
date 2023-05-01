package com.example.topic;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
                new Topic("A", "B", "C"),
                new Topic("D", "E", "F"),
                new Topic("G", "H", "I")
        ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id){
        for(int i = 0; i < topics.size(); ++i){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        for(int i = 0; i < topics.size(); ++i){
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.remove(i);
                return;
            }
        }
    }
}
