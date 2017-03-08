/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Orm;

import OrmMapping.Candidates;
import java.util.List;

/**
 *
 * @author youpi
 */
public class DaoCandidates extends DaoAbstract{
    
    
    public DaoCandidates(){
        super(Candidates.class);
    }
   
    public List getAllByJob(int idJob){
        List result = getQuery("select c from Candidates c join c.jobses j where j.id="+idJob);
        return result;
    }
    
   
    
    
    
}
