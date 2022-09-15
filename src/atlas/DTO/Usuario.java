/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atlas.DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author jpenaloza
 */
public class Usuario {
    
    private int Id;
    private int Run;
    private char Dv;
    private String NombreCompleto;
    private String NombreUsuario;
    private String FechaNacimiento;
    private int Edad;
    private String Telefono;
    private String Email;
    private String Password;
    
    public Usuario() {
        this.Id = 0;
        this.Run = 0;
        this.Dv = '0';
        this.NombreCompleto = "";
        this.NombreUsuario = "";
        this.FechaNacimiento = "";
        this.Edad = 0;
        this.Telefono = "";
        this.Email = "";
        this.Password = "";
    }

    public Usuario(int Id, int Run, char Dv, String NombreCompleto, String NombreUsuario, String FechaNacimiento, int Edad, String Telefono, String Email, String Password) {
        this.Id = Id;
        this.Run = Run;
        this.Dv = Dv;
        this.NombreCompleto = NombreCompleto;
        this.NombreUsuario = NombreUsuario;
        this.FechaNacimiento = FechaNacimiento;
        this.Edad = Edad;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Password = Password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public int getRun() {
        return this.Run;
    }
    
    public void setRun(int Run, char Dv){
        if (validarRut(Run, Dv)){
            this.Run = Run;
            this.Dv = Dv;
        }
    }
    
    public char getDv(){
        return this.Dv;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }
    
    public String getNombreUsuario() {
        return this.NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        if (NombreUsuario.length() > 3) {
            this.NombreUsuario = NombreUsuario;
        }
    }
    
    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }
    
    public int getEdad() {
        return this.Edad;
    }
    
    public void setEdad(int Edad) {
        if (Edad >= 18) {
            this.Edad = Edad;
        }
    }
    
    public String getTelefono() {
        return this.Telefono;
    }
    
    public void setTelefono(String Telefono){
        if (Telefono.startsWith("56") && Telefono.length() >= 8) {
            this.Telefono = Telefono;
        }
        
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        if (validaPass(Password)) {
            this.Password = Password;
        }
        
    }
    
    public boolean validaPass(String Password) {
        boolean valido = false;
        if (Password.length() >= 6 && Password.matches(".*[0-9].*") && Password.matches(".*[A-Z].*")){
            valido = true;
        }   
        return valido;
    }
    
    public boolean validaEmail(String Email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";  
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Email);
       return matcher.matches();
    }
    
    public boolean validarRut(int rut, char dv) {
        boolean validacion = false;
        try {
            int m = 0, s = 1;
            for (; rut != 0; rut /= 10) {
                s = (s + rut % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    public boolean compruebaLogin(String Email, String Password) {
        return Email.equals(this.Email) && Password.equals(this.Password);
    }
    
    public void reiniciaPassword(String temporalPass) {
        this.Password = temporalPass;
    }
    
    public boolean validaFecha(String Fecha){

        if (Fecha.equals("")) {
            return false;
        }
       
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd");
        sdformat.setLenient(false);
        try{
            sdformat.parse(Fecha);
            return true;
        }
        catch(ParseException e)
        {
            return false;
        }
        
    }
    
    
}
