
/**
 * Base de datos de nombres, apellidos y ciudades para generar personas aleatoriamente
 */
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Vector;
import java.util.ArrayList;
import java.lang.Math;
public class DataBase
{
    private Vector<String> nombres=new Vector<String>(1,1);
    private Vector<String> apellidos=new Vector<String>(1,1);
    private Vector<String> ciudades=new Vector<String>(1,1);
    
    //constructor
    public DataBase(){
        try{
            File data = new File("../AgendaPersonas/Datos"); 
            if(!data.exists()){
                data.mkdirs();
            }
        }catch(Exception e){e.printStackTrace();}
        nombres=asignarDT("Datos/nombres.txt");
        apellidos=asignarDT("Datos/apellidos.txt");
        ciudades=asignarDT("Datos/ciudades.txt");
    }
    
    //obtener un dato aleatorio de la base de datos
    public String getNombreR(){
        String nom="";
        try{nom=nombres.get((int)(Math.random()*(nombres.capacity())));
        }catch(Exception e){e.printStackTrace();}
        return nom;
    }
    public String getApellidoR(){
        String ape="";
        try{ape=apellidos.get((int)(Math.random()*(apellidos.size())));
        }catch(Exception e){e.printStackTrace();}
        return ape;
    }
    public String getCiudadR(){
        String ciud="";
        try{ciud=ciudades.get((int)(Math.random()*(ciudades.capacity())));
        }catch(Exception e){e.printStackTrace();}
        return ciud;
    }
    
    ///agregar nuevos datos para generar personas
    public void agregarNombre(String nom){
        nombres.add(nom);
        guardarDato("../AgendaPersonas/Datos/nombres.txt",nom);
    }
    
    public void agregarApellidos(String ape){
        apellidos.add(ape);
        guardarDato("../AgendaPersonas/Datos/apellidos.txt",ape);
    }
    
    public void agregarCiudades(String cd){
        ciudades.add(cd);
        guardarDato("../AgendaPersonas/Datos/ciudades.txt",cd);
    }
    
    ///metodos para obtener datos y asignarlos a los vectores
    private Vector asignarDT(String ruta){
        Vector<String> vec = new Vector<String>(1,1);
        File data = new File(ruta); 
        FileReader leerArchivo;
        try{
            if(!data.exists()){
                data.createNewFile();
            }else{
                leerArchivo = new FileReader(ruta); 
                BufferedReader textoArchivo = new BufferedReader(leerArchivo);
                String cadena = textoArchivo.readLine();
                if (cadena!=null) {
                   String [] cad=cadena.split(",");
                   for(int i=0;i<cad.length&&cad[i]!=null;i++){
                        vec.add(cad[i]);
                    }
                }
            }
            return vec;
        }catch(Exception e){
            e.printStackTrace();
            return vec;
        }
    }
    //asignar nuevos datos al repositorio    
    private void guardarDato(String ruta,String dato){
        File data = new File(ruta); 
        FileWriter dataG;
        FileReader leerArchivo;
        try{
            if(!data.exists()){
                data.createNewFile();
            }
            //recuperar datos para sobreescribir
            leerArchivo = new FileReader(data); 
            BufferedReader textoArchivo = new BufferedReader(leerArchivo);
            String cadena = textoArchivo.readLine();
            //guardar datos
            if(cadena!=null)dato=cadena+","+dato;
            
            dataG = new FileWriter(data);
            BufferedWriter guardar = new BufferedWriter(dataG);
            guardar.write(dato);
            guardar.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String toString(){
        String text=nombres.toString()+"\n\n"+apellidos.toString()+"\n\n"+ciudades.toString();
        return text;
    }
}
