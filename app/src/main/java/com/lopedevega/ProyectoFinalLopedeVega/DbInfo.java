package com.lopedevega.ProyectoFinalLopedeVega;

public class DbInfo {

    //Añadimos el nombre de la tabla
    public static final String NOMBRE_TABLA = "alumnos";

    //Añadimos los datos de la tabla
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CLAVE = "clave";


    private DbInfo(){

    }

    public static final String COMMA_SEP = ",";


    public static final String SQL_CREATETABLE =
            "CREATE TABLE " + DbInfo.NOMBRE_TABLA + " (" +
                    DbInfo.CAMPO_ID + " INTEGER PRIMARY KEY," +
                    DbInfo.CAMPO_NOMBRE + " TEXT," +
                    DbInfo.CAMPO_CLAVE + " TEXT)";

    public static final String SQL_DELETETABLE =
            "DROP TABLE IF EXISTS " + DbInfo.NOMBRE_TABLA;

}
