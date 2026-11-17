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
@Table(name = "des_response")
public class Response  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JSonUtil.Internal.class)
    @Column(name = "response_id")
    private  int Id;
    
    @Size(max = 4)
    @NotNull
    @Column(name = "response_code")
    @JsonView(JSonUtil.Internal.class)
    private  String code;
    
    @Size(max = 250)
    @NotNull
    @Column(name = "response_value")
    @JsonView(JSonUtil.Internal.class)
    private  String value;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
    