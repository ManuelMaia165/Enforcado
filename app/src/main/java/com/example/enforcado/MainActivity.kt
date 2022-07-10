package com.example.enforcado

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView
import com.example.enforcado.facade.Facade


class MainActivity : AppCompatActivity() {
    private lateinit var facade: Facade
    private lateinit var dica: TextView
    private lateinit var quantletras: TextView
    private lateinit var quantletrasdist: TextView
    private lateinit var letrasusadas: TextView
    private lateinit var acertos: TextView
    private lateinit var erros: TextView
    private lateinit var palavraescondida: TextView

    private lateinit var dicatext: TextView
    private lateinit var quantletrastext: TextView
    private lateinit var quantletrasdisttext: TextView
    private lateinit var letrasusadastext: TextView
    private lateinit var acertostext: TextView
    private lateinit var errostext: TextView

    private lateinit var adivinhar: Button
    private lateinit var imagem: ImageView
    private lateinit var letra: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        facade = Facade()

        // Elementos
        this.dica = findViewById(R.id.dica)
        this.quantletras = findViewById(R.id.quant_letras)
        this.quantletrasdist = findViewById(R.id.quant_letras_dist)
        this.letrasusadas = findViewById(R.id.letras_usadas)
        this.acertos = findViewById(R.id.acertos)
        this.erros = findViewById(R.id.erros)
        this.palavraescondida = findViewById(R.id.palavra_escondida)

        this.dica.text = facade.dica()
        this.quantletras.text = facade.quantLetras()
        this.quantletrasdist.text = facade.quantLetrasDist()
        this.letrasusadas.text = facade.letrasUsadas()
        this.acertos.text = facade.acertos()
        this.erros.text = facade.erros()
        this.palavraescondida.text = facade.palavraEscondida()

        this.imagem = findViewById(R.id.imagem)
        this.letra = findViewById(R.id.letra)
        this.adivinhar = findViewById(R.id.adivinhar)

        // Texto
        this.dicatext = findViewById(R.id.dicatext)
        this.quantletrastext = findViewById(R.id.quant_letrastext)
        this.quantletrasdisttext = findViewById(R.id.quant_letras_disttext)
        this.letrasusadastext = findViewById(R.id.letras_usadastext)
        this.acertostext = findViewById(R.id.acertostext)
        this.errostext = findViewById(R.id.errostext)

        this.dicatext.text = "Dica: "
        this.quantletrastext.text = "QL: "
        this.quantletrasdisttext.text = "QL Dist: "
        this.letrasusadastext.text = "LU: "
        this.acertostext.text = "Acerto: "
        this.errostext.text = "Erros: "


        this.adivinhar.setOnClickListener {
            val letra = this.letra.text.toString()
            this.facade.jogar(letra)
            this.letra.setText("")

            this.dica.text = facade.dica()
            this.quantletras.text = facade.quantLetras()
            this.quantletrasdist.text = facade.quantLetrasDist()
            this.letrasusadas.text = facade.letrasUsadas()
            this.acertos.text = facade.acertos()
            this.erros.text = facade.erros()
            this.palavraescondida.text = facade.palavraEscondida()

            val imagemforca = "forca${facade.errosImagem()}"

            this.imagem.setImageResource(
                resources.getIdentifier(
                    imagemforca,
                    "drawable",
                    packageName
                )
            )

            if (this.facade.terminou()) {
                if (this.facade.resultado()) {
                    val intent = Intent(this, Result::class.java).apply {
                        putExtra("Result", "Ganhou")
                    }
                    startActivity(intent)
                } else {
                    val intent = Intent(this, Result::class.java).apply {
                        putExtra("Result", "Perdeu")
                    }
                    startActivity(intent)
                }
            }
        }
    }
}
