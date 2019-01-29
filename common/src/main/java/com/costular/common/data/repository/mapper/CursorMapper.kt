package com.costular.common.data.repository.mapper

import android.database.Cursor

interface CursorMapper<out T> {
    fun transform(cursor: Cursor): T
}