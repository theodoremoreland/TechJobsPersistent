package org.launchcode.TechJobsPersistent.models.data;

import org.launchcode.TechJobsPersistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}
