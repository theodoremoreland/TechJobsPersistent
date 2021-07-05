package org.launchcode.TechJobsPersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 1000)
    private String description;

    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}