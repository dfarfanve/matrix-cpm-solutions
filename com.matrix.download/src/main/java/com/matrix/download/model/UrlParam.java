package com.matrix.download.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.matrix.download.util.JSonUtil;
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
@Table(name = "url_param")
public class UrlParam  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JSonUtil.Public.class)
    @Column(name = "param_id")
    private  long paramId;
    @Column(name = "url_id")
    @JsonView(JSonUtil.Public.class)
    private  long urlId;
    @NotNull
    @Size(max = 60)
    @Column(name = "chain_name")
    @JsonView(JSonUtil.Public.class)
    private  String chainName;

   
    @Size(max = 40)
    @Column(name = "param_name")
    @JsonView(JSonUtil.Internal.class)
    private  String paramName;
    @Size(max = 20)
    @Column(name = "param_type")
    @JsonView(JSonUtil.Internal.class)
    private  String paramType;
 public UrlParam() {
    }
    public long getParamId() {
        return paramId;
    }

    public void setParamId(long paramId) {
        this.paramId = paramId;
    }

    public long getUrlId() {
        return urlId;
    }

    public void setUrlId(long urlId) {
        this.urlId = urlId;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }
    
    
    
}