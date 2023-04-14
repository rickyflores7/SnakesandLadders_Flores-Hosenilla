package ph.startrek.snakenladder.hosenilla.heroo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ph.startrek.snakenladder.hosenilla.heroo.databinding.ActivityRegisterBinding
import ph.startrek.snakenladder.hosenilla.heroo.Global

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegister.setOnClickListener {

            val gb = Global()
            var username = binding.registerUsernameText.text.toString()
            var password = binding.registerPasswordText.text.toString()
            var confirmPass = binding.registerConfirmPasswordText.text.toString()


            if(password == confirmPass && username != null){
                gb.username = binding.registerUsernameText.text.toString()
                gb.password = binding.registerPasswordText.text.toString()

                val goToMain = Intent(
                    applicationContext,
                    LoginActivity::class.java
                )

                startActivity(goToMain)
                finish()

                Toast.makeText(applicationContext,
                    "Register Success",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext,
                    "Error",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val goToLogin = Intent(applicationContext,
            LoginActivity::class.java)
        startActivity(goToLogin)
        finish()
    }
}