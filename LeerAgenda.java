
/**
 * clase prueba donde se controla(controlara) las acciones de las demas clases.
 * 
 * @Criss_215
 */
import java.util.Scanner;
public class LeerAgenda
{
    public static void main(String [] args){
        DataBase db=new DataBase();
        Scanner sc=new Scanner(System.in);
        System.out.println("\nquiere ver los datos con los q se generaran las personas s/n??");
        String sn=sc.nextLine();
        if(sn.equalsIgnoreCase("s"))
            System.out.println(db.toString());
        System.out.println("\nde que tamanio quiere su agenda??");
        int x=sc.nextInt();
        Agenda ag=new Agenda(x,db);
        System.out.println(ag.toString());
        //panel opcion
        System.out.println("\nde que tipo quiere realizar su busqueda, si incluye diferentes parametros separelos con coma (,)");
        String resp=sc.nextLine();
        System.out.println("\n1.-nombre\n2.-apellido\n3.-ciudad\n4.-edad\n5.-genero\n6.-lada telefono\n");
        resp=sc.nextLine();
        Agenda aux=ag;
        Agenda bus=null;
        if(resp.contains("1")){
            System.out.println("ingrese el nombre de parametro");
            String nom=sc.nextLine();
            bus=aux.buscarTodosConNombre(nom);
            aux=bus;
        }        
        if(resp.contains("2")){
            System.out.println("ingrese el apellido de parametro");
            String ape=sc.nextLine();
            bus=aux.buscarTodosConApellido(ape);
            aux=bus;
        }
        if(resp.contains("3")){
            System.out.println("ingrese el ciudad de parametro");
            String ciud=sc.nextLine();
            bus=aux.buscarTodosConCiudad(ciud);
            aux=bus;
        }
        if(resp.contains("4")){
            System.out.println("ingrese el edad de parametro");
            int edad=sc.nextInt();
            String sig=sc.nextLine();
            System.out.println("ingrese el signo a comparar edad de parametro(<=,>=,<,>,=)");
            sig=sc.nextLine();
            bus=aux.buscarTodosEdad(edad,sig);
            aux=bus;
        }
        if(resp.contains("5")){
            System.out.println("ingrese el genero de parametro");
            String gen=sc.nextLine();
            bus=aux.buscarTodosConGenero(gen);
            aux=bus;
        }
        if(resp.contains("6")){
            System.out.println("ingrese la lada de parametro");
            String cel=sc.nextLine();
            bus=aux.buscarTodosConLada(cel);
            aux=bus;
        }
        if(aux!=ag){
            if(bus!=null){
                System.out.println(bus.toString());
            }else{ 
                System.out.println("no se encontro nada");}
        }else System.out.println("debe ingresar un parametro para buscar");
    }
}
