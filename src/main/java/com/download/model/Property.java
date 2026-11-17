package com.download.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.download.util.JSonUtil;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "des_property")
public class Property  implements Serializable{
    
    @Id
    @NotNull
    @JsonView(JSonUtil.Public.class)
    @Column(name = "url_id")
    private  int urlId;

    @NotNull
    @Size(max = 250)
    @Column(name = "proper_name")
    @JsonView(JSonUtil.Public.class)
    private  String name;

    @NotNull
    @Size(max = 20)
    @Column(name = "proper_type")
    @JsonView(JSonUtil.Public.class)
    private  String type;
    
    @Size(max = 250)
    @Column(name = "proper_value")
    @JsonView(JSonUtil.Public.class)
    private  String value;

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
   
}