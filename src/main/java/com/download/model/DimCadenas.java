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
@Table(name = "dimcadenas")
public class DimCadenas implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_id")
    private int Id;

    @Size(max = 200)
    @Column(name = "dimcadenas_nombre")
    @JsonView(JSonUtil.Public.class)
    private String nombre;

    @Size(max = 20)
    @Column(name = "dimcadenas_nombre_corto")
    @JsonView(JSonUtil.Public.class)
    private String nombreCorto;

    @Size(max = 200)
    @Column(name = "dimcadenas_logo")
    @JsonView(JSonUtil.Public.class)
    private String logo;

    @Size(max = 200)
    @Column(name = "dimcadenas_tipo")
    @JsonView(JSonUtil.Public.class)
    private String tipo;

    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_upc")
    private int upc;

    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_sku")
    private int sku;

    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_ventas")
    private int ventas;

    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_existencias")
    private int existencias;
    
    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_pedidos")
    private int pedidos;
    
    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_recibos")
    private int recibos;
    
    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_devoluciones")
    private int devoluciones;
    
    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_forecast")
    private int forecast;
    
    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_asociacion")
    private int asociacion;
    
    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_ajuste")
    private int ajuste;
    
    @JsonView(JSonUtil.Public.class)
    @Column(name = "dimcadenas_ajuste_dia")
    private int ajuste_dia;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUpc() {
        return upc;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getPedidos() {
        return pedidos;
    }

    public void setPedidos(int pedidos) {
        this.pedidos = pedidos;
    }

    public int getRecibos() {
        return recibos;
    }

    public void setRecibos(int recibos) {
        this.recibos = recibos;
    }

    public int getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(int devoluciones) {
        this.devoluciones = devoluciones;
    }

    public int getForecast() {
        return forecast;
    }

    public void setForecast(int forecast) {
        this.forecast = forecast;
    }

    public int getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(int asociacion) {
        this.asociacion = asociacion;
    }

    public int getAjuste() {
        return ajuste;
    }

    public void setAjuste(int ajuste) {
        this.ajuste = ajuste;
    }

    public int getAjuste_dia() {
        return ajuste_dia;
    }

    public void setAjuste_dia(int ajuste_dia) {
        this.ajuste_dia = ajuste_dia;
    }

}
