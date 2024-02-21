package testab.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import testab.CoreApplication;
import testab.domain.ModelCanceled;
import testab.domain.ModelCompleted;
import testab.domain.ModelFailed;
import testab.domain.TargetCompleted;

@Entity
@Table(name = "Core_table")
@Data
//<<< DDD / Aggregate Root
public class Core {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    private String state;

    private String requestId;

    @PostPersist
    public void onPostPersist() {
        ModelCompleted modelCompleted = new ModelCompleted(this);
        modelCompleted.publishAfterCommit();

        ModelFailed modelFailed = new ModelFailed(this);
        modelFailed.publishAfterCommit();

        TargetCompleted targetCompleted = new TargetCompleted(this);
        targetCompleted.publishAfterCommit();

        ModelCanceled modelCanceled = new ModelCanceled(this);
        modelCanceled.publishAfterCommit();
    }

    public static CoreRepository repository() {
        CoreRepository coreRepository = CoreApplication.applicationContext.getBean(
            CoreRepository.class
        );
        return coreRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startModel(Approved approved) {
        //implement business logic here:

        /** Example 1:  new item 
        Core core = new Core();
        repository().save(core);

        */

        /** Example 2:  finding and process
        
        repository().findById(approved.get???()).ifPresent(core->{
            
            core // do something
            repository().save(core);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void startTarget(Approved approved) {
        //implement business logic here:

        /** Example 1:  new item 
        Core core = new Core();
        repository().save(core);

        */

        /** Example 2:  finding and process
        
        repository().findById(approved.get???()).ifPresent(core->{
            
            core // do something
            repository().save(core);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void requestCanceled(RequestCanceled requestCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Core core = new Core();
        repository().save(core);

        */

        /** Example 2:  finding and process
        
        repository().findById(requestCanceled.get???()).ifPresent(core->{
            
            core // do something
            repository().save(core);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
