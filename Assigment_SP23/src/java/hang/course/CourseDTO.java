/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.course;

/**
 *
 * @author LENOVO
 */
public class CourseDTO {
    private int id;
    private String name;
    private int fee;
    private String img;
    private String description;
    private String startDate;
    private String endDate;
    private int status;
    private int CateID;
    private String CateName;
    
    public CourseDTO() {
        
    }

    public CourseDTO(int id, String name, int fee, String img, String description, String startDate, String endDate, int status, int CateID, String CateName) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.img = img;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.CateID = CateID;
        this.CateName = CateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateID() {
        return CateID;
    }

    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }

    
}
