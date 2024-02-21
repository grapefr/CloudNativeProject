package testab.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import testab.config.kafka.KafkaProcessor;
import testab.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NoticeRepository noticeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ModelFailed'"
    )
    public void wheneverModelFailed_Notice(@Payload ModelFailed modelFailed) {
        ModelFailed event = modelFailed;
        System.out.println(
            "\n\n##### listener Notice : " + modelFailed + "\n\n"
        );

        // Sample Logic //
        Notice.notice(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ModelCompleted'"
    )
    public void wheneverModelCompleted_Notice(
        @Payload ModelCompleted modelCompleted
    ) {
        ModelCompleted event = modelCompleted;
        System.out.println(
            "\n\n##### listener Notice : " + modelCompleted + "\n\n"
        );

        // Sample Logic //
        Notice.notice(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TargetCompleted'"
    )
    public void wheneverTargetCompleted_Notice(
        @Payload TargetCompleted targetCompleted
    ) {
        TargetCompleted event = targetCompleted;
        System.out.println(
            "\n\n##### listener Notice : " + targetCompleted + "\n\n"
        );

        // Sample Logic //
        Notice.notice(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StateChanged'"
    )
    public void wheneverStateChanged_Notice(
        @Payload StateChanged stateChanged
    ) {
        StateChanged event = stateChanged;
        System.out.println(
            "\n\n##### listener Notice : " + stateChanged + "\n\n"
        );

        // Sample Logic //
        Notice.notice(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
