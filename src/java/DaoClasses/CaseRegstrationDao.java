package DaoClasses;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaseRegstrationDao {
    DBConnect connect = new DBConnect();
    Connection conn = connect.checkConnection();
    public boolean isRegistered(String defName, String defAddress, 
            String crimeType, Date crimeDate, String crimeLoc, String officerName, 
            Date arrestDate,Date startDate, String caseSummary, int stationid) {
        
        String columns = "(DefendantName, DefendantAddress, CrimeLoc, CrimeDate, CrimeType, "
                + "ArrestDate, OfficerName, StartDate, CaseSummary, StationID)";
        
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO CASES " + columns + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, defName);
            ps.setString(2, defAddress);
            ps.setString(3, crimeLoc);

            // Convert java.util.Date to java.sql.Date before setting it
            if (crimeDate != null) {
                ps.setDate(4, new java.sql.Date(crimeDate.getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }

            ps.setString(5, crimeType);

            if (arrestDate != null) {
                ps.setDate(6, new java.sql.Date(arrestDate.getTime()));
            } else {
                ps.setNull(6, java.sql.Types.DATE);
            }

            ps.setString(7, officerName);
           // ps.setString(8, lawyerName);

            if (startDate != null) {
                ps.setDate(8, new java.sql.Date(startDate.getTime()));
            } else {
                ps.setNull(8, java.sql.Types.DATE);
            }

            ps.setString(9, caseSummary);
            ps.setInt(10, stationid);
            System.out.println("stationid from registration"+ stationid);
            System.out.println("In CASE registration dao");
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new case was registered successfully!");
                return true;
            }
        }catch (SQLIntegrityConstraintViolationException e) {
            //System.err.println("Foreign key violation: StationID = " + caseObject.getStationId() + " does not exist in STATION table.");
        e.printStackTrace();
        return false;
    }
        catch (SQLException ex) {
            Logger.getLogger(CaseRegstrationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return false;
    }
    
    public int getStationId(String username){
        String query ="select StationID from STATION where StationUsername=?;";
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                System.out.println(username+" from Registration");
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    
                    int k= rs.getInt("StationID");
                    System.out.println(k+" Station ID");
                    return k;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CaseRegstrationDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public boolean isStationCase(int sid, int caseid) {
       String query = "select CaseID from CASES where CaseID=? and StationID=?";
        try {
            PreparedStatement ps =  conn.prepareStatement(query);
            ps.setInt(1, caseid);
            ps.setInt(2, sid);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(CaseRegstrationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
