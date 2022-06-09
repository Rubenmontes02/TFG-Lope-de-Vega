package com.lopedevega.ProyectoFinalLopedeVega;

public class DbInfo {

    //Añadimos el nombre de la tabla
    public static final String NOMBRE_TABLA = "alumnos";

    //Añadimos los datos de la tabla
    public static final String CAMPO_DNI = "dni";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDOS = "apellidos";
    public static final String CAMPO_SEXO = "sexo";
    public static final String CAMPO_NACIONALIDAD = "nacionalidad";
    public static final String CAMPO_NACIMIENTO = "nacimiento";
    public static final String CAMPO_PROFESION = "profesion";
    public static final String CAMPO_DOMICILIO = "domicilio";
    public static final String CAMPO_LOCALIDAD = "localidad";
    public static final String CAMPO_PROVINCIA = "provincia";
    public static final String CAMPO_PAIS = "pais";
    public static final String CAMPO_CODIGO_POSTAL = "codigo_postal";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_CORREO = "correo";
    public static final String CAMPO_NOMBRE_PADRE = "nombre_padre";
    public static final String CAMPO_APELLIDOS_PADRE = "apellidos_padre";
    public static final String CAMPO_CORREO_PADRE = "correo_padre";
    public static final String CAMPO_DNI_PADRE = "dni_padre";
    public static final String CAMPO_NOMBRE_MADRE = "nombre_madre";
    public static final String CAMPO_APELLIDOS_MADRE = "apellidos_madre";
    public static final String CAMPO_CORREO_MADRE = "correo_madre";
    public static final String CAMPO_DNI_MADRE = "dni_madre";
    public static final String CAMPO_ULTIMOS_ESTUDIOS = "ultimos_estudios";
    public static final String CAMPO_CURSOA = "cursoEA";
    public static final String CAMPO_CENTROA = "centroEA";
    public static final String CAMPO_LOCALIDADEA = "localidadEA";


    private DbInfo(){

    }


    public static final String SQL_CREATETABLE =
            "CREATE TABLE " + DbInfo.NOMBRE_TABLA + " (" +
                    DbInfo.CAMPO_DNI + " TEXT PRIMARY KEY," +
                    DbInfo.CAMPO_NOMBRE + " TEXT," +
                    DbInfo.CAMPO_APELLIDOS + " TEXT," +
                    DbInfo.CAMPO_SEXO + " TEXT," +
                    DbInfo.CAMPO_NACIONALIDAD + " TEXT," +
                    DbInfo.CAMPO_NACIMIENTO + " TEXT," +
                    DbInfo.CAMPO_PROFESION + " TEXT," +
                    DbInfo.CAMPO_DOMICILIO + " TEXT," +
                    DbInfo.CAMPO_LOCALIDAD + " TEXT," +
                    DbInfo.CAMPO_PROVINCIA + " TEXT," +
                    DbInfo.CAMPO_PAIS + " TEXT," +
                    DbInfo.CAMPO_CODIGO_POSTAL + " TEXT," +
                    DbInfo.CAMPO_TELEFONO + " TEXT," +
                    DbInfo.CAMPO_CORREO + " TEXT," +
                    DbInfo.CAMPO_NOMBRE_PADRE + " TEXT," +
                    DbInfo.CAMPO_APELLIDOS_PADRE + " TEXT," +
                    DbInfo.CAMPO_CORREO_PADRE + " TEXT," +
                    DbInfo.CAMPO_DNI_PADRE + " TEXT," +
                    DbInfo.CAMPO_NOMBRE_MADRE + " TEXT," +
                    DbInfo.CAMPO_APELLIDOS_MADRE + " TEXT," +
                    DbInfo.CAMPO_CORREO_MADRE + " TEXT," +
                    DbInfo.CAMPO_DNI_MADRE + " TEXT," +
                    DbInfo.CAMPO_ULTIMOS_ESTUDIOS + " TEXT," +
                    DbInfo.CAMPO_CURSOA + " TEXT," +
                    DbInfo.CAMPO_CENTROA + " TEXT," +
                    DbInfo.CAMPO_LOCALIDADEA + " TEXT)";

    public static final String SQL_DELETETABLE =
            "DROP TABLE IF EXISTS " + DbInfo.NOMBRE_TABLA;

}
