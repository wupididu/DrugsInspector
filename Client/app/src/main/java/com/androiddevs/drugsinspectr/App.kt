package com.androiddevs.drugsinspectr

import android.app.Application
import com.androiddevs.drugsinspectr.Client.Client
import com.androiddevs.drugsinspectr.Client.ClientRepository
import com.androiddevs.drugsinspectr.db.DrugDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(androidXModule(this@App))
        bind() from singleton { DrugDatabase(instance()) }
        bind() from singleton { Client() }
        bind() from singleton { DrugRepository(instance()) }
        bind() from singleton { ClientRepository(instance()) }
        bind() from provider {
            DrugsViewModelFactory(instance(), instance())
        }
    }
}
