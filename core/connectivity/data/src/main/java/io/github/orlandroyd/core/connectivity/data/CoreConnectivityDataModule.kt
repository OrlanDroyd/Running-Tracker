package io.github.orlandroyd.core.connectivity.data

import io.github.orlandroyd.core.connectivity.domain.NodeDiscovery
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreConnectivityDataModule = module {
    singleOf(::WearNodeDiscovery).bind<NodeDiscovery>()
}