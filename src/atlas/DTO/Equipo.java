/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atlas.DTO;

import java.text.DecimalFormat;

/**
 *
 * @author jpenaloza
 */
public class Equipo {
    
    private String Codigo;
    private String Deporte;
    private String Nombre;
    private String NombreFundador;
    private int AnioFundacion;
    private String Pais;
    private String Lema;
    private String Color1;
    private String Color2;
    private int ValorSuscripcion;
    
    public Equipo(){
        this.Codigo = "";
        this.Deporte = "";
        this.Nombre = "";
        this.NombreFundador = "";
        this.AnioFundacion = 0;
        this.Pais = "";
        this.Lema = "";
        this.Color1 = "";
        this.Color2 = "";
        this.ValorSuscripcion = 0;
    }

    public Equipo(String Codigo, String Deporte, String Nombre, String NombreFundador, int AnioFundacion, String Pais, String Lema, String Color1, String Color2, int ValorSuscripcion) {
        this.Codigo = Codigo;
        this.Deporte = Deporte;
        this.Nombre = Nombre;
        this.NombreFundador = NombreFundador;
        this.AnioFundacion = AnioFundacion;
        this.Pais = Pais;
        this.Lema = Lema;
        this.Color1 = Color1;
        this.Color2 = Color2;
        this.ValorSuscripcion = ValorSuscripcion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Correlativo, String Nombre, String Deporte) {
        this.Codigo = generaCodigoEquipo(Correlativo, Nombre, Deporte);
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String Deporte) {
        this.Deporte = Deporte;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombreFundador() {
        return NombreFundador;
    }

    public void setNombreFundador(String NombreFundador) {
        this.NombreFundador = NombreFundador;
    }

    public int getAnioFundacion() {
        return AnioFundacion;
    }

    public void setAnioFundacion(int AnioFundacion) {
        this.AnioFundacion = AnioFundacion;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getLema() {
        return Lema;
    }

    public void setLema(String Lema) {
        this.Lema = Lema;
    }

    public String getColor1() {
        return Color1;
    }

    public void setColor1(String Color1) {
        this.Color1 = Color1;
    }

    public String getColor2() {
        return Color2;
    }

    public void setColor2(String Color2) {
        this.Color2 = Color2;
    }
    
     public int getValorSuscripcion() {
        return ValorSuscripcion;
    }

    public String getValorSuscripcionFormat() {
        return formateaPrecio(ValorSuscripcion);
    }

    public void setValorSuscripcion(int ValorSuscripcion) {
        if (ValorSuscripcion >= 0) {
            this.ValorSuscripcion = ValorSuscripcion;
        }
        
    }
    
    private String formateaPrecio(int valor) {
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        return "$" + String.valueOf(formatea.format(valor));
    }
    
    public String getTodosColores() {
        return this.Color1 + ", " + this.Color2;
    }
        
    public String actualizaNombreEquipo(String Nombre, int Correlativo, String Deporte){
        this.Nombre = Nombre;
        String nuevoCodigo = generaCodigoEquipo(Correlativo, Nombre, Deporte);
        this.Codigo = nuevoCodigo;
        return nuevoCodigo;
    }
    
    public static String generaCodigoEquipo(int correlativo, String nombreEquipo, String deporte) {
      String[] arrNombreEquipo = nombreEquipo.split(" ");
      return String.valueOf(arrNombreEquipo[0].charAt(0)).toUpperCase() + String.valueOf(arrNombreEquipo[1].charAt(0)).toUpperCase() + String.valueOf(deporte.charAt(0)).toUpperCase() + String.valueOf(correlativo);
    }
    
    public void actualizaPrecioSuscripcion(int nuevoPrecio){
        if (nuevoPrecio >= 0) {
            this.ValorSuscripcion = nuevoPrecio;
        }
    }
    
    @Override
    public String toString(){
        return this.getCodigo() + " " + formateaPrecio(this.getValorSuscripcion());
    }
    
    
    
    
    
}
