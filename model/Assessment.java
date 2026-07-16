package model;

public class Assessment {

    private int id;
    private String vitals;
    private String eyes;
    private String breath;
    private String skin;
    private String pain;

    public Assessment(){}

    // For INSERT
    public Assessment(String vitals, String eyes, String breath, String skin, String pain){
        this.vitals = vitals;
        this.eyes = eyes;
        this.breath = breath;
        this.skin = skin;
        this.pain = pain;
    }

    // For FETCH (getAll / getById)
    public Assessment(int id, String vitals, String eyes, String breath, String skin, String pain){
        this.id = id;
        this.vitals = vitals;
        this.eyes = eyes;
        this.breath = breath;
        this.skin = skin;
        this.pain = pain;
    }

    // ================= GETTERS & SETTERS =================

    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }

    public String getVitals(){ return vitals; }
    public void setVitals(String vitals){ this.vitals = vitals; }

    public String getEyes(){ return eyes; }
    public void setEyes(String eyes){ this.eyes = eyes; }

    public String getBreath(){ return breath; }
    public void setBreath(String breath){ this.breath = breath; }

    public String getSkin(){ return skin; }
    public void setSkin(String skin){ this.skin = skin; }

    public String getPain(){ return pain; }
    public void setPain(String pain){ this.pain = pain; }
}