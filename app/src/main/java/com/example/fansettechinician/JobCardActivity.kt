package com.example.fansettechinician

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fansettechinician.service.DataModel.Destination
import com.example.fansettechinician.service.DestinationService
import com.example.fansettechinician.service.ServiceBuilder
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_job_card.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JobCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_card)


        postDataToServer()
        //loadDestinations()

    }

    // function to load the data from the server .....
    private fun loadDestinations(){


        val  destinationService: DestinationService = ServiceBuilder.buildService(DestinationService ::class.java)
        val requestCall  = destinationService.getDestinations()

        requestCall.enqueue(object: Callback<List<Destination>> {


            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                Toast.makeText(this@JobCardActivity,"successsfull"+response.code().toString(), Toast.LENGTH_LONG)

                if(response.isSuccessful){
                    var destinationList = response.body()!!
                    Toast.makeText(this@JobCardActivity,"successsfully  got the data !!! yeee", Toast.LENGTH_LONG)

                    textView2.text = response.code().toString()

                }else{ // appliaction level failure
                    Toast.makeText(this@JobCardActivity,"failed to get the data", Toast.LENGTH_SHORT)
                }
            }
            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {

                Toast.makeText(this@JobCardActivity,"Error occured check your network" + t.toString(), Toast.LENGTH_SHORT)

            }
        })
    }

    // function to post data to the server
    fun postDataToServer(){

        val newDestination = Destination("david","today","david@gmail.com","david")

        val  destinationService: DestinationService = ServiceBuilder.buildService(DestinationService ::class.java)
        val requestCall  = destinationService.addDestination(newDestination)

        requestCall.enqueue(object: Callback<Destination> {

            override fun onResponse(call: Call<Destination>, response: Response<Destination>) {
                if(response.isSuccessful){
                    Toast.makeText(this@JobCardActivity,"Data Successfully send to the server" , Toast.LENGTH_LONG).show()

                }else{
                    Toast.makeText(this@JobCardActivity,"Data Successfully send to the server" , Toast.LENGTH_LONG).show()
                    var newlyCreatedDestination = response.body()
                }

            }

            override fun onFailure(call: Call<Destination>, t: Throwable) {
                Toast.makeText(this@JobCardActivity,"Error occured check your network" + t.toString(), Toast.LENGTH_LONG)

            }
        })

    }

}