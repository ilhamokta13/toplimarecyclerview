package com.example.toplimarecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toplimarecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapterstudentdiff:StudentAdapterDiffUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterstudentdiff = StudentAdapterDiffUtil()

        val ListStudentData = arrayListOf(
            ListStudent("Andika",19, "123", R.drawable.ic_baseline_perm_identity_24),
            ListStudent("Ayu", 23,"147", R.drawable.ic_baseline_adb_24),
            ListStudent("Dheva", 22,"165", R.drawable.ic_baseline_accessibility_new_24),
            ListStudent("Ilham", 21, "345",R.drawable.ic_baseline_account_box_24),
            ListStudent("Kak Ze", 20, "245",R.drawable.ic_baseline_add_reaction_24),
            ListStudent("Axel", 21,"147", R.drawable.ic_baseline_airline_seat_recline_normal_24),
            ListStudent("Dwiki", 20,"752", R.drawable.ic_baseline_person_24)

        )

        //panggil class adapter lalu isi data berupa array list

        var adapterStudent = StudentAdapter(ListStudentData)

        //mengatur tata letak dari recycler view
        val lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//        val gl = GridLayout(this)
        binding.rvStudent.layoutManager = lm
        binding.rvStudent.adapter = adapterStudent

        adapterStudent.onClick = {
            var pindah = Intent(this, DetailStudent::class.java)
            pindah.putExtra("detailStudent", it)
            startActivity(pindah)
        }

        //update recyclerview menggunakan notify data set changed
        binding.btnUpdatenodiff.setOnClickListener{
            ListStudentData[2] = ListStudent("Update Dheva",  15, "244", R.drawable.ic_baseline_person_24 )
            adapterStudent = StudentAdapter(ListStudentData)
            binding.rvStudent.adapter = adapterStudent
            adapterStudent.notifyDataSetChanged()
        }

        //update recycler view menggunakan DiffUtil
        binding.btnUpdateDiff.setOnClickListener {
            ListStudentData[3] = ListStudent("Update Ilham", 10, "7456",R.drawable.ic_baseline_add_reaction_24)
            adapterstudentdiff = StudentAdapterDiffUtil()
            adapterstudentdiff.submitData(ListStudentData)
            binding.rvStudent.adapter = adapterstudentdiff


        }

    }
}


