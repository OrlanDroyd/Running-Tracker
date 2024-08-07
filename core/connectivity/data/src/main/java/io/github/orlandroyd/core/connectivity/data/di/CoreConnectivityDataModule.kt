package io.github.orlandroyd.core.connectivity.data.di

import io.github.orlandroyd.core.connectivity.data.WearNodeDiscovery
import io.github.orlandroyd.core.connectivity.data.messaging.WearMessagingClient
import io.github.orlandroyd.core.connectivity.domain.NodeDiscovery
import io.github.orlandroyd.core.connectivity.domain.messaging.MessagingClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreConnectivityDataModule = module {
    singleOf(::WearMessagingClient).bind<MessagingClient>()
    singleOf(::WearNodeDiscovery).bind<NodeDiscovery>()
}