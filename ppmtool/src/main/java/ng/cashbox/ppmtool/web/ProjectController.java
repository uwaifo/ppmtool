package ng.cashbox.ppmtool.web;


import ng.cashbox.ppmtool.domain.Project;
import ng.cashbox.ppmtool.service.MapValidationErrorService;
import ng.cashbox.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project projectArg, BindingResult result) {

        //
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        Project aProject = projectService.saveOrUpdateProject(projectArg);

        return new ResponseEntity<Project>(aProject, HttpStatus.CREATED);

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {

        Project project = projectService.findProjectIdntifier(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);

    }
}
