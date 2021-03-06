package com.maro.githubuser.deps.component

import androidx.multidex.MultiDexApplication
import com.maro.githubuser.BaseApp
import com.maro.githubuser.deps.module.ActivityModule
import com.maro.githubuser.deps.module.AppModule
import com.maro.githubuser.deps.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    ActivityModule::class,
    AndroidInjectionModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: MultiDexApplication): Builder
    }

    fun inject(application: BaseApp)

}

