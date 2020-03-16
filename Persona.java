/**
 * Clase persona
 */

import java.lang.Math;
public class Persona
{
    private String nom;
    private String ape;
    private String cel;
    private String sexo;
    private String ciud;
    private int edad;
    
    //constructores
    public Persona(String nom,String ape, String ciud, String cel, boolean sex, int edad){//datos exactos
        this.nom=nom;
        this.ape=ape;
        this.ciud=ciud;
        this.cel=cel;
        this.sexo=asignarSex(sex);
        this.edad=edad;
    }
    
    public Persona(DataBase db){//datos randoms sacados de una base de datos
        String nom=db.getNombreR();
        String ape=db.getApellidoR();
        String ciud=db.getCiudadR();
        String cel="";
        for(int i=1;i<=10;i++)
            cel+=(int)(Math.random()*(10));
        boolean sex=false;
        if((int)(Math.random()*(2))==0)
            sex=true;
        int edad=((int)(Math.random()*(93)+7));
        this.nom=nom;
        this.ape=ape;
        this.ciud=ciud;
        this.cel=cel;
        this.sexo=asignarSex(sex);
        this.edad=edad;
    }
    
    //sets && gets
    //nombre
    public void setNombre(String nom){
        this.nom=nom;
    }
    public String getNombre(){
        return nom;
    }
    //apellido
    public void setApellido(String ape){
        this.ape=ape;
    }
    public String getApellido(){
        return ape;
    }
    //ciudad
    public void setCiudad(String ciud){
        this.ciud=ciud;
    }
    public String getCiudad(){
        return ciud;
    }
    //sexo
    public void setSexo(boolean s){
        this.sexo=asignarSex(s);
    }
    public String asignarSex(boolean s){
        if(s)
        return "mujer";
        else
        return "hombre";
    }
    public String getSexo(){
        return sexo;
    }
    //edad
    public void setEdad(int ed){
        this.edad=ed;
    }
    public int getEdad(){
        return edad;
    }
    //telefono
    public void setTelefono(String cel){
        this.cel=cel;
    }
    public String getTelefono(){
        return cel;
    }
    
    //toString
    public String toString(){
        return "["+nom+"] "+" ["+ape+"] "+" ["+ciud+"] "+" ["+sexo+"]" +" ["+edad+"]" +" ["+cel+"]";
    }
}
