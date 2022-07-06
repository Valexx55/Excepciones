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

    private FileWriter crearFicheroEnModoEscritura (String ruta) throws IOException {
        FileWriter fileWriter = null;
        File file = null;

            //creo el fichero si no existe y lo abro en modo escritura con FileWriter
            file = new File(ruta);
            if (!file.exists())
            {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);

        return fileWriter;
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
            //preparo los ficheros para escribir en ellos
            f3 = crearFicheroEnModoEscritura(getFilesDir().getPath() + "/"+nombre_fichero3);
            f4 = crearFicheroEnModoEscritura(getFilesDir().getPath() + "/"+nombre_fichero4);
            f5 = crearFicheroEnModoEscritura(getFilesDir().getPath() + "/"+nombre_fichero5);

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