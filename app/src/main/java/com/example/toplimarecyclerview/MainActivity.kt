package com.example.toplimarecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toplimarecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ListStudentData = arrayListOf(
            ListStudent("Andika",19, R.drawable.ic_baseline_perm_identity_24),
            ListStudent("Ayu", 23, R.drawable.ic_baseline_adb_24),
            ListStudent("Dheva", 22, R.drawable.ic_baseline_accessibility_new_24),
            ListStudent("Ilham", 21, R.drawable.ic_baseline_account_box_24),
            ListStudent("Kak Ze", 20, R.drawable.ic_baseline_add_reaction_24),
            ListStudent("Axel", 21, R.drawable.ic_baseline_airline_seat_recline_normal_24),
            ListStudent("Dwiki", 20, R.drawable.ic_baseline_person_24)

        )

        //panggil class adapter lalu isi data berupa array list

        val adapterStudent = StudentAdapter(ListStudentData)

        //mengatur tata letak dari recycler view
        val lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//        val gl = GridLayout(this)
        binding.rvStudent.layoutManager = lm
        binding.rvStudent.adapter = adapterStudent
    }
}