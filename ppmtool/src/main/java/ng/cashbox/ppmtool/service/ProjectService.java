package ng.cashbox.ppmtool.service;


import ng.cashbox.ppmtool.domain.Project;
import ng.cashbox.ppmtool.exception.ProjectIdException;
import ng.cashbox.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        //more logic to come
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("A Project with Identifier " +project.getProjectIdentifier() + " is already taken !");
        }

        //return projectRepository.save(project);
    }

    public Project findProjectIdntifier(String projectId) {
        Project project= projectRepository.findByProjectIdentifier(projectId.toUpperCase());


        if(project == null) {
            throw new ProjectIdException("A Project with the ID : " + projectId + " was not found ");
        }
        return project;
    }
}
