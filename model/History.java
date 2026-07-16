package model;

public class History {

    private int id;
    private String symptoms;
    private String allergies;
    private String medications;
    private String stroke;
    private String history;

    public History(){}

    // INSERT constructor (NO ID - AUTO_INCREMENT)
    public History(String symptoms, String allergies,
                   String medications, String stroke, String history) {

        this.symptoms = symptoms;
        this.allergies = allergies;
        this.medications = medications;
        this.stroke = stroke;
        this.history = history;
    }

    // GET FROM DATABASE (WITH ID)
    public History(int id, String symptoms, String allergies,
                   String medications, String stroke, String history) {

        this.id = id;
        this.symptoms = symptoms;
        this.allergies = allergies;
        this.medications = medications;
        this.stroke = stroke;
        this.history = history;
    }

    // Getters & Setters
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }

    public String getSymptoms(){ return symptoms; }
    public void setSymptoms(String symptoms){ this.symptoms = symptoms; }

    public String getAllergies(){ return allergies; }
    public void setAllergies(String allergies){ this.allergies = allergies; }

    public String getMedications(){ return medications; }
    public void setMedications(String medications){ this.medications = medications; }

    public String getStroke(){ return stroke; }
    public void setStroke(String stroke){ this.stroke = stroke; }

    public String getHistory(){ return history; }
    public void setHistory(String history){ this.history = history; }
}