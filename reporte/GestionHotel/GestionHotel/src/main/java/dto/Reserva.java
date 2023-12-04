
package dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
    String sala;
    Persona persona;
    Date fechaEvento;
    String tipoEvento;
    Integer numPersonas;
    String tipoCocina;
    
    //Solo para congresos
    Integer numJornadas;
    Integer numHabitaciones;
    String tipoHabitaciones;
    
    
    
    //Constructor Banqute y Jornada

    public Reserva(String sala, Persona persona, Date fechaEvento, String tipoEvento, Integer numPersonas, String tipoCocina) {
        this.sala = sala;
        this.persona = persona;
        this.fechaEvento = fechaEvento;
        this.tipoEvento = tipoEvento;
        this.numPersonas = numPersonas;
        this.tipoCocina = tipoCocina;
        this.numJornadas = 1;
    }
    
    //Constructor Congreso

    public Reserva(String sala, Persona persona, Date fechaEvento, String tipoEvento, Integer numPersonas, String tipoCocina, Integer numJornadas, Integer numHabitaciones, String tipoHabitaciones) {
        this.sala = sala;
        this.persona = persona;
        this.fechaEvento = fechaEvento;
        this.tipoEvento = tipoEvento;
        this.numPersonas = numPersonas;
        this.tipoCocina = tipoCocina;
        this.numJornadas = numJornadas;
        this.numHabitaciones = numHabitaciones;
        this.tipoHabitaciones = tipoHabitaciones;
    }
    
    public String[] toArrayStrings(){
        String[] s = new String[10];
        
        s[0] = tipoEvento;
        s[1] = sala;
        s[2] = persona.nombre;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        s[3] = sdf.format(fechaEvento);
        s[4] = numJornadas + "";
       
        
        return s;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public Integer getNumJornadas() {
        return numJornadas;
    }

    public void setNumJornadas(Integer numJornadas) {
        this.numJornadas = numJornadas;
    }

    public Integer getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(Integer numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getTipoHabitaciones() {
        return tipoHabitaciones;
    }

    public void setTipoHabitaciones(String tipoHabitaciones) {
        this.tipoHabitaciones = tipoHabitaciones;
    }
    
    
    
    

}
