package org.launchcode.TechJobsPersistent.models.data;

import org.launchcode.TechJobsPersistent.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface JobRepository extends CrudRepository<Job, Integer> {
}
