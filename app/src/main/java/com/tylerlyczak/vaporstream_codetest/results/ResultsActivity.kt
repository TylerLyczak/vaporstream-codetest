package com.tylerlyczak.vaporstream_codetest.results

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.tylerlyczak.vaporstream_codetest.PersonApplication
import com.tylerlyczak.vaporstream_codetest.PersonViewModel
import com.tylerlyczak.vaporstream_codetest.PersonViewModelFactory
import com.tylerlyczak.vaporstream_codetest.R
import com.tylerlyczak.vaporstream_codetest.databinding.ActivityResultsBinding

class ResultsActivity : AppCompatActivity() {

    // Declare our personViewModel to get the most current data from database
    private val personViewModel: PersonViewModel by viewModels {
        PersonViewModelFactory((application as PersonApplication).repository)
    }

    // Declare our resultsViewModel to control the data in our views
    private val resultsViewModel: ResultsViewModel by viewModels()

    // Declare our binding to control our views
    lateinit var binding: ActivityResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the binding to the layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_results)
        binding.lifecycleOwner = this
        binding.resultsViewModel = resultsViewModel

        // Observe changes in the personViewModel to get the latest data
        personViewModel.allPeople.observe(this, {
            val person = it.first()
            resultsViewModel.updateVals(person)
        })
    }
}