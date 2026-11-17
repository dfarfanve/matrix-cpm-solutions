package com.download.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.download.util.JSonUtil;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "des_param")
public class Parameter  implements Serializable{
    /* PARAMID */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JSonUtil.Public.class)
    @Column(name = "param_id")
    private  int paramId;
    
    /* URLID */
    @NotNull
    @Column(name = "url_id")
    @JsonView(JSonUtil.Public.class)
    private  int urlId;
    
    /* PARAMNAME */
    @Size(max = 60)
    @NotNull
    @Column(name = "param_name")
    @JsonView(JSonUtil.Internal.class)
    private  String paramName;
    
    /* PARAMVALUE */
    @Size(max = 60)
    @Column(name = "param_value")
    @JsonView(JSonUtil.Internal.class)
    private  String paramValue;
    
    /* PARAMTYPE */
    @Size(max = 60)
    @NotNull
    @Column(name = "param_type")
    @JsonView(JSonUtil.Internal.class)
    private  String paramType;
    
    /* PARAMREF */
    @Size(max = 60)
    @Column(name = "param_ref")
    @JsonView(JSonUtil.Internal.class)
    private  String paramRef;

    public int getParamId() {
        return paramId;
    }

    public void setParamId(int paramId) {
        this.paramId = paramId;
    }

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamRef() {
        return paramRef;
    }

    public void setParamRef(String paramRef) {
        this.paramRef = paramRef;
    }
   
    
    
}