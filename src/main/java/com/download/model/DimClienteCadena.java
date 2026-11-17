package com.download.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.download.util.JSonUtil;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dimclientecadena")
public class DimClienteCadena implements Serializable {

    @Id
    @JsonView(JSonUtil.Public.class)
    private int cadena_id;
    @JsonView(JSonUtil.Public.class)
    private int clientes_id;
    @JsonView(JSonUtil.Public.class)
    private int bases_id;
    @JsonView(JSonUtil.Public.class)
    private int tipo_id;
    @JsonView(JSonUtil.Public.class)
    private String cadena_nombre;
    @JsonView(JSonUtil.Public.class)
    private String clientes_nombre;
    @JsonView(JSonUtil.Public.class)
    private String bases_nombre;
    @JsonView(JSonUtil.Public.class)
    private String dwh;
    @JsonView(JSonUtil.Public.class)
    private int mes_inicio;
    @JsonView(JSonUtil.Public.class)
    private int mes_fin;
    @JsonView(JSonUtil.Public.class)
    private int mesWM_inicio;
    @JsonView(JSonUtil.Public.class)
    private int mesWM_fin;
    @JsonView(JSonUtil.Public.class)
    private int semana_inicio;
    @JsonView(JSonUtil.Public.class)
    private int semana_fin;
    @JsonView(JSonUtil.Public.class)
    private int semanaWM_inicio;
    @JsonView(JSonUtil.Public.class)
    private int semanaWM_fin;
    @JsonView(JSonUtil.Public.class)
    private int semana_cerrada;
    @JsonView(JSonUtil.Public.class)
    private int semanaWM_cerrada;
    @JsonView(JSonUtil.Public.class)
    private Date fecha_inicio;
    @JsonView(JSonUtil.Public.class)
    private Date fecha_fin;
    @JsonView(JSonUtil.Public.class)
    private int proceso_activo;
    @JsonView(JSonUtil.Public.class)
    private int proceso_activo_interno;
    @JsonView(JSonUtil.Public.class)
    private int pass_activo;

    public int getCadena_id() {
        return cadena_id;
    }

    public void setCadena_id(int cadena_id) {
        this.cadena_id = cadena_id;
    }

    public int getClientes_id() {
        return clientes_id;
    }

    public void setClientes_id(int clientes_id) {
        this.clientes_id = clientes_id;
    }

    public int getBases_id() {
        return bases_id;
    }

    public void setBases_id(int bases_id) {
        this.bases_id = bases_id;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getCadena_nombre() {
        return cadena_nombre;
    }

    public void setCadena_nombre(String cadena_nombre) {
        this.cadena_nombre = cadena_nombre;
    }

    public String getClientes_nombre() {
        return clientes_nombre;
    }

    public void setClientes_nombre(String clientes_nombre) {
        this.clientes_nombre = clientes_nombre;
    }

    public String getBases_nombre() {
        return bases_nombre;
    }

    public void setBases_nombre(String bases_nombre) {
        this.bases_nombre = bases_nombre;
    }

    public String getDwh() {
        return dwh;
    }

    public void setDwh(String dwh) {
        this.dwh = dwh;
    }

    public int getMes_inicio() {
        return mes_inicio;
    }

    public void setMes_inicio(int mes_inicio) {
        this.mes_inicio = mes_inicio;
    }

    public int getMes_fin() {
        return mes_fin;
    }

    public void setMes_fin(int mes_fin) {
        this.mes_fin = mes_fin;
    }

    public int getMesWM_inicio() {
        return mesWM_inicio;
    }

    public void setMesWM_inicio(int mesWM_inicio) {
        this.mesWM_inicio = mesWM_inicio;
    }

    public int getMesWM_fin() {
        return mesWM_fin;
    }

    public void setMesWM_fin(int mesWM_fin) {
        this.mesWM_fin = mesWM_fin;
    }

    public int getSemana_inicio() {
        return semana_inicio;
    }

    public void setSemana_inicio(int semana_inicio) {
        this.semana_inicio = semana_inicio;
    }

    public int getSemana_fin() {
        return semana_fin;
    }

    public void setSemana_fin(int semana_fin) {
        this.semana_fin = semana_fin;
    }

    public int getSemanaWM_inicio() {
        return semanaWM_inicio;
    }

    public void setSemanaWM_inicio(int semanaWM_inicio) {
        this.semanaWM_inicio = semanaWM_inicio;
    }

    public int getSemanaWM_fin() {
        return semanaWM_fin;
    }

    public void setSemanaWM_fin(int semanaWM_fin) {
        this.semanaWM_fin = semanaWM_fin;
    }

    public int getSemana_cerrada() {
        return semana_cerrada;
    }

    public void setSemana_cerrada(int semana_cerrada) {
        this.semana_cerrada = semana_cerrada;
    }

    public int getSemanaWM_cerrada() {
        return semanaWM_cerrada;
    }

    public void setSemanaWM_cerrada(int semanaWM_cerrada) {
        this.semanaWM_cerrada = semanaWM_cerrada;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getProceso_activo() {
        return proceso_activo;
    }

    public void setProceso_activo(int proceso_activo) {
        this.proceso_activo = proceso_activo;
    }

    public int getProceso_activo_interno() {
        return proceso_activo_interno;
    }

    public void setProceso_activo_interno(int proceso_activo_interno) {
        this.proceso_activo_interno = proceso_activo_interno;
    }

    public int getPass_activo() {
        return pass_activo;
    }

    public void setPass_activo(int pass_activo) {
        this.pass_activo = pass_activo;
    }

}
