package mailbox;

import mailbox.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSent_전송알람(@Payload Sent sent){

        if(sent.isMe()){
            System.out.println("##### listener 전송알람 : " + sent.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSaved_수신알람(@Payload Saved saved){

        if(saved.isMe()){
            System.out.println("##### listener 수신알람 : " + saved.toJson());
        }
    }

}
