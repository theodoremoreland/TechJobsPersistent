package org.launchcode.TechJobsPersistent.controllers;

import org.launchcode.TechJobsPersistent.models.Employer;
import org.launchcode.TechJobsPersistent.models.Job;
import org.launchcode.TechJobsPersistent.models.Skill;
import org.launchcode.TechJobsPersistent.models.data.EmployerRepository;
import org.launchcode.TechJobsPersistent.models.data.JobRepository;
import org.launchcode.TechJobsPersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "My Jobs");
        model.addAttribute("jobs", jobRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());

        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        Employer employer = employerRepository.findById(employerId).orElse(new Employer());
        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);

        newJob.setSkills(skillObjs);
        newJob.setEmployer(employer);
        jobRepository.save(newJob);

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);

        if (optionalJob.isPresent()) {
            Job job = (Job) optionalJob.get();
            model.addAttribute("job", job);
            return "view";
        } else {
            return "redirect:../";
        }

    }
}
