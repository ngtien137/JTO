package com.tienuu.lib.jtosupporter

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class SerializedName(val value: String)
