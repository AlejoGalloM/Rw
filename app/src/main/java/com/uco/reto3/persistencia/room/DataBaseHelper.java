package com.uco.reto3.persistencia.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.uco.reto3.entidades.Movimiento;
import com.uco.reto3.entidades.Tarifa;
import com.uco.reto3.persistencia.dao.MovimientoDAO;
import com.uco.reto3.persistencia.dao.TarifaDAO;

/**
 * Listado de entities
 */

@Database(entities = {
        Tarifa.class,
        Movimiento.class}, version = DataBaseHelper.VERSION_BASE_DATOS, exportSchema = false)

public abstract class DataBaseHelper extends RoomDatabase {

    public static final int VERSION_BASE_DATOS = 2;
    public static final String NOMBRE_BASE_DATOS = "parqueadero";
    private static DataBaseHelper instace;


    public static DataBaseHelper getSimpleDB(Context context){
        if (instace == null) {
            instace = Room.databaseBuilder(context, DataBaseHelper.class, NOMBRE_BASE_DATOS).build();
        }
        return instace;
    }

    public static DataBaseHelper getDBMainThread(Context context){
        if (instace == null) {
            instace = Room.databaseBuilder(context, DataBaseHelper.class, NOMBRE_BASE_DATOS).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instace;
    }


    /**
     * Listado de DAO
     */

    public abstract TarifaDAO getTarifaDAO();

    public abstract MovimientoDAO getMovimientoDAO();

}
