package com.example.toplimarecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toplimarecyclerview.databinding.ActivityDetailStudentBinding

class DetailStudent : AppCompatActivity() {

    lateinit var binding : ActivityDetailStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var getDetail = intent.getSerializableExtra("detailStudent") as ListStudent
        binding.imgDetail.setImageResource(getDetail.image)
        binding.txtNamaDetail.text = getDetail.nama
        binding.txtUmurDetail.setText(getDetail.umur.toString())
        binding.txtNimDetail.text = getDetail.nim
    }
}