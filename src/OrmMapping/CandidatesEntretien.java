package OrmMapping;
// Generated Feb 5, 2017 3:24:05 PM by Hibernate Tools 4.3.1



/**
 * CandidatesEntretien generated by hbm2java
 */
public class CandidatesEntretien  implements java.io.Serializable {


     private CandidatesEntretienId id;
     private Candidates candidates;
     private Entretien entretien;
     private String phase;
     private int column;

    public CandidatesEntretien() {
    }

    public CandidatesEntretien(CandidatesEntretienId id, Candidates candidates, Entretien entretien, String phase, int column) {
       this.id = id;
       this.candidates = candidates;
       this.entretien = entretien;
       this.phase = phase;
       this.column = column;
    }
   
    public CandidatesEntretienId getId() {
        return this.id;
    }
    
    public void setId(CandidatesEntretienId id) {
        this.id = id;
    }
    public Candidates getCandidates() {
        return this.candidates;
    }
    
    public void setCandidates(Candidates candidates) {
        this.candidates = candidates;
    }
    public Entretien getEntretien() {
        return this.entretien;
    }
    
    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }
    public String getPhase() {
        return this.phase;
    }
    
    public void setPhase(String phase) {
        this.phase = phase;
    }
    public int getColumn() {
        return this.column;
    }
    
    public void setColumn(int column) {
        this.column = column;
    }




}


