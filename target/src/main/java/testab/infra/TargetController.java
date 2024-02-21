package testab.infra;
import testab.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/targets")
@Transactional
public class TargetController {
    @Autowired
    TargetRepository targetRepository;






    @RequestMapping(value = "targets/",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Target approve(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /target/approve  called #####");
            target.approve();
            targetRepository.save(target);
            return target;
    }

}
//>>> Clean Arch / Inbound Adaptor
