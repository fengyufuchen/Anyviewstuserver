package com.anyview.database.c3p0;
import java.sql.*;
import java.lang.ClassNotFoundException;
public class SubscriberLoginDBHandler {
	
	public ResultSet subscriberLoginQuery(String userAccount, String userPassword, String universityID)
			throws ClassNotFoundException, SQLException {
		Connection con = C3P0Util.getConnection();
		PreparedStatement ps = 
				con.prepareStatement("SELECT st.sname, un.UnName " + 
									"FROM studenttable st, universitytable un " + 
									"WHERE st.Sno = ? and st.SPsw = ? and st.UnID = ? " +
									"and st.UnID = un.UnID");
		ps.setString(1, userAccount);
		ps.setString(2, userPassword);
		ps.setString(3, universityID);
		
		ResultSet result = ps.executeQuery();
		
		//C3P0Util.close(con, ps, null);
		
		return result;
	}
	
}
