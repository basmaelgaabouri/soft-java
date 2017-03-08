/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Services;

import OrmMapping.Candidates;
import java.util.Comparator;

/**
 *
 * @author youpi
 */
public class CandidatesComparatorService implements Comparator<Candidates> {

    private final String principalSkillsC;
    private final String secondarySkillsC;

    public CandidatesComparatorService(String principalSkillsC, String secondarySkillsC) {
        this.principalSkillsC = principalSkillsC;
        this.secondarySkillsC = secondarySkillsC;
    }
    
    
    @Override
    public int compare(Candidates c1, Candidates c2) {
        int rateC1 = LinkedinService.rateLinkedinProfil(c1, principalSkillsC, secondarySkillsC);
        int rateC2 = LinkedinService.rateLinkedinProfil(c2, principalSkillsC, secondarySkillsC);
        if(rateC1 > rateC2)
            return 1;
        else if(rateC1 == rateC2)
            return 0;
        else
            return -1;
        
    }
    
}
