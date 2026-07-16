package model;

public class Response {

    private int id; // Response_ID (PRIMARY KEY)
    private int ecNo;
    private String station;
    private int ambulanceNo;
    private String incident;
    private String destination;
    private int mileage;
    private String staff;

    public Response() {}

    // INSERT constructor (NO ID)
    public Response(int ecNo, String station, int ambulanceNo,
                    String incident, String destination,
                    int mileage, String staff) {

        this.ecNo = ecNo;
        this.station = station;
        this.ambulanceNo = ambulanceNo;
        this.incident = incident;
        this.destination = destination;
        this.mileage = mileage;
        this.staff = staff;
    }

    // constructor (WITH ID)
    public Response(int id, int ecNo, String station, int ambulanceNo,
                    String incident, String destination,
                    int mileage, String staff) {

        this.id = id;
        this.ecNo = ecNo;
        this.station = station;
        this.ambulanceNo = ambulanceNo;
        this.incident = incident;
        this.destination = destination;
        this.mileage = mileage;
        this.staff = staff;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEcNo() { return ecNo; }
    public void setEcNo(int ecNo) { this.ecNo = ecNo; }

    public String getStation() { return station; }
    public void setStation(String station) { this.station = station; }

    public int getAmbulanceNo() { return ambulanceNo; }
    public void setAmbulanceNo(int ambulanceNo) { this.ambulanceNo = ambulanceNo; }

    public String getIncident() { return incident; }
    public void setIncident(String incident) { this.incident = incident; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public String getStaff() { return staff; }
    public void setStaff(String staff) { this.staff = staff; }
}