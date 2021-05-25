package com.tylerlyczak.vaporstream_codetest.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.tylerlyczak.vaporstream_codetest.PersonApplication
import com.tylerlyczak.vaporstream_codetest.PersonViewModel
import com.tylerlyczak.vaporstream_codetest.PersonViewModelFactory
import com.tylerlyczak.vaporstream_codetest.R
import com.tylerlyczak.vaporstream_codetest.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    // Declare our personViewModel to get the most current data from database
    private val personViewModel: PersonViewModel by viewModels {
        PersonViewModelFactory((application as PersonApplication).repository)
    }

    // Declare our dataViewModel to control the data in our views
    private val dataViewModel : DataViewModel by viewModels()

    // Declare our binding to control our views
    lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the binding to the layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data)
        binding.lifecycleOwner = this
        binding.dataViewModel = dataViewModel

        // Observe changes in the personViewModel to get the latest data
        personViewModel.allPeople.observe(this, {
            it.forEach { p ->
                dataViewModel.currentData.value += p.uid.toString()
                dataViewModel.currentData.value += ","
                dataViewModel.currentData.value += p.firstName
                dataViewModel.currentData.value += ","
                dataViewModel.currentData.value += p.lastName
                dataViewModel.currentData.value += ","
                dataViewModel.currentData.value += p.phoneNumber
                dataViewModel.currentData.value += ","
                dataViewModel.currentData.value += p.address1
                dataViewModel.currentData.value += ","
                dataViewModel.currentData.value += p.address2
                dataViewModel.currentData.value += ","
                dataViewModel.currentData.value += p.cityName
                dataViewModel.currentData.value += ","
                dataViewModel.currentData.value += p.stateName
                dataViewModel.currentData.value += ","
                dataViewModel.currentData.value += p.zipCode
                dataViewModel.currentData.value += "\n\n"
            }
        })
    }
}