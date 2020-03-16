
/**
 * Write a description of class Agenda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Vector;
import javax.swing.JOptionPane;
public class Agenda
{
    private Vector<Persona> libreta=new Vector<Persona>(1,1);

    //constructor tomando el tamanio inicial y de donde se obtendran datos para generar
    public Agenda(int tamI,DataBase db){
        int i=1;
        do{
            Persona per=new Persona(db);
            libreta.add(per);
            i++;
        }while(i<=tamI);
    }

    public Agenda(Vector<Persona> vecP){
        libreta.addAll(vecP);
    }
    //obtener vector
    public Vector<Persona> getlibreta(){
        return this.libreta;
    }

    //agregar mas personas a la agenda por grandes lotes y aleatorio
    public void agregarContactos(int tam,DataBase db){
        int i=1;
        do{
            Persona per=new Persona(db);
            libreta.add(per);
            i++;
        }while(i<=tam);
    }

    //***buscar con el primer caso identico pedido
    //buscar al primero con nombre x
    public Persona buscaPrimeroConNombre(String nomb){
        Persona pr=null;
        int i=0;
        do{
            if(libreta.get(i).getNombre().equalsIgnoreCase(nomb))
                pr=libreta.get(i);
            i++;
        }while(i<libreta.size()&&pr==null);
        return pr;
    }

    //buscar al primero con apellido x
    public Persona buscarPrimeroConApellido(String ape){
        Persona pr=null;
        int i=0;
        do{
            if(libreta.get(i).getApellido().equalsIgnoreCase(ape))
                pr=libreta.get(i);
            i++;
        }while(i<libreta.size()&&pr==null);
        return pr;
    }

    //buscar al primero con ciudad x
    public Persona buscarPrimeroConCiudad(String ciud){
        Persona pr=null;
        int i=0;
        do{
            if(libreta.get(i).getCiudad().equalsIgnoreCase(ciud))
                pr=libreta.get(i);
            i++;
        }while(i<libreta.size()&&pr==null);
        return pr;
    }

    //buscar por el telefono
    public Persona buscarTelefono(String tel){
        Persona pr=null;
        int i=0;
        do{
            if(libreta.get(i).getTelefono().equalsIgnoreCase(tel))
                pr=libreta.get(i);
            i++;
        }while(i<libreta.size()&&pr==null);
        return pr;
    }
    
    ////**buscar por todos los caso identicos
    //buscar por nombre idenetico
    public Agenda buscarTodosConNombre(String nomb){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        for(int i=0;i<libreta.size();i++){
            if(libreta.get(i).getNombre().equalsIgnoreCase(nomb))
                pers.add(libreta.get(i));
        }
        Agenda ag=new Agenda(pers);
        return ag;
    }

    //buscar por apellido identico
    public Agenda buscarTodosConApellido(String ape){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        for(int i=0;i<libreta.size();i++){
            if(libreta.get(i).getApellido().equalsIgnoreCase(ape))
                pers.add(libreta.get(i));
        }
        Agenda ag=new Agenda(pers);
        return ag;
    }

    //buscar por ciudad identica
    public Agenda buscarTodosConCiudad(String ciud){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        for(int i=0;i<libreta.size();i++){
            if(libreta.get(i).getCiudad().equalsIgnoreCase(ciud))
                pers.add(libreta.get(i));
        }
        Agenda ag=new Agenda(pers);
        return ag;
    }

    //buscar por genero igual
    public Agenda buscarTodosConGenero(String sx){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        sx=DeterminarSex(sx);
        for(int i=0;i<libreta.size();i++){
            if(libreta.get(i).getSexo().equals(sx))
                pers.add(libreta.get(i));
        }
        Agenda ag=new Agenda(pers);
        return ag;
    }
    //comparar paradeterminar un tipo exacto y evitar error lexico
    private String DeterminarSex(String gen){
        String sx="hombre";
        if(gen.equalsIgnoreCase("mujer")||gen.equalsIgnoreCase("fenenino")||gen.equalsIgnoreCase("f")){
            sx="mujer";
        }
        return sx;
    }

    //buscar por lada igual
    public Agenda buscarTodosConLada(String lada){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        for(int i=0;i<libreta.size();i++){
            String cel=libreta.get(i).getTelefono();
            if(cel.charAt(0)==lada.charAt(0)&&cel.charAt(1)==lada.charAt(1)&&cel.charAt(2)==lada.charAt(2))
                pers.add(libreta.get(i));
        }
        Agenda ag=new Agenda(pers);
        return ag;
    }

    //buscar mayores de edad
    public Agenda buscarMayoresDeEdad(){
        Agenda ag=buscarTodosEdad(18,">=");
        return ag;
    }
    
    //buscar por edad > = <
    /** edad a comparar / signo con el que comparar(<,>,=,>=,<=)*/
    public Agenda buscarTodosEdad(int ed,String comp){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        switch(comp){
            case ">=":
                if(buscarIgualEdad(ed,libreta)!=null)
                    pers.addAll(buscarIgualEdad(ed,libreta));
                if(buscarMayorEdad(ed,libreta)!=null)
                    pers.addAll(buscarMayorEdad(ed,libreta));
            break;
            case "<=":
                if(buscarIgualEdad(ed,libreta)!=null)
                    pers.addAll(buscarIgualEdad(ed,libreta));
                if(buscarMenorEdad(ed,libreta)!=null)
                    pers.addAll(buscarMenorEdad(ed,libreta));
            break;
            case ">":
                if(buscarMayorEdad(ed,libreta)!=null)
                    pers.addAll(buscarMenorEdad(ed,libreta));
            break;
            case "<":
                if(buscarMenorEdad(ed,libreta)!=null)
                    pers.addAll(buscarMenorEdad(ed,libreta));
            break;
            case "=":
                if(buscarIgualEdad(ed,libreta)!=null)
                    pers.addAll(buscarIgualEdad(ed,libreta));
            break;
        }
        Agenda ag=new Agenda(pers);
        return ag;
    }
    //edad igual a..
    private Vector<Persona> buscarIgualEdad(int ed,Vector<Persona> vect){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        for(int i=0;i<vect.size();i++){
            if(vect.get(i).getEdad()==ed)
                pers.add(libreta.get(i));
        }
        return pers;
    }
    //edad menor a...
    private Vector<Persona> buscarMenorEdad(int ed,Vector<Persona> vect){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        for(int i=0;i<vect.size();i++){
            if(vect.get(i).getEdad()<ed)
                pers.add(libreta.get(i));
        }
        return pers;
    }
    //edad mayor a....
    private Vector<Persona> buscarMayorEdad(int ed,Vector<Persona> vect){
        Vector<Persona> pers=new Vector<Persona>(1,1);
        for(int i=0;i<vect.size();i++){
            if(vect.get(i).getEdad()>ed)
                pers.add(libreta.get(i));
        }
        return pers;
    }
    
    //toString
    public String toString(){
        String text="";
        for(int i=0;i<libreta.size();i++)
            text=text+"\n"+libreta.get(i).toString();
        return text;
    }
}
