package testab.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import testab.NoticeApplication;
import testab.domain.Noticed;

@Entity
@Table(name = "Notice_table")
@Data
//<<< DDD / Aggregate Root
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String message;

    @PostPersist
    public void onPostPersist() {
        Noticed noticed = new Noticed(this);
        noticed.publishAfterCommit();
    }

    public static NoticeRepository repository() {
        NoticeRepository noticeRepository = NoticeApplication.applicationContext.getBean(
            NoticeRepository.class
        );
        return noticeRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notice(ModelFailed modelFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(modelFailed.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notice(ModelCompleted modelCompleted) {

        //implement business logic here:

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(modelCompleted.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notice(TargetCompleted targetCompleted) {
       
        //implement business logic here:

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(targetCompleted.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notice(StateChanged stateChanged) {
        //implement business logic here:

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(stateChanged.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
