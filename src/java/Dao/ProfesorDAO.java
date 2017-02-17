/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import vo.Profesor;

/**
 *
 * @author Labing
 */
public class ProfesorDAO {
    private RandomAccessFile profesorDB;
    
    public ProfesorDAO() throws FileNotFoundException{
      this.profesorDB = new RandomAccessFile("profesor.txt", "rw");
    }
    public boolean insertar(Profesor profesor) throws IOException{
        long posicionMemoria = this.profesorDB.length();
        this.profesorDB.seek(posicionMemoria);
        this.profesorDB.writeInt(profesor.getId()); //id
    
        for(int i = 0;i < 10; i++){
          char letra = profesor.getNombre()[i];
          this.profesorDB.writeChar(letra);
        }
        
        for(int i = 0;i < 10; i++){
          char letra = profesor.getApellido()[i];
          this.profesorDB.writeChar(letra);
        }
      
        this.profesorDB.writeInt(profesor.getExt());
        
        return true;
    }
    
    public boolean actualizar(Profesor profesor){
    
      return false;
    }
    
    public boolean borrar(Profesor profesor){
      return false;
    }
    
    public ArrayList<Profesor> listarTodo() throws IOException{
       for(long i = 0; i< this.profesorDB.length();i= i + 48){
           this.profesorDB.seek(i);
           System.out.println(this.profesorDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.profesorDB.readChar());
           }
           System.out.println("");
       }
       return null;
    }
    
    public void destructor() throws IOException{
      this.profesorDB.close();
    }
    
    
    
}
