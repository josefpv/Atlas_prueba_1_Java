
package atlas;
import atlas.DTO.Usuario;
import atlas.DTO.Equipo;
import atlas.DTO.Suscripcion;
/**
 *
 * @author Jose F. Peñaloza V.
 * RUN: 26.539.208-3
 * Asignatura: PGY2121
 * Seccion: 007v
 */
public class Principal {

    public static void main(String[] args) {
        
        //Se crean correlativo
        int correlativo = 10;
        String NombreEquipo;
        //Se define deporte
        String Deporte = "Handball";
        
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        Usuario usuario3 = new Usuario();
        
        //Se registran los usuarios
        System.out.println("==== REGISTRO DE USUARIOS EN EL SISTEMA ====");
        //Registro de usuario 1
        System.out.println("|_ Registrando: docog");
        usuario1.setId(1000);
        usuario1.setRun(26539208, '3');
        usuario1.setNombre("dcog");
        usuario1.setEdad(44);
        usuario1.setTelefono("56635221254");
        usuario1.setEmail("david.cogiolle@gmail.com");
        usuario1.setPassword("Afds22231");
        //Registro de usuario 2
        System.out.println("|_ Registrando: ggft");
        usuario2.setId(1001);
        usuario2.setRun(26539208, '3');
        usuario2.setNombre("ggft");
        usuario2.setEdad(23);
        usuario2.setTelefono("56828884115");
        usuario2.setEmail("gerr.adere@live.cl");
        usuario2.setPassword("G1ovanniGg34");
        //Registro de usuario 3
        System.out.println("|_ Registrando: scodiio");
        usuario3.setId(1002);
        usuario3.setRun(26539208, '3');
        usuario3.setNombre("scodiio");
        usuario3.setEdad(30);
        usuario3.setTelefono("56823002102");
        usuario3.setEmail("sergio.villanueva@gmail.com");
        usuario3.setPassword("5534Gato33");
        
        System.out.println("\n==== FIN REGISTRO DE USUARIOS EN EL SISTEMA ====\n");
        //Se registran los equipos (clubes?)       
        System.out.println("==== INICIO REGISTRO DE EQUIPOS DEPORTIVOS ====");
        System.out.println("|_ Registrando: Arsenal de Coquimbo");
        //Se define nombre de equipo para generar ID
        NombreEquipo="Arsenal de Coquimbo";
        Equipo equipo1 = new Equipo();
        //Se genera codigo del equipo desde el correlativo, nombre y deporte (handball)
        equipo1.setCodigo(correlativo++, NombreEquipo, Deporte);
        equipo1.setDeporte(Deporte);
        equipo1.setNombre(NombreEquipo);
        equipo1.setNombreFundador("Carlos Gutierrez");
        equipo1.setAnioFundacion(1998);
        equipo1.setPais("Chile");
        equipo1.setLema("Cañones a los puertos");
        equipo1.setColor1("Amarillo");
        equipo1.setColor2("Rojo");
        equipo1.setValorSuscripcion(10050);
        
        System.out.println("|_ Registrando: Manquehue City");
        NombreEquipo="Manquehue City";
        Equipo equipo2 = new Equipo();
        equipo2.setCodigo(correlativo++, NombreEquipo, Deporte);
        equipo2.setDeporte(Deporte);
        equipo2.setNombre(NombreEquipo);
        equipo2.setNombreFundador("Fabiola Montero");
        equipo2.setAnioFundacion(2003);
        equipo2.setPais("Chile");
        equipo2.setLema("Vivir y Fuerza");
        equipo2.setColor1("Celeste");
        equipo2.setColor2("Blanco");
        equipo2.setValorSuscripcion(15100);
        
        System.out.println("|_ Registrando: Los Cóndores Unidos");
        NombreEquipo="Los Cóndores Unidos";
        Equipo equipo3 = new Equipo();
        equipo3.setCodigo(correlativo++, NombreEquipo, Deporte);
        equipo3.setDeporte(Deporte);
        equipo3.setNombre(NombreEquipo);
        equipo3.setNombreFundador("Max Carrasco");
        equipo3.setAnioFundacion(2017);
        equipo3.setPais("Irlanda");
        equipo3.setLema("Desde lo alto al sol");
        equipo3.setColor1("Amarillo");
        equipo3.setColor2("Naranja");
        equipo3.setValorSuscripcion(13200);
        
        System.out.println("\n==== FIN REGISTRO DE EQUIPOS DEPORTIVOS ====\n");
        
        System.out.println("==== INICIO SUSCRIPCIONES ====");
        //Se registran suscripciones a equipos
        //con correlativo iniciando en 1000 y aumentando de 10 en 10
        int correlativoSuscripcion = 1000;
        
        //Un método que nos permita suscribirnos a un club.
        System.out.println("|_ Suscripcion 1");
        Suscripcion suscripcion1 = new Suscripcion();
        suscripcion1.setNumero(correlativoSuscripcion+10);
        suscripcion1.setUsuario(usuario1);
        suscripcion1.agregaEquipos(equipo1, false);
        suscripcion1.agregaEquipos(equipo2, false);
        
        System.out.println("|_ Suscripcion 2");
        Suscripcion suscripcion2 = new Suscripcion();
        suscripcion2.setNumero(correlativoSuscripcion+10);
        suscripcion2.setUsuario(usuario2);
        suscripcion2.agregaEquipos(equipo3, false);
        
        System.out.println("|_ Suscripcion 3");
        Suscripcion suscripcion3 = new Suscripcion();
        suscripcion3.setNumero(correlativoSuscripcion+10);
        suscripcion3.setUsuario(usuario3);
        suscripcion3.agregaEquipos(equipo3, false);
        suscripcion3.agregaEquipos(equipo2, false);
        
        System.out.println("\n==== FIN SUSCRIPCIONES ====\n");
        
        System.out.println("==== COMPRUEBA LOGIN ====");
        //Un método que permita al usuario comprobar el login con el nombre de usuario y contraseñ
        if (usuario1.compruebaLogin("david.cogiolle@gmail.com", "Afds22231")) {
            System.out.println("|_ Usuario 1 logeado correctamente.");
        }
        else
        {
            System.out.println(" |_ Usuario 1 no esta logeado.");
        }
        
        System.out.println("\n==== REINICIA PASSWORD USUARIO 1 ====");
        //Un método que permita reiniciar la contraseña de un usuario a una contraseña temporal (válida según las reglas de validación).
        String temporalPass = "Ad558c";
        if (usuario1.validaPass(temporalPass)) {
            usuario1.reiniciaPassword(temporalPass);
            System.out.println("|_ Password de usuario 1 ha sido reiniciada.");
        }
        
        System.out.println("\n==== OBTENIENDO COLORES DE EQUIPO 3 ====");
        //Un método que nos permita concatenar los colores de los Clubes Deportivos.
        System.out.println("|_ Colores Equipo 3: " + equipo3.getTodosColores());
        
        System.out.println("\n==== ACTUALIZANDO NOMBRE EQUIPO 2 ====");
        //Un método que nos permita cambiar el nombre a un club, actualizando su código correspondiente.
        String nuevoCodigo = equipo2.actualizaNombreEquipo("La Florida City", correlativo++, "Handball");
        System.out.println("|_ Se actualizo el nombre del equipo 2, nuevo código: " + nuevoCodigo);
        
        System.out.println("\n==== ACTUALIZANDO PRECIO EQUIPO 1 ====");
        //Una forma que nos actualice los precios según los clubes que estemos suscritos.
        equipo1.actualizaPrecioSuscripcion(20000);
        suscripcion1.agregaEquipos(equipo1, true);
        suscripcion1.agregaEquipos(equipo2, false);
        System.out.println("|_ Ha cambiado el valor de la suscripcion 1 a: " + suscripcion1.getAbonoTotal());
        
        System.out.println("\n==== EQUIPOS EN SUSCRIPCION 3 ====");
        // Una forma que nos permita concatenar el formato de clubes cuando nos suscribimos a ellos.
        System.out.println("|_ Equipos: " + suscripcion3.getEquipos());
        
        System.out.println("\n==== EDAD DEL USUARIO 2 ====");
        //Un método que nos diga la edad de una persona.
        System.out.println("|_ El usuario 2 tiene " + usuario2.getEdad() + " años.");
        
        System.out.println("\n==== DETALLE DE LA SUSCRIPCION 1 ====");
        //Un método que nos detalle una suscripción, entregando toda la información de ella.
        System.out.println(suscripcion1.toString());
        
        
        System.out.println("\n");
        
        
      
    }
    
    
}
