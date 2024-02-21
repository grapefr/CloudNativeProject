package testab.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testab.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/models")
@Transactional
public class ModelController {

    @Autowired
    ModelRepository modelRepository;

    @RequestMapping(
        value = "models/{id}/request",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Model request(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /model/request  called #####");
        Optional<Model> optionalModel = modelRepository.findById(id);

        optionalModel.orElseThrow(() -> new Exception("No Entity Found"));
        Model model = optionalModel.get();
        model.request();

        modelRepository.save(model);
        return model;
    }

    @RequestMapping(
        value = "models/{id}/requestcancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Model cancel(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /model/cancel  called #####");
        Optional<Model> optionalModel = modelRepository.findById(id);

        optionalModel.orElseThrow(() -> new Exception("No Entity Found"));
        Model model = optionalModel.get();
        model.cancel();

        modelRepository.save(model);
        return model;
    }
}
//>>> Clean Arch / Inbound Adaptor
