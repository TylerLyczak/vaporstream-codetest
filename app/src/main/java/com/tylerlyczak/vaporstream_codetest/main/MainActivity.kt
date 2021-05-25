package com.tylerlyczak.vaporstream_codetest.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tylerlyczak.vaporstream_codetest.*
import com.tylerlyczak.vaporstream_codetest.data.DataActivity
import com.tylerlyczak.vaporstream_codetest.databinding.ActivityMainBinding
import com.tylerlyczak.vaporstream_codetest.results.ResultsActivity

class MainActivity : AppCompatActivity() {

    // Declare our personViewModel to insert data
    private val personViewModel: PersonViewModel by viewModels {
        PersonViewModelFactory((application as PersonApplication).repository)
    }

    // Declare our resultsViewModel to control the data in our views
    private val mainViewModel: MainViewModel by viewModels()

    // Declare our binding to control our views
    lateinit var binding: ActivityMainBinding

    // Var to store the spinner
    private lateinit var spinnerStates: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the binding to the layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel

        // Get the spinner from our layout
        spinnerStates = findViewById(R.id.spinner_states)

        // Observe the change when we add the states array to the viewModel
        mainViewModel.initSpinner(this).observe(this, {
            val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, it)
            spinnerStates.adapter = spinnerAdapter
        })
    }

    /*
        onSubmit
            Submits the current data the user gave the program after checking
     */
    fun onSubmit(view: View)    {
        val person = Person(mainViewModel.currentFirstName.value.toString(),
            mainViewModel.currentLastName.value.toString(),
            mainViewModel.currentPhoneNumber.value.toString(),
            mainViewModel.currentAddressOne.value.toString(),
            mainViewModel.currentAddressTwo.value.toString(),
            mainViewModel.currentCity.value.toString(),
            spinnerStates.selectedItem.toString(),
            mainViewModel.currentZipCode.value.toString()
        )
        personViewModel.insert(person)
        startActivity(Intent(this, ResultsActivity::class.java))
    }

    /*
        onClear
            Clears all the input from the user
     */
    fun onClear(view: View) {
        mainViewModel.currentFirstName.value = ""
        mainViewModel.currentLastName.value = ""
        mainViewModel.currentPhoneNumber.value = ""
        mainViewModel.currentAddressOne.value = ""
        mainViewModel.currentAddressTwo.value = ""
        mainViewModel.currentCity.value = ""
        mainViewModel.currentZipCode.value = ""
        spinnerStates.setSelection(0)
    }

    /*
        onSeeData
            Activity that shows all the current data stored by the Room database
     */
    fun onSeeData(view: View)   {
        startActivity(Intent(this, DataActivity::class.java))
    }
}