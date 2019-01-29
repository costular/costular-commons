package com.costular.common.data.repository

import io.reactivex.Completable
import io.reactivex.Single

interface Repository<T> {

    fun add(input: T): Completable

    fun update(input: T): Completable

    fun remove(input: T): Completable

    fun queryAll(): Single<List<T>>

}