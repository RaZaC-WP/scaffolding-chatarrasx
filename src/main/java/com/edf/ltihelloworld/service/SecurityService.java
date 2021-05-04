package com.edf.ltihelloworld.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ksu.lti.launch.model.InstitutionRole;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SecurityService {


   public boolean isAdminUser(String canvasLoginId, List<InstitutionRole> userRoles) {
       return userRoles.contains(InstitutionRole.Administrator);
   }

   public boolean isFaculty(List<InstitutionRole> userRoles) {
       if(userRoles != null && !userRoles.isEmpty()) {
           return userRoles.contains(InstitutionRole.Administrator)
                    || userRoles.contains(InstitutionRole.Instructor)
                    || userRoles.contains(InstitutionRole.TeachingAssistant);
           }
       return false;
   }

   public boolean isStudent(List<InstitutionRole> userRoles) {
       if(userRoles != null && !userRoles.isEmpty()) {
           return userRoles.contains(InstitutionRole.Student)
                    || userRoles.contains(InstitutionRole.Learner);
           }
       return false;
   }
   
   public boolean isAnonymous(List<InstitutionRole> userRoles) {
       if(userRoles != null && !userRoles.isEmpty()) {
           return userRoles.contains(InstitutionRole.None);
       }
       return false;
   }

}
