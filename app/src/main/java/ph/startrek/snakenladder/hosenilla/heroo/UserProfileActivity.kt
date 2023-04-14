package ph.startrek.snakenladder.hosenilla.heroo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.startrek.snakenladder.hosenilla.heroo.databinding.ActivityGameBinding
import ph.startrek.snakenladder.hosenilla.heroo.databinding.ActivityUserProfileBinding

class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonSave.setOnClickListener {

            var player1 = binding.player1Name.text.toString()
            var player2 = binding.player2Name.text.toString()
            var player3 = binding.player3Name.text.toString()
            var player4 = binding.player4Name.text.toString()

            val goToGame = Intent(
                applicationContext,
                GameActivity::class.java
            )



            goToGame.putExtra("Player1", player1)
            goToGame.putExtra("Player2", player2)
            goToGame.putExtra("Player3", player3)
            goToGame.putExtra("Player4", player4)

            startActivity(goToGame)
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()

        val goToLanding = Intent(applicationContext,
            MainActivity::class.java)
        startActivity(goToLanding)
        finish()
    }

}