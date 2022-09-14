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
public class Suscripcion {
    
    private int Numero;
    private Usuario Usuario;
    private String Equipos;
    private int AbonoTotal;
    
    public Suscripcion() {
        this.Numero = 0;
        this.Usuario = new Usuario();
        this.Equipos = "";
        this.AbonoTotal = 0;
    }

    public Suscripcion(int Numero, Usuario Usuario, String Equipos, int AbonoTotal) {
        this.Numero = Numero;
        this.Usuario = Usuario;
        this.Equipos = Equipos;
        this.AbonoTotal = AbonoTotal;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        if (Numero >= 0){
            this.Numero = Numero;
        }
        
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public String getEquipos() {
        return "\"" + this.Equipos + "\"";
    }

    public void setEquipos(String Equipos) {
        this.Equipos = Equipos;
    }

    public String getAbonoTotal() {
        
        return formateaPrecio(this.AbonoTotal);
    }

    public void setAbonoTotal(int AbonoTotal) {
        if (AbonoTotal >= 0) {
            this.AbonoTotal = AbonoTotal;
        }
    }
    
    public void agregaEquipos(Equipo Equipo, boolean Actualizando){
        
        if (Actualizando){
            this.Equipos = "";
            this.AbonoTotal = 0;
        }
        
        if (!this.Equipos.equals("")) {
            this.Equipos += "; ";
        }
        
        this.Equipos += Equipo.toString();
        this.AbonoTotal += Equipo.getValorSuscripcion();
    }
    
    private String formateaPrecio(int valor) {
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        return "$" + String.valueOf(formatea.format(valor));
    }
    
    @Override
    public String toString(){
        int numero = this.Numero;
        Usuario usuario = this.Usuario;
        String equipos = this.Equipos;
        String abono = formateaPrecio(this.AbonoTotal);
        
        return "ID Suscripcion: " + numero  + "\n" +
                "Usuario suscrito: " + usuario.getNombre() + "\n" + 
                "Email usuario suscrito: " + usuario.getEmail() + "\n" + 
                "Equipos: " + equipos + "\n" +
                "Abono total: " + abono;
        
    }
    
    
    
}
