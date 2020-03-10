package ng.cashbox.ppmtool.repository;


import ng.cashbox.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    Iterable<Project> findAll();
//@Override
    //Iterable<Project> findAllById(Iterable<Long> iterable);

}
