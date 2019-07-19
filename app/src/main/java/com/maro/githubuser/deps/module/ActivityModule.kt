package com.maro.githubuser.deps.module

import com.maro.githubuser.deps.ActivityScope
import com.maro.githubuser.ui.page.search.SearchActivity
import com.maro.githubuser.ui.page.search.SearchActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */


@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules =[SearchActivityModule::class,AppModule::class, NetworkModule::class])
    abstract fun searchActivity(): SearchActivity



}