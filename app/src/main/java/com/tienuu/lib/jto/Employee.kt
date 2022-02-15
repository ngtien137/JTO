package com.tienuu.lib.jto

import com.tienuu.lib.jtosupporter.SerializedName

data class Employee(
    @SerializedName("id")
    private val id: Int = 0,
    private val name: String = "",
    private val work: String = "",
    private val email: String = "",
    private val dob: String = "",
    private val address: String = "",
    private val city: String = "",
    private val optedin: Boolean = false
) {
    override fun toString(): String {
        return "Employee(id=$id, name='$name', work='$work', email='$email', dob='$dob', address='$address', city='$city', optedin=$optedin)"
    }
}