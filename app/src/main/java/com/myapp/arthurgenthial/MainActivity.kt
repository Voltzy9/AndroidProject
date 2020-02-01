package com.myapp.arthurgenthial

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.util.Log
import com.myapp.arthurgenthial.model.City
import com.myapp.arthurgenthial.model.ForecastResult
import com.myapp.arthurgenthial.network.ApiError
import com.myapp.arthurgenthial.network.ApiHelpers
import com.myapp.arthurgenthial.network.ApiRequestCallback
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    val foods: ArrayList<String> = ArrayList()
    val forecastList: ArrayList<String> = ArrayList()
    val apiHelpers = ApiHelpers(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiHelpers.getCityByIdAsync("6454573",
            object : ApiRequestCallback<ForecastResult>() {
                override fun onSuccess(result: ForecastResult?) {
                    super.onSuccess(result)
                    runOnUiThread {
                        //API
                        val list = result!!.forecastList
                        for (item in list) {
                            addItem(item.weather[0].main)
                            rv_list.adapter!!.notifyDataSetChanged()
                        }
                    }
                }

                override fun onError(error: ApiError) {
                    super.onError(error)
                    Log.d(
                        MainActivity::class.java.canonicalName,
                        "onError() called with: error.code  = [" + error.code
                            .toString() + " & error.message" + error.message + "]"
                    )
                }
            }
        )
        // Creates a vertical Layout Manager
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = FoodAdapter(forecastList, this)

    }
    fun addItem(res : String){
        forecastList.add(res)
        Log.d("REPONSE",res)
    }
}
