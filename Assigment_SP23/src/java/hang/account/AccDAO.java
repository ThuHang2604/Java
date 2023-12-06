/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.account;

import hang.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author LENOVO
 */
public class AccDAO {
    public static AccDTO check(String userId, String password) throws SQLException, ClassNotFoundException{
        AccDTO acc = null;
        Connection con = DBUtils.makeConnection();         
        String sql = "SELECT * FROM Accounts WHERE userID=? and password=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userId);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs != null && rs.next()) {
            acc = new AccDTO();
            acc.setUserID(rs.getString("userID"));
            acc.setPassword(rs.getString("password"));
            acc.setFullname(rs.getString("fullname"));
            acc.setRoleID(rs.getString("roleID"));
        }
        con.close();
        return acc;
    }
}
