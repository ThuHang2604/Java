/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.account;

/**
 *
 * @author LENOVO
 */
public class AccDTO {
    private String userID;
    private String password;
    private String fullname;
    private String roleID;
    
    public AccDTO() {
        
    }

    public AccDTO(String userID, String password, String fullname, String roleID) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.roleID = roleID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
    
    
    
}
