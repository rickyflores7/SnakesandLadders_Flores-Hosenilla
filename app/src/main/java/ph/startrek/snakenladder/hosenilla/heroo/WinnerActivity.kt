package ph.startrek.snakenladder.hosenilla.heroo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.startrek.snakenladder.hosenilla.heroo.databinding.ActivityMainBinding
import ph.startrek.snakenladder.hosenilla.heroo.databinding.ActivityWinnerBinding
import ph.startrek.snakenladder.hosenilla.heroo.utility.PreferenceUtility

class WinnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getWinner = intent.getStringExtra("PlayerWinner")

        binding.playerWinner.text = "Congrats! "+getWinner.toString()

        binding.buttonCont.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}