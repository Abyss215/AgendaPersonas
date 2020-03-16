
/**
 * Write a description of class prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeerAgenda
{
    public static void main(String [] args){
        DataBase db=new DataBase();
        int x=100;
        Agenda ag=new Agenda(x,db);
        //panel opcion
        System.out.println(db.toString());
//        System.out.println(ag.toString());
  //      System.out.println(ag.buscarTodosConCiudad("chernobyl").buscarMayoresDeEdad().toString());
        
    }
}
