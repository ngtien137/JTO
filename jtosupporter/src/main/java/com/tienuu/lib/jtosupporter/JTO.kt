package com.tienuu.lib.jtosupporter

import android.database.Cursor
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Field

object JTO {
    inline fun <reified T> JSONArray.toList() : MutableList<T>{
        val result = ArrayList<T>()
        for (i in 0 until length()){
            val jsonObject = getJSONObject(i)
            result.add(getObjectData(jsonObject))
        }
        return result
    }

    inline fun <reified T:Any> getObjectData(jsonObject: JSONObject): T {
        val t = T::class.java.newInstance()
        val fields = t.javaClass.declaredFields
        fields.forEach {
            it.isAccessible = true
            val annotation = it.getAnnotation(SerializedName::class.java)
            val keyName = annotation?.value?:it.name
            mappingField(jsonObject, keyName, it, t)
        }
        return t
    }


    fun <T : Any> mappingField(
        jsonObject: JSONObject,
        key:String, f: Field, t: T
    ) {
        when (f.type) {
            Int::class.java
            -> f.setInt(t, jsonObject.optInt(key))
            String::class.java
            -> f.set(t, jsonObject.optString(key))
            Float::class.java
            -> f.setFloat(t, jsonObject.optDouble(key).toFloat())
            Double::class.java
            -> f.setDouble(t, jsonObject.optDouble(key))
            Long::class.java
            -> f.setLong(t, jsonObject.optLong(key))
        }
    }
}