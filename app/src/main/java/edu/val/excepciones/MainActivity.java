package edu.val.excepciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    //CLASIFICACIÓN DE EXECEPCIONES
    //PADRE DE TODAS LAS EXCEPCICIONES --> THROWABLE
    //EXCEPCIONES DEL SISTEMA --> ERROR (ENTORNO, JAVA)
    //EXCEPCIONES DE MI APP --> EXCEPTIONS
    //DENTRO DE EXCEPTIONS, TENGO 2 TIPOS
        //RUNTIME O UNCHECKED EXCEPTIONS
            //JAVA NO ME OBLIGA A TRATARLAS (pej: NullPointerException)
        //CHECKED EXCEPTIONS
            //JAVA SÍ ME OLIGA A TRATARLAS (pej : IOException)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String palabra = null;
        try{
            int longitud = palabra.length();
            //este tipo de excepccion es de las tipo RunTimeException
            Log.d("MIAPP", "La palabra tiene una longuitud de " + longitud);
        } catch (ArrayIndexOutOfBoundsException fallo)
        {
            Log.e("MIAPP", "FALLO ArrayIndexOutOfBoundsException", fallo);
        } /*catch (NullPointerException fallo)
        {
            Log.e("MIAPP", "FALLO NullPointerException", fallo);
        }*/
        catch (RuntimeException fallo)
        {
            Log.e("MIAPP", "FALLO RuntimeException", fallo);
        } catch (Throwable fallo)
        {
            Log.e("MIAPP", "FALLO Throwable", fallo);
        }

        BufferedReader bufferedReader = null;
        try {
            //en qué espacios puedo crear un fichero ?
            String ruta_privada = getFilesDir().getPath()+"/basedatos.txt";
            File fichero = new File(ruta_privada);
            if (fichero.exists())
            {
                Log.d("MIAPP", "EL FICHERO " + ruta_privada+" EXISTE ");
                if (fichero.isFile())
                {
                    Log.d("MIAPP", "EL FICHERO " + ruta_privada+" es un ARCHIVO ");
                }
                //fichero.delete();
                FileReader fileReader = new FileReader(fichero);
                bufferedReader = new BufferedReader(fileReader);
                String linea = bufferedReader.readLine();

                Log.d("MIAPP", "linea leida =  " + linea);
                //bufferedReader.close();
                /*int letra = fileReader.read();
                char letra_caracter = (char)letra;
                fileReader.close();
                Log.d("MIAPP", "letra leida =  " + letra + " "+ letra_caracter);
                */


            } else
            {
                Log.d("MIAPP", "EL FICHERO " + ruta_privada+" NO EXISTE ");
                fichero.createNewFile();
                Log.d("MIAPP", "FICHERO " + ruta_privada+" CREADO ");
                FileWriter fileWriter = new FileWriter(fichero);
                fileWriter.write("HOLA\n A TODOS");//escapar! preceder del símoblo \ escape a una letra, para que tenga un significado especial
                fileWriter.close();
            }
            //fichero.createNewFile();
        } catch (Exception e) {
            Log.e("MIAPP", "FALLO AL CREAR FICHERO", e);
        }finally {
            try {
                if (bufferedReader!=null) {
                  bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}