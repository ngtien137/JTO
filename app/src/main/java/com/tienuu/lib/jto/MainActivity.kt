package com.tienuu.lib.jto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tienuu.lib.jtosupporter.JTO.toList
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fakeJson = "[\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Adam Carter\",\n" +
                "      \"work\": \"Unilogic\",\n" +
                "      \"email\": \"adam.carter@unilogic.com\",\n" +
                "      \"dob\": \"1978\",\n" +
                "      \"address\": \"83 Warner Street\",\n" +
                "      \"city\": \"Boston\",\n" +
                "      \"optedin\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Leanne Brier\",\n" +
                "      \"work\": \"Connic\",\n" +
                "      \"email\": \"leanne.brier@connic.org\",\n" +
                "      \"dob\": \"1987\",\n" +
                "      \"address\": \"9 Coleman Avenue\",\n" +
                "      \"city\": \"Toronto\",\n" +
                "      \"optedin\": false\n" +
                "    }\n" +
                "  ]"
        val json = JSONArray(fakeJson)
        val objects = json.toList<Employee>()
        Log.e("Test data","Data Dump: $objects")

    }
}