package ng.cashbox.ppmtool.service;


import ng.cashbox.ppmtool.domain.Project;
import ng.cashbox.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        //more logic t come

        return projectRepository.save(project);
    }
}
