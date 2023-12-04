
package Decathlon.dto;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String genero;
    private String dni;
    private String correo;
    
    private String deportesPreferidos;
    private String tallaRopa;
    private String tallaPie;
    private int edad;
    private boolean terminos;
    
    
    public Cliente(String nombre, String apellidos, String genero, String dni, String correo, String deportesPreferidos, String tallaRopa, String tallaPie, int edad, boolean terminos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.dni = dni;
        this.correo = correo;
        this.deportesPreferidos = deportesPreferidos;
        this.tallaRopa = tallaRopa;
        this.tallaPie = tallaPie;
        this.edad = edad;
        this.terminos = terminos;
    }
    
    
 
    public String[] toArrayStrings(){
        String[] s = new String[10];
        
        s[0] = nombre;
        s[1] = apellidos;
        s[2] = edad + "";
        s[3] = genero;
        s[4] = dni;
        s[5] = correo;
        s[6] = deportesPreferidos;
        s[7] = tallaRopa;
        s[8] = tallaPie;
        if(terminos){
            s[9] = "Acepta términos y condiciones";
        } else{
            s[9] = "No acepta términos y condiciones";

        }
        
        return s;
    }

    
    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDeportesPreferidos() {
        return deportesPreferidos;
    }

    public void setDeportesPreferidos(String deportesPreferidos) {
        this.deportesPreferidos = deportesPreferidos;
    }

    public String getTallaRopa() {
        return tallaRopa;
    }

    public void setTallaRopa(String tallaRopa) {
        this.tallaRopa = tallaRopa;
    }

    public String getTallaPie() {
        return tallaPie;
    }

    public void setTallaPie(String tallaPie) {
        this.tallaPie = tallaPie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isTerminos() {
        return terminos;
    }

    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }
    
    
}
