package dao;
import daoimpl.*;

public class DAOFactory {

    public static PatientDAO getPatientDAO(){
        return new PatientDAOImpl();
    }

    public static ResponseDAO getResponseDAO(){
        return new ResponseDAOImpl();
    }

    public static HistoryDAO getHistoryDAO(){
        return new HistoryDAOImpl();
    }

    public static AssessmentDAO getAssessmentDAO(){
        return new AssessmentDAOImpl();
    }
}