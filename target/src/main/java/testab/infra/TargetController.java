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

    @RequestMapping(value = "/targets",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Target reqeust(HttpServletRequest request, HttpServletResponse response, @RequestBody Target target
        ) throws Exception {
            System.out.println("##### /target/approve  called ##### target : " + target.getUserId() );
            targetRepository.save(target);
            return target;
    }

    @RequestMapping(value = "/targets",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8")
    public void approve(HttpServletRequest request, HttpServletResponse response, @RequestBody Approved approved
        ) throws Exception {
            System.out.println("##### /target/approve  called ##### target approve :  " + approved.getState()  );
            // targetRepository.save(approved);
            // return targetRepository.findById(approved.getId());;
    }

    @RequestMapping(value = "/targets/{id}",
            method = RequestMethod.PATCH,
            produces = "application/json;charset=UTF-8")
    public void reject(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id
        ) throws Exception {
            System.out.println("##### /target/approve  called ##### target reject: " + id);
            // targetRepository.save(target);
            // return targetRepository.findById(id);
    }

}
//>>> Clean Arch / Inbound Adaptor
