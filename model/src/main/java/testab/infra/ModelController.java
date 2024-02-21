package testab.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javafx.application.Application;
import testab.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/models")
@Transactional
public class ModelController {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    ModelRepository modelRepository;

    @RequestMapping(value = "/models",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Model reqeust(HttpServletRequest request, HttpServletResponse response, @RequestBody Model model
        ) throws Exception {
            System.out.println("##### /target/approve  called ##### target : " + model.getUserId() );
            logger.info("##### /target/approve  called ##### target : {} " , model);
            model.setState("requested");
            // modelRepository.save(model);
            return modelRepository.save(model);
    }

    @RequestMapping(value = "/models",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8")
    public Model approve(HttpServletRequest request, HttpServletResponse response, @RequestBody Approved approved
        ) throws Exception {
            System.out.println("##### /target/approve  called ##### target approve :  " + approved.getState()  );
            Optional<Model> optionalModel = modelRepository.findById(approved.getId());
            optionalModel.get().setState("approved");
            modelRepository.save(optionalModel.get());
            return optionalModel.get();
    }

    @RequestMapping(value = "/models/{id}",
            method = RequestMethod.PATCH,
            produces = "application/json;charset=UTF-8")
    public Model reject(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id
        ) throws Exception {
            System.out.println("##### /target/approve  called ##### target reject: " + id);
            Optional<Model> optionalModel = modelRepository.findById(id);
            optionalModel.get().setState("rejected");
            modelRepository.save(optionalModel.get());
            return optionalModel.get();
    }

    // 모델 취소 API 작성
    @RequestMapping(value = "/models/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public Model cancel(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) throws Exception {
        System.out.println("##### /target/cancel  called ##### target cancel: " + id);
        Optional<Model> optionalModel = modelRepository.findById(id);
        optionalModel.get().setState("cancelled");
        modelRepository.save(optionalModel.get());
        return optionalModel.get();
    }
}
//>>> Clean Arch / Inbound Adaptor
