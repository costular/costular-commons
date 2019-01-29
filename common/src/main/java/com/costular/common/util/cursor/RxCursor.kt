package com.costular.common.util.cursor

import android.database.Cursor
import com.costular.common.data.repository.mapper.CursorMapper
import io.reactivex.Observable

class RxCursor<T> private constructor(private val cursorObservable: Observable<Cursor>) {

    lateinit var observable: Observable<T>

    private fun <T> applyMapper(cursorMapper: CursorMapper<T>): Observable<T> {
        return cursorObservable.map { cursorMapper.transform(it) }
    }

    companion object {
        fun <T> from(cursor: Cursor, cursorMapper: CursorMapper<T>): RxCursor<T> {
            val cursorObservable = Observable.create<Cursor> { emitter ->
                cursor.use {
                    it.moveToFirst()

                    do {
                        emitter.onNext(cursor)
                    } while (cursor.moveToNext() && !emitter.isDisposed)
                }

                if (!emitter.isDisposed) {
                    emitter.onComplete()
                }
            }
            return RxCursor<T>(cursorObservable).apply {
                observable = applyMapper(cursorMapper)
            }
        }
    }

}