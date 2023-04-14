package ph.startrek.snakenladder.hosenilla.heroo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ph.startrek.snakenladder.hosenilla.heroo.databinding.ActivityMainBinding
import ph.startrek.snakenladder.hosenilla.heroo.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentHomeBinding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.BottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.winners -> replaceFragment(WinnerPageFragment())
                else -> {
                }
            }
            true
        }




    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }


}