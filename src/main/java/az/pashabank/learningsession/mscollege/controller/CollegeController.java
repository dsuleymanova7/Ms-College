package az.pashabank.learningsession.mscollege.controller;

import az.pashabank.learningsession.mscollege.entity.College;
import az.pashabank.learningsession.mscollege.service.CollegeService;
import az.pashabank.learningsession.mscollege.util.Response;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CollegeController.class);

    @GetMapping("all")
    public List<College> getColleges(HttpServletRequest request) {
        LOGGER.info("'getColleges'- requested from " + request.getRemoteAddr() + " ip address");
        return collegeService.getAllCollages();
    }

    @GetMapping("getById/{id}")
    public College getCollege(@PathVariable("id") Integer id, HttpServletRequest request) {
        LOGGER.info("'getCollege' requested from " + request.getRemoteAddr() + " ip address");
        return collegeService.getCollegeById(id);

    }

    @PostMapping("add")
    public Response addCollege(@RequestBody College college, HttpServletRequest request) {
        LOGGER.info("'addCollege' requested from " + request.getRemoteAddr() + " ip address");

        try {

            if (!collegeService.addCollege(college)) {
                throw new Exception();
            }
        } catch (Exception e) {
            return Response.getErrorResponse();

        }

        return Response.getSuccessResponse();
    }

    @PutMapping("update")
    public Response update(@RequestBody College college, HttpServletRequest request) {
        LOGGER.info("'update' requested from " + request.getRemoteAddr() + " ip address");

        try {
            if (!collegeService.update(college)) {

                throw new Exception();
            }
        } catch (Exception e) {
            return Response.getErrorResponse();
        }
        return Response.getSuccessResponse();
    }

    @DeleteMapping("delete/{id}")
    public Response delete(@PathVariable("id") Integer id, HttpServletRequest request) {
        LOGGER.info("'delete' requested from " + request.getRemoteAddr() + " ip address");

        try {
            if (!collegeService.delete(id)) {
                throw new Exception();
            }
        } catch (Exception e) {
            return Response.getErrorResponse();
        }
        return Response.getSuccessResponse();
    }

}
