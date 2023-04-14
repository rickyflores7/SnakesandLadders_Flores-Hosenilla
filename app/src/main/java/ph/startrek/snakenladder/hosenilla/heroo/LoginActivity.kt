package ph.startrek.snakenladder.hosenilla.heroo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ph.startrek.snakenladder.hosenilla.heroo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            val goToRegister = Intent(
                applicationContext,
                RegisterActivity::class.java
            )

            startActivity(goToRegister)
            finish()

//            Snackbar.make(binding.root,
//            "Register",
//            Snackbar.LENGTH_SHORT).show()
//
            Toast.makeText(applicationContext,
                "Register",
                Toast.LENGTH_SHORT).show()
        }

        binding.loginButton.setOnClickListener {
            val gb = Global()
            var username = binding.usernametext.text.toString()
            var password = binding.passwordtext.text.toString()

            if (username ==  gb.username && password == gb.password) {

                val goToMain = Intent(
                    applicationContext,
                    MainActivity::class.java
                )

                goToMain.putExtra("username", username)

                val bundle = Bundle()
                bundle.putString("bundle_username", username)
                goToMain.putExtras(bundle)

                startActivity(goToMain)
                finish()
            } else {
                Snackbar.make(
                    binding.root,
                    "Please provide admin/admin",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}