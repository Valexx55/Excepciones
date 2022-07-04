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


    private void escribirPalabraEnFichero(FileWriter f, String palabra) throws IOException {
        f.write(palabra + "\n");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String palabra = null;
       /* try{
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
        /*catch (RuntimeException fallo)
        {
            Log.e("MIAPP", "FALLO RuntimeException", fallo);
        } catch (Throwable fallo)
        {
            Log.e("MIAPP", "FALLO Throwable", fallo);
        }*/

        String nombre_fichero3 = "palabrasde3.txt";
        String nombre_fichero4 = "palabrasde4.txt";
        String nombre_fichero5 = "palabrasde5.txt";
        String nombre_fichero_entrada = "diccionariorae.txt";

        BufferedReader bufferedReader = null;
        File f0 = null;
        File f1 = null;
        File f2 = null;
        FileWriter f3 = null;
        FileWriter f4 = null;
        FileWriter f5 = null;
        FileReader fentradrada = null;
        String linea = null;
        int longitud_linea = 0;
        try {
            //en qué espacios puedo crear un fichero ?
            f0 = new File(getFilesDir().getPath() + "/"+nombre_fichero3);
            f1 = new File(getFilesDir().getPath() + "/"+nombre_fichero4);
            f2 = new File(getFilesDir().getPath() + "/"+nombre_fichero5);

            f0.createNewFile();
            f1.createNewFile();
            f2.createNewFile();

            f3 = new FileWriter(f0);
            f4 = new FileWriter(f1);
            f5 = new FileWriter(f2);


            String ruta_fichero_diccionario = getFilesDir().getPath() + "/" + nombre_fichero_entrada;
            bufferedReader = new BufferedReader(new FileReader(ruta_fichero_diccionario));
            while (null != (linea = bufferedReader.readLine())) {
                //Log.d("MIAPP", "palabra leida =  " + linea);
                longitud_linea = linea.length();
                switch (longitud_linea) {
                    case 3:
                        escribirPalabraEnFichero(f3, linea);
                        break;
                    case 4:
                        escribirPalabraEnFichero(f4, linea);
                        break;
                    case 5:
                        escribirPalabraEnFichero(f5, linea);
                        break;

                }

            }
            //fichero.delete();
            /*    FileReader fileReader = new FileReader(fichero);
                bufferedReader = new BufferedReader(fileReader);
                String linea = bufferedReader.readLine();

                Log.d("MIAPP", "linea leida =  " + linea);*/
            //bufferedReader.close();
                /*int letra = fileReader.read();
                char letra_caracter = (char)letra;
                fileReader.close();
                Log.d("MIAPP", "letra leida =  " + letra + " "+ letra_caracter);
                */


            /*} else
            {
                Log.d("MIAPP", "EL FICHERO " + ruta_privada+" NO EXISTE ");
                fichero.createNewFile();
                Log.d("MIAPP", "FICHERO " + ruta_privada+" CREADO ");
                FileWriter fileWriter = new FileWriter(fichero);
                fileWriter.write("HOLA\n A TODOS");//escapar! preceder del símoblo \ escape a una letra, para que tenga un significado especial
                fileWriter.close();
            }*/
            //fichero.createNewFile();
        } catch (Exception e) {
            Log.e("MIAPP", "FALLO AL CREAR FICHERO", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (f3 != null) {
                    f3.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (f4 != null) {
                    f4.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (f5 != null) {
                    f5.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}