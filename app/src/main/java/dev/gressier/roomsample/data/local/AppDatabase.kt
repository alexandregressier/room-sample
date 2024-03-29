package dev.gressier.roomsample.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.gressier.roomsample.data.local.daos.MyEntityDao
import dev.gressier.roomsample.data.local.entities.MyEntity

@Database(entities = [MyEntity::class], version = 1)
@TypeConverters(UUIDTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun myEntityDao(): MyEntityDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .build()
                    .also { instance = it }
            }
    }
}