package com.example.resourceservice;

//import com.example.resourceservice.dao.ProjectDao;
//import com.example.resourceservice.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    ResourceDao resourceDao;

    public void addResource(Resource resource) {
        resourceDao.save(resource);
    }

    public void addResourceList(List<Resource> resourceList) {
        resourceDao.saveAll(resourceList);
    }

    public List<Resource> getAllResources() {
        return resourceDao.findAll();
    }

    public Optional<Resource> getResourceById(int id) {
        return resourceDao.findById(id);
    }

    public Optional<Resource> setResourceById(Resource resource, int resourceId) {
        Optional<Resource> existResource = resourceDao.findById(resourceId);
        if (existResource.isPresent()) {
            resource.setId(resourceId);
            resourceDao.save(resource);;
        }
        return existResource;
    }

    public Optional<Resource> deleteResourceById(int resourceId) {
        Optional<Resource> existResource = resourceDao.findById(resourceId);
        if (existResource.isPresent()) {
            resourceDao.deleteById(resourceId);
        }
        return existResource;
    }

    public void deleteAllResources() {
        resourceDao.deleteAll();
    }

//    public Optional<Project> addResourcesToProject(List<Resource> resourceList, int projectId) {
////        Optional<Project> existProject = projectDao.findById(projectId);
//        Optional<Project> existProject = null;
//        if (existProject.isPresent()) {
//            Project project = existProject.get();
//            for (Resource resource : resourceList) {
//                project.addResource(resource);
//            }
//            resourceDao.saveAll(resourceList);
////            projectDao.save(project);
//        }
//        return existProject;
//    }

}
