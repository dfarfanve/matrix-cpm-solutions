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
@Table(name = "des_url")
public class Url  implements Serializable{
    /* URLID */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JSonUtil.Public.class)
    @Column(name = "url_id")
    private  int urlId;
    
    /* URLSTR */
    @NotNull
    @Size(max = 512)
    @Column(name = "url_str")
    @JsonView(JSonUtil.Public.class)
    private  String urlStr;
    
       /* URLTYPE */
    @NotNull
    @Size(max = 60)
    @Column(name = "url_type")
    @JsonView(JSonUtil.Public.class)
    private  String urlType;
    
       /* URLREFERER*/
    @Size(max = 250)
    @Column(name = "url_referer")
    @JsonView(JSonUtil.Public.class)
    private  String urlRef;
    
       /* URLHREF */
    @NotNull
    @Size(max = 60)
    @Column(name = "url_href")
    @JsonView(JSonUtil.Public.class)
    private  String urlHRef;
    
    /* CHAINID */
    @JsonView(JSonUtil.Public.class)
    @Column(name = "chain_id")
    private  int chainId;
    
    /* URLNEXT */
    @JsonView(JSonUtil.Public.class)
    @Column(name = "url_next")
    private  int next;
    
     /* URLSEQ */
    @JsonView(JSonUtil.Public.class)
    @Column(name = "url_seq")
    private  int sequence;

    /* URLPARSEURI */
    @JsonView(JSonUtil.Public.class)
    @Column(name = "url_parseuri")
    private  String parseUri;

    

    public static Url copy( Url other ) {
         Url newUrl = new Url();
         newUrl.setUrlType(other.getUrlType());
         newUrl.setUrlRef(other.getUrlRef());
         newUrl.setUrlHRef(other.getUrlHRef());
         newUrl.setParseUri(other.getParseUri());
         return newUrl;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    
    
   

    public String getParseUri() {
        return parseUri;
    }

    public void setParseUri(String parseUri) {
        this.parseUri = parseUri;
    }

    
    
    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getUrlStr() {
        return urlStr;
    }

    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getUrlRef() {
        return urlRef;
    }

    public void setUrlRef(String urlRef) {
        this.urlRef = urlRef;
    }

    public String getUrlHRef() {
        return urlHRef;
    }

    public void setUrlHRef(String urlHRef) {
        this.urlHRef = urlHRef;
    }

    public int getChainId() {
        return chainId;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
    }
    
 
    
}