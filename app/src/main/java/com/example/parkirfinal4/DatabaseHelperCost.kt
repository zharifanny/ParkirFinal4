import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelperCost(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "CostsDB"
        private const val TABLE_COSTS = "costs"
        private const val KEY_ID = "id"
        private const val KEY_TOTAL_COST = "total_cost"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_COSTS ($KEY_ID INTEGER PRIMARY KEY, $KEY_TOTAL_COST INTEGER)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_COSTS")
        onCreate(db)
    }

    fun addCost(totalCost: Int): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_TOTAL_COST, totalCost)
        }
        val id = db.insert(TABLE_COSTS, null, values)
        db.close()
        return id
    }

    fun getAllCosts(): List<Int> {
        val costsList = mutableListOf<Int>()
        val selectQuery = "SELECT $KEY_TOTAL_COST FROM $TABLE_COSTS"

        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)
            cursor?.use {
                while (it.moveToNext()) {
                    val cost = it.getInt(it.getColumnIndex(KEY_TOTAL_COST))
                    costsList.add(cost)
                }
            }
        } catch (e: Exception) {
            // Handle exceptions, log or report the error
            e.printStackTrace()
        } finally {
            cursor?.close()
            db.close()
        }

        return costsList
    }

    fun deleteCost(id: Int): Int {
        val db = this.writableDatabase
        val affectedRows = db.delete(TABLE_COSTS, "$KEY_ID=?", arrayOf(id.toString()))
        db.close()
        return affectedRows
    }
}
