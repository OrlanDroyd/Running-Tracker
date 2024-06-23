package io.github.orlandroyd.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.orlandroyd.core.database.dao.RunDao
import io.github.orlandroyd.core.database.entity.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
}