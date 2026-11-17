package com.download.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.download.util.JSonUtil;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "des_user")
public class User  implements Serializable{
    /* USERID */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @JsonView(JSonUtil.Public.class)
    private  int userId;
    /* USERNAME */
    @NotNull
    @Size(max = 60)
    @Column(name = "user_name", nullable = false)
    @JsonView(JSonUtil.Public.class)
    private  String userName;
     /* USERPASS */
    @NotNull
    @Size(max = 512)
    @JsonView(JSonUtil.Internal.class)
    @Column(name = "user_pass", nullable = false)
    private  String userPass;
     /* CHAINNAME */
    @JsonView(JSonUtil.Public.class)
    private  String chainName;
     /* ISACTIVE */
    @JsonView(JSonUtil.Public.class)
    private  String isActive;
     /* CLIENTNAME */
    @JsonView(JSonUtil.Public.class)
    private  String clientName;
     /* PROVIDER */
    @JsonView(JSonUtil.Public.class)
    private  String provider;
     /* CLIENTID */
    @JsonView(JSonUtil.Public.class)
    @Column(name = "clientid")
    private  int clientId;
       /* CLIENTID */
    @JsonView(JSonUtil.Public.class)
    @Column(name = "chainid")
    private  int chainId;
     /* LASTLOGIN */
    @JsonView(JSonUtil.Public.class)
    private  Date lastLogin;
     /* CREATED */
    @JsonView(JSonUtil.Public.class)
    private  Date created;
     /* UPDATED */
    @JsonView(JSonUtil.Public.class)
    private  Date updated;
     /* CREATEDBY */
    @JsonView(JSonUtil.Public.class)
    private  String createdBy;
     /* UPDATEBY */
    @JsonView(JSonUtil.Public.class)
    private  String updatedBy;
    @JsonView(JSonUtil.Public.class)
     /* PWDEXPIRATION */
    private  Date pwd_Expiration;
    @JsonView(JSonUtil.Public.class)
     /* DATE OF BIRTH */
    private  Date date_Of_Birth;
    @JsonView(JSonUtil.Public.class)
     /* PWDLASTSET */
    private  Date pwd_lastset;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
    @JsonView(JSonUtil.Public.class)
     /* EMAIL */
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getPwd_Expiration() {
        return pwd_Expiration;
    }

    public void setPwd_Expiration(Date pwd_Expiration) {
        this.pwd_Expiration = pwd_Expiration;
    }

    public Date getDate_Of_Birth() {
        return date_Of_Birth;
    }

    public void setDate_Of_Birth(Date date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }

    public Date getPwd_lastset() {
        return pwd_lastset;
    }

    public void setPwd_lastset(Date pwd_lastset) {
        this.pwd_lastset = pwd_lastset;
    }

    public int getChainId() {
        return chainId;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
    

    public User(){
        
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getChainName() {
        return chainName;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getClientName() {
        return clientName;
    }

    public int getClientId() {
        return clientId;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

      
}