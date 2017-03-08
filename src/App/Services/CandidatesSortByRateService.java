/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Services;

import App.Orm.DaoCandidates;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author youpi
 */
public class CandidatesSortByRateService  {
        
    /***
     * 
     * @param idJob
     * @param principalSkills
     * @param secondarySkills
     * @return List of candidates sorted by best rated for a specific job 
     * ( rate is calculated based on skills keywords)
     */
    public static List sortCandidates(int idJob,String principalSkills,String secondarySkills) {
        
      DaoCandidates dc = new DaoCandidates();
      List cList = dc.getAllByJob(idJob);
      Collections.sort(cList,new CandidatesComparatorService(principalSkills, secondarySkills));
      return cList;
      
    }
    
    
}
