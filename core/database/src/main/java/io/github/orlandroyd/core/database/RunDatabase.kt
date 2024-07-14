package io.github.orlandroyd.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.orlandroyd.core.database.dao.RunDao
import io.github.orlandroyd.core.database.dao.RunPendingSyncDao
import io.github.orlandroyd.core.database.entity.DeletedRunSyncEntity
import io.github.orlandroyd.core.database.entity.RunEntity
import io.github.orlandroyd.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}