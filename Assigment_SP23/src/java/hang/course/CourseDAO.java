/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.course;

import hang.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author LENOVO
 */
public class CourseDAO {

    private List<CourseDTO> listCourses;

    public List<CourseDTO> getListCourses() {
        return listCourses;
    }

    public void seach(String searchValue, String searchBy) throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null && searchBy != null) {
                String sql = "SELECT * FROM Courses JOIN Categories ON Courses.CateID = Categories.CateID";
                if (searchBy.equalsIgnoreCase("byname")) {
                    sql = sql + " WHERE Courses.name LIKE ?";
                }// if 2
                else {
                    sql = sql + " WHERE CateName LIKE ?";
                }
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int fee = rs.getInt("fee");
                    String img = rs.getString("imgPath");
                    String description = rs.getString("description");
                    String startDate = rs.getString("startDate");
                    String endDate = rs.getString("endDate");
                    int status = rs.getInt("status");
                    int CateID = rs.getInt("CateID");
                    String CateName = rs.getString("CateName");

                    CourseDTO dto = new CourseDTO(id, name, fee, img, description, startDate, endDate, status, CateID, CateName);

                    if (this.listCourses == null) {
                        this.listCourses = new ArrayList<CourseDTO>();
                    }//if 3
                    this.listCourses.add(dto);
                }//while
            }//if 1
        }/*try*/ catch (Error e) {
        } /*catch*/finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }//final
    }//void 
    
    public boolean update(String name, int fee, String img, String description, String startDate, String endDate, int status, int id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "UPDATE Courses SET name=?, fee=?, imgPath=?, description=?, startDate=?, endDate=?, status=? WHERE id=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, fee);
                stm.setString(3, img);
                stm.setString(4, description);
                stm.setString(5, startDate);
                stm.setString(6, endDate);
                stm.setInt(7, status);
                stm.setInt(8, id);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean insert(String name, int fee, String img, String description, String startDate, String endDate, int status, int CateID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = " INSERT INTO Courses(name, fee, imgPath, description, startDate, endDate, status, CateID)"
                        + " VALUES(?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, fee);
                stm.setString(3, img);
                stm.setString(4, description);
                stm.setString(5, startDate);
                stm.setString(6, endDate);
                stm.setInt(7, status);
                stm.setInt(8, CateID);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if(con != null) {
                con.close();
            }
        }
        return false;        
    }

}//class
