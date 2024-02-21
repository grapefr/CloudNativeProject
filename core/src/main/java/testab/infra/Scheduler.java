package testab.infra;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import testab.domain.Core;
import testab.domain.CoreRepository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Scheduler {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);
  private final CoreRepository coreRepository;

  @Autowired
  public Scheduler(CoreRepository coreRepository) {
    this.coreRepository = coreRepository;
  }

  // 5초마다 실행
  @Scheduled(fixedRate = 5000)
  public void performTask() {
    System.out.println("############ scheduler Regular task performed at " + System.currentTimeMillis());


    // Use the injected CoreRepository instance
    // ...

    // running 중인것을 확인하여 completed로 변경
    List<Core> optionalCore = coreRepository.findByState("running");
    if (optionalCore.size() > 0) {
      System.out.println("############ OK GO :  " + System.currentTimeMillis());
      for( int i = 0; i < optionalCore.size(); i++ ){
        Core core = optionalCore.get(i);
        logger.debug("################## scheduler core 확인 : {} ", core);

        try {
          Thread.sleep(1000); // 1초 대기
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if( core.getType().equals("model") ){
          System.out.println("Model Running");
          core.setState("completed");
        }
        else if( core.getType().equals("target") ) {
          System.out.println("Target Running");
          core.setState("targetCompleted");
        }        
        coreRepository.save(core);
        logger.debug("################## updated {} ", core );
      }
    }

  }
}