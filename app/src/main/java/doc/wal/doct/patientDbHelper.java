package doc.wal.doct;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class patientDbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "patient.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_DOCTOR_TABLE = "CREATE TABLE " + doctorContract.doctorEntry.TABLE_NAME + " ("
            + doctorContract.doctorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + doctorContract.doctorEntry.COLUMN_PUSHID + " TEXT NOT NULL, "
            + doctorContract.doctorEntry.COLUMN_NAME + " TEXT NOT NULL, "
            + doctorContract.doctorEntry.COLUMN_PHONE_NUMBER + " TEXT NOT NULL, "
            +doctorContract. doctorEntry.COLUMN_EMAIL + " TEXT UNIQUE NOT NULL, "
            + doctorContract.doctorEntry.COLUMN_PASSWORD + " TEXT NOT NULL, "
            + doctorContract.doctorEntry.COLUMN_TITLE + " TEXT, "
            + doctorContract.doctorEntry.COLUMN_INSTITUTE + " TEXT, "
            +doctorContract.doctorEntry.COLUMN_IMAGE + " BLOB, "
            + doctorContract.doctorEntry.COLUMN_INSTITUTE_ADDRESS + " TEXT);";

    public patientDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOCTOR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void createPatientDb(Context context, String username){
        String CREATE_PATIENT_TABLE = "CREATE TABLE " + (doctorContract.patientEntry.tableName(username)) +" ("
                + doctorContract.patientEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  doctorContract.patientEntry.COLUMN_PUSH_ID + " TEXT NOT NULL, "
                +  doctorContract.patientEntry.COLUMN_NAME + " TEXT NOT NULL, "
                +  doctorContract.patientEntry.COLUMN_PHONE_NUMBER + " TEXT NOT NULL, "
                +  doctorContract.patientEntry.COLUMN_EMAIL + " TEXT, "
                +  doctorContract.patientEntry.COLUMN_ADDRESS + " TEXT NOT NULL, "
                + doctorContract.patientEntry.COLUMN_GENDER + " INTEGER NOT NULL DEFAULT 0, "
                +  doctorContract.patientEntry.COLUMN_IMAGE + " BLOB, "
                +  doctorContract.patientEntry.COLUMN_DOB + " TEXT NOT NULL);";

        patientDbHelper helper = new patientDbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(CREATE_PATIENT_TABLE);
    }

}
