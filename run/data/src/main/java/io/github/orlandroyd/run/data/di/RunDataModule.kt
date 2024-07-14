package io.github.orlandroyd.run.data.di

import io.github.orlandroyd.core.domain.run.SyncRunScheduler
import io.github.orlandroyd.run.data.CreateRunWorker
import io.github.orlandroyd.run.data.DeleteRunWorker
import io.github.orlandroyd.run.data.FetchRunsWorker
import io.github.orlandroyd.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}