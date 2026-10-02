package com.example.calculoaposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculoaposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val generos = listOf("Masculino", "Feminino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.Genero.adapter = adapter


        binding.button.setOnClickListener {

            val idadeTexto = binding.editTextIdade.text.toString()


            if (idadeTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, digite sua idade!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val idade = idadeTexto.toInt()


            val generoSelecionado = binding.Genero.selectedItem.toString()


            var resultado = 0
            val idadeMinima = if (generoSelecionado == "Masculino") 65 else 62


            if (idade >= idadeMinima) {
                binding.textViewResultado.text = "Você já deveria estar aposentado."
            } else {
                resultado = idadeMinima - idade
                binding.textViewResultado.text = "Faltam $resultado anos para você se aposentar."
            }
        }
    }
}