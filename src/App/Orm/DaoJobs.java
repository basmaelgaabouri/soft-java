/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Orm;

import OrmMapping.Jobs;
import java.util.List;

/**
 *
 * @author youpi
 */
public class DaoJobs extends DaoAbstract {
    
    public DaoJobs() {
        super(Jobs.class);
    }
   
   @Override
   public List  getAll(){
      return super.getAll();    
   }
   
   public List findById(int id){
       return super.getQuery("select j from Jobs j where id = "+id);
   }
   
}
