package testab.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import testab.domain.*;
import testab.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Noticed extends AbstractEvent {

    private Long id;
    private String userId;
    private String message;

    public Noticed(Notice aggregate) {
        super(aggregate);
    }

    public Noticed() {
        super();
    }
}
//>>> DDD / Domain Event
