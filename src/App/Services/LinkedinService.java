/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Services;

import OrmMapping.Candidates;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author youpi
 */
public class LinkedinService {

    public static int rateLinkedinProfil(Candidates c, String principalSkills, 
           String secondarySkills) 
    {
        String json = profileToJson(c.getLinkedinUrl());
        JSONObject jsonObj = new JSONObject(json);        
        String[] principalSkillsTab = principalSkills.split(",");
        String[] secondarySkillsTab = secondarySkills.split(",");
        int rate = 0;
        rate = rateNbConnection(jsonObj,rate);
        rate = rateSkills(jsonObj,principalSkillsTab,secondarySkillsTab,rate);
        rate = rateProjects(jsonObj, principalSkillsTab, secondarySkillsTab, rate);
        return rate;
    }

    public static String profileToJson(String linkedinUrl) {
        StringBuffer output = new StringBuffer();
        try {
            String command = "ruby src/App/Services/getProfileInJson.rb " + linkedinUrl;
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }
    
    public static int rateNbConnection(JSONObject obj,int rate){
        String nbconnectionString = obj.getString("number_of_connections");
        int nbConnection = Integer.parseInt(nbconnectionString); 
        if (nbConnection > 200) {
            rate += 2;
        } else if (nbConnection > 500) {
            rate += 3;
        }
        return rate;
    }
    
    public static int rateProjects(JSONObject obj, String[] principalSkillsTab, 
            String[] secondarySkillsTab, int rate) {
        int rateProjectPrincipal = rateProjectsPrincipal(obj, principalSkillsTab, rate);
        int rateProjectSecondary = rateProjectsSecondary(obj, secondarySkillsTab, rate);
        return rateProjectPrincipal + rateProjectSecondary;
    }
    
    public static int rateSkills(JSONObject obj,String[] principalSkillsTab,String[] secondarySkillsTab,int rate){
        int ratePrincipal = ratePrincipalSkills(obj, principalSkillsTab, rate);
        int rateSecondary = rateSecondarySkills(obj,secondarySkillsTab,rate);
        return ratePrincipal+rateSecondary;
    }
    
    public static int ratePrincipalSkills(JSONObject obj,String[] principalSkillsTab,int rate){
        JSONArray skills = obj.getJSONArray("skills");
        for (int i = 0; i < skills.length(); i++) {
            for (int j = 0; j < principalSkillsTab.length; j++) {
                String skill = skills.getString(i);
                if (skill.toLowerCase().contains(principalSkillsTab[j].toLowerCase())) {
                    rate+=3;
                }
            }
            
        }
        return rate;
    }
    
    public static int rateSecondarySkills(JSONObject obj, String[] secondarySkillsTab,int rate ) {
        JSONArray skills = obj.getJSONArray("skills");
        for (int i = 0; i < skills.length(); i++) {
            for (int j = 0; j < secondarySkillsTab.length; j++) {
                String skill = skills.getString(i);
                if (skill.toLowerCase().contains(secondarySkillsTab[j].toLowerCase())) {
                    rate += 1;
                }
            }

        }
        return rate;
    }
    
   

    public static int rateProjectsPrincipal(JSONObject obj,String[] principalSkillsTab ,int rate){
        JSONArray projects = obj.getJSONArray("projects");
        for(int i=0;i<projects.length();i++){
            for(int j=0; j<principalSkillsTab.length;j++){
                JSONObject project = projects.getJSONObject(i);
                String projectTitle = project.getString("title");
                String projectDescription = project.getString("description");
                if (projectTitle.toLowerCase().contains(principalSkillsTab[j].toLowerCase())) {
                    rate += 8;
                }
                if (projectDescription.toLowerCase().contains(principalSkillsTab[j].toLowerCase())) {
                    rate += 5;
                }
            }
        }
        return rate;
    }
    
    public static int rateProjectsSecondary(JSONObject obj,String[] secondarySkillsTab,int rate){
        JSONArray projects = obj.getJSONArray("projects");
        for(int i=0;i<projects.length();i++){
            for(int j=0; j<secondarySkillsTab.length;j++){
                JSONObject project = projects.getJSONObject(i);
                String projectTitle = project.getString("title");
                String projectDescription = project.getString("description");
                if (projectTitle.toLowerCase().contains(secondarySkillsTab[j].toLowerCase())) {
                    rate += 4;
                }
                if (projectDescription.toLowerCase().contains(secondarySkillsTab[j].toLowerCase())) {
                    rate += 2;
                }
            }
        }
        return rate;
    }
    

}
