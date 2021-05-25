package com.tylerlyczak.vaporstream_codetest

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 *  PersonApplication
 *      Defines an application for Activities to use to get the instance of the database
 *      and repository
 */
class PersonApplication : Application() {
    val database by lazy { PersonDatabase.getInstance(this) }
    val repository by lazy { PersonRepository(database.personDao()) }
}