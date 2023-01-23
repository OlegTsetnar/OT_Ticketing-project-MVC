package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {


    @Override
    public ProjectDTO save(ProjectDTO object) {

        if (object.getProjectStatus() == null)
            object.setProjectStatus(Status.OPEN);
        return super.save(object.getProjectCode(), object);

    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.delete(id);
    }

    @Override
    public void update(ProjectDTO object) {
        ProjectDTO project = findById(object.getProjectCode());
        if (object.getProjectStatus() == null)
            object.setProjectStatus(project.getProjectStatus());
        super.update(object.getProjectCode(), object);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
        super.save(project.getProjectCode(), project);
    }
}
