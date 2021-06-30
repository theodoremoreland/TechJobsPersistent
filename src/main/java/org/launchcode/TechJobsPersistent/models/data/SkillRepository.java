package org.launchcode.TechJobsPersistent.models.data;

import org.launchcode.TechJobsPersistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
