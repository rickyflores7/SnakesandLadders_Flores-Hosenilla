package ph.startrek.snakenladder.hosenilla.heroo

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.annotation.ColorInt
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ph.startrek.snakenladder.hosenilla.heroo.databinding.ActivityGameBinding
import ph.startrek.snakenladder.hosenilla.heroo.utility.PreferenceUtility
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    var winner: String = ""
    private var player1 = 0
    private var player2 = 0
    private var player3 = 0
    private var player4 = 0
    private var colorPlayer1 = Color.RED
    private var colorPlayer2 = Color.BLUE
    private var colorPlayer3 = Color.rgb(255, 165, 0)
    private var colorPlayer4 = Color.MAGENTA
    private var resetColor = Color.TRANSPARENT
    private var turn = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player1Name =intent.getStringExtra("Player1")
        val player2Name =intent.getStringExtra("Player2")
        val player3Name =intent.getStringExtra("Player3")
        val player4Name =intent.getStringExtra("Player4")

        binding.player1Name.text = player1Name.toString()
        binding.player2Name.text = player2Name.toString()
        binding.player3Name.text = player3Name.toString()
        binding.player4Name.text = player4Name.toString()






        ButtonResetColor()
        binding.playerTurn.text = "Player 1's Turn"

        binding.buttonRoll.setOnClickListener {
            val roll = Random.nextInt(1, 7)
            ButtonResetColor()
            RollReset()
            if(turn == 1){
                player1 += roll
                turn++
                binding.playerTurn.text = "Player 2's Turn"  //change later with user profile
                binding.textPlayerRoll1.text = roll.toString()
            }else if(turn == 2){
                player2 += roll
                turn++
                binding.playerTurn.text = "Player 3's Turn"
                binding.textPlayerRoll2.text = roll.toString()
            }
            else if(turn == 3){
                player3 += roll
                turn++
                binding.playerTurn.text = "Player 4's Turn"
                binding.textPlayerRoll3.text = roll.toString()
            }
            else if(turn == 4){
                player4 += roll
                turn = 1
                binding.playerTurn.text = "Player 1's Turn"
                binding.textPlayerRoll4.text = roll.toString()
            }

            // PLAYER 1
            if(player1 == 100){
                PositionColor1()
                winner = player1Name.toString()

                val winnerPref = winner.toString()

                PreferenceUtility(applicationContext).apply {
                    saveStringPreferences("winner", winnerPref)
                }

                var intent =Intent(applicationContext, WinnerActivity::class.java)

                val preferences: SharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(applicationContext)
                val winnersJson = preferences.getString("winners", "[]") ?: "[]"
                val newWinners = Gson().fromJson(winnersJson, object :
                    TypeToken<MutableList<String>>() {}.type) as MutableList<String>

                newWinners.add(winner)

                val newWinnerJSON = Gson().toJson(newWinners)
                preferences.edit().putString("winners", newWinnerJSON).apply()

                intent.putExtra("PlayerWinner", winner)

                startActivity(intent)
                finish()
            }
            else if(player1 < 100){
                if(player1 == 1){
                    player1 = 38
                }else if(player1 == 4){
                    player1 = 14
                }else if(player1 == 8){
                    player1 = 30
                }else if(player1 == 21){
                    player1 = 42
                }else if(player1 == 32){
                    player1 = 10
                }else if(player1 == 36){
                    player1 = 6
                }else if(player1 == 48){
                    player1 = 26
                }else if(player1 == 50){
                    player1 = 67
                }else if(player1 == 62){
                    player1 = 18
                }else if(player1 == 71){
                    player1 = 92
                }else if(player1 == 80){
                    player1 = 99
                }else if(player1 == 88){
                    player1 = 24
                }else if(player1 == 95){
                    player1 = 56
                }else if(player1 == 97){
                    player1 = 78
                }
                binding.textPlayerCount1.text = player1.toString()
                PositionColor1()
            }
            else if( player1 > 100 && turn == 2){
                var solution =  player1 - 100
                player1 = 80+solution
                binding.textPlayerCount1.text = player1.toString()
                PositionColor1()
            }

            //PLAYER 2
            if(player2 == 100){
                PositionColor2()
                winner = player2Name.toString()

                val winnerPref = winner.toString()

                PreferenceUtility(applicationContext).apply {
                    saveStringPreferences("winner", winnerPref)
                }

                var intent =Intent(applicationContext, WinnerActivity::class.java)

                val preferences: SharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(applicationContext)
                val winnersJson = preferences.getString("winners", "[]") ?: "[]"
                val newWinners = Gson().fromJson(winnersJson, object :
                    TypeToken<MutableList<String>>() {}.type) as MutableList<String>

                newWinners.add(winner)

                val newWinnerJSON = Gson().toJson(newWinners)
                preferences.edit().putString("winners", newWinnerJSON).apply()

                intent.putExtra("PlayerWinner", winner)

                startActivity(intent)
                finish()
            }
            else if(player2 < 100){
                if(player2 == 1){
                    player2 = 38
                }else if(player2 == 4){
                    player2 = 14
                }else if(player2 == 8){
                    player2 = 30
                }else if(player2 == 21){
                    player2 = 42
                }else if(player2 == 32){
                    player2 = 10
                }else if(player2 == 36){
                    player2 = 6
                }else if(player2 == 48){
                    player2 = 26
                }else if(player2 == 50){
                    player2 = 67
                }else if(player2 == 62){
                    player2 = 18
                }else if(player2 == 71){
                    player2 = 92
                }else if(player2 == 80){
                    player2 = 99
                }else if(player2 == 88){
                    player2 = 24
                }else if(player2 == 95){
                    player2 = 56
                }else if(player2 == 97){
                    player2 = 78
                }
                binding.textPlayerCount2.text = player2.toString()
                PositionColor2()
            }
            else if(player2 > 100 && turn == 3){
                var solution =  player2 - 100
                player2 = 80+solution
                binding.textPlayerCount2.text = player2.toString()
                PositionColor2()
            }


            //PLAYER 3
            if(player3 == 100){
                PositionColor3()
                winner = player3Name.toString()

                val winnerPref = winner.toString()

                PreferenceUtility(applicationContext).apply {
                    saveStringPreferences("winner", winnerPref)
                }

                var intent =Intent(applicationContext, WinnerActivity::class.java)

                val preferences: SharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(applicationContext)
                val winnersJson = preferences.getString("winners", "[]") ?: "[]"
                val newWinners = Gson().fromJson(winnersJson, object :
                    TypeToken<MutableList<String>>() {}.type) as MutableList<String>

                newWinners.add(winner)

                val newWinnerJSON = Gson().toJson(newWinners)
                preferences.edit().putString("winners", newWinnerJSON).apply()

                intent.putExtra("PlayerWinner", winner)

                startActivity(intent)
                finish()
            }
            else if(player3 < 100){

                if(player3 == 1){
                    player3 = 38
                }else if(player3 == 4){
                    player3 = 14
                }else if(player3 == 8){
                    player3 = 30
                }else if(player3 == 21){
                    player3 = 42
                }else if(player3 == 32){
                    player3 = 10
                }else if(player3 == 36){
                    player3 = 6
                }else if(player3 == 48){
                    player3 = 26
                }else if(player3 == 50){
                    player3 = 67
                }else if(player3 == 62){
                    player3 = 18
                }else if(player3 == 71){
                    player3 = 92
                }else if(player3 == 80){
                    player3 = 99
                }else if(player3 == 88){
                    player3 = 24
                }else if(player3 == 95){
                    player3 = 56
                }else if(player3 == 97){
                    player3 = 78
                }
                binding.textPlayerCount3.text = player3.toString()
                PositionColor3()
            }
            else if( player3 > 100 && turn == 4){

                var solution =  player3 - 100
                player3 = 80+solution
                binding.textPlayerCount3.text = player3.toString()
                PositionColor3()
            }

            //PLAYER 4
            if(player4 == 100){
                PositionColor4()
                winner = player4Name.toString()

                val winnerPref = winner.toString()

                PreferenceUtility(applicationContext).apply {
                    saveStringPreferences("winner", winnerPref)
                }

                var intent =Intent(applicationContext, WinnerActivity::class.java)

                val preferences: SharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(applicationContext)
                val winnersJson = preferences.getString("winners", "[]") ?: "[]"
                val newWinners = Gson().fromJson(winnersJson, object :
                    TypeToken<MutableList<String>>() {}.type) as MutableList<String>

                newWinners.add(winner)

                val newWinnerJSON = Gson().toJson(newWinners)
                preferences.edit().putString("winners", newWinnerJSON).apply()

                intent.putExtra("PlayerWinner", winner)

                startActivity(intent)
                finish()
            }
            else if(player4 < 100){

                if(player4 == 1){
                    player4 = 38
                }else if(player4 == 4){
                    player4 = 14
                }else if(player4 == 8){
                    player4 = 30
                }else if(player4 == 21){
                    player4 = 42
                }else if(player4 == 32){
                    player4 = 10
                }else if(player4 == 36){
                    player4 = 6
                }else if(player4 == 48){
                    player4 = 26
                }else if(player4 == 50){
                    player4 = 67
                }else if(player4 == 62){
                    player4 = 18
                }else if(player4 == 71){
                    player4 = 92
                }else if(player4 == 80){
                    player4 = 99
                }else if(player4 == 88){
                    player4 = 24
                }else if(player4 == 95){
                    player4 = 56
                }else if(player4 == 97){
                    player4 = 78
                }
                binding.textPlayerCount4.text = player4.toString()
                PositionColor4()
            }
            else if( player4 > 100 && turn == 1){

                var solution =  player4 - 100
                player4 = 80+solution
                binding.textPlayerCount4.text = player4.toString()
                PositionColor4()
            }
        }
    }

    private fun PositionColor4(){
        if(player4 == 1){
            binding.button001.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 2){
            binding.button002.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 3){
            binding.button003.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 4){
            binding.button004.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 5){
            binding.button005.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 6){
            binding.button006.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 7){
            binding.button007.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 8){
            binding.button008.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 9){
            binding.button009.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 10){
            binding.button010.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 11){
            binding.button011.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 12){
            binding.button012.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 13){
            binding.button013.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 14){
            binding.button014.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 15){
            binding.button015.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 16){
            binding.button016.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 17){
            binding.button017.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 18){
            binding.button018.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 19){
            binding.button019.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 20){
            binding.button020.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 21){
            binding.button021.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 22){
            binding.button022.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 23){
            binding.button023.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 24){
            binding.button024.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 25){
            binding.button025.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 26){
            binding.button026.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 27){
            binding.button027.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 28){
            binding.button028.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 29){
            binding.button029.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 30){
            binding.button030.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 31){
            binding.button031.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 32){
            binding.button032.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 33){
            binding.button033.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 34){
            binding.button034.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 35){
            binding.button035.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 36){
            binding.button036.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 37){
            binding.button037.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 38){
            binding.button038.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 39){
            binding.button039.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 40){
            binding.button040.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 41){
            binding.button041.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 42){
            binding.button042.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 43){
            binding.button043.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 44){
            binding.button044.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 45){
            binding.button045.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 46){
            binding.button046.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 47){
            binding.button047.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 48){
            binding.button048.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 49){
            binding.button049.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 50){
            binding.button050.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 59){
            binding.button059.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 51){
            binding.button051.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 52){
            binding.button052.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 53){
            binding.button053.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 54){
            binding.button054.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 55){
            binding.button055.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 56){
            binding.button056.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 57){
            binding.button057.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 58){
            binding.button058.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 60){
            binding.button060.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 61){
            binding.button061.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 62){
            binding.button062.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 63){
            binding.button063.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 64){
            binding.button064.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 65){
            binding.button065.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 66){
            binding.button066.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 67){
            binding.button067.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 68){
            binding.button068.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 69){
            binding.button069.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 70){
            binding.button070.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 71){
            binding.button071.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 72){
            binding.button072.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 73){
            binding.button073.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 74){
            binding.button074.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 75){
            binding.button075.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 76){
            binding.button076.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 77){
            binding.button077.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 78){
            binding.button078.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 79){
            binding.button079.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 80){
            binding.button080.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 81){
            binding.button081.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 82){
            binding.button082.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 83){
            binding.button083.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 84){
            binding.button084.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 85){
            binding.button085.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 86){
            binding.button086.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 87){
            binding.button087.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 88){
            binding.button088.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 89){
            binding.button089.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 90){
            binding.button090.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 91){
            binding.button091.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 92){
            binding.button092.setBackgroundColor(colorPlayer4)
        }

        else if(player4== 93){
            binding.button093.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 94){
            binding.button094.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 95){
            binding.button095.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 96){
            binding.button096.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 97){
            binding.button097.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 98){
            binding.button098.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 99){
            binding.button099.setBackgroundColor(colorPlayer4)
        }
        else if(player4== 100){
            binding.button100.setBackgroundColor(colorPlayer4)
        }
    }

    private fun PositionColor3(){
        if(player3 == 1){
            binding.button001.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 2){
            binding.button002.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 3){
            binding.button003.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 4){
            binding.button004.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 5){
            binding.button005.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 6){
            binding.button006.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 7){
            binding.button007.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 8){
            binding.button008.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 9){
            binding.button009.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 10){
            binding.button010.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 11){
            binding.button011.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 12){
            binding.button012.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 13){
            binding.button013.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 14){
            binding.button014.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 15){
            binding.button015.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 16){
            binding.button016.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 17){
            binding.button017.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 18){
            binding.button018.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 19){
            binding.button019.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 20){
            binding.button020.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 21){
            binding.button021.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 22){
            binding.button022.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 23){
            binding.button023.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 24){
            binding.button024.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 25){
            binding.button025.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 26){
            binding.button026.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 27){
            binding.button027.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 28){
            binding.button028.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 29){
            binding.button029.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 30){
            binding.button030.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 31){
            binding.button031.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 32){
            binding.button032.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 33){
            binding.button033.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 34){
            binding.button034.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 35){
            binding.button035.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 36){
            binding.button036.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 37){
            binding.button037.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 38){
            binding.button038.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 39){
            binding.button039.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 40){
            binding.button040.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 41){
            binding.button041.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 42){
            binding.button042.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 43){
            binding.button043.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 44){
            binding.button044.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 45){
            binding.button045.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 46){
            binding.button046.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 47){
            binding.button047.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 48){
            binding.button048.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 49){
            binding.button049.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 50){
            binding.button050.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 59){
            binding.button059.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 51){
            binding.button051.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 52){
            binding.button052.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 53){
            binding.button053.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 54){
            binding.button054.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 55){
            binding.button055.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 56){
            binding.button056.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 57){
            binding.button057.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 58){
            binding.button058.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 60){
            binding.button060.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 61){
            binding.button061.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 62){
            binding.button062.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 63){
            binding.button063.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 64){
            binding.button064.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 65){
            binding.button065.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 66){
            binding.button066.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 67){
            binding.button067.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 68){
            binding.button068.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 69){
            binding.button069.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 70){
            binding.button070.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 71){
            binding.button071.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 72){
            binding.button072.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 73){
            binding.button073.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 74){
            binding.button074.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 75){
            binding.button075.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 76){
            binding.button076.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 77){
            binding.button077.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 78){
            binding.button078.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 79){
            binding.button079.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 80){
            binding.button080.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 81){
            binding.button081.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 82){
            binding.button082.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 83){
            binding.button083.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 84){
            binding.button084.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 85){
            binding.button085.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 86){
            binding.button086.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 87){
            binding.button087.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 88){
            binding.button088.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 89){
            binding.button089.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 90){
            binding.button090.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 91){
            binding.button091.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 92){
            binding.button092.setBackgroundColor(colorPlayer3)
        }

        else if(player3== 93){
            binding.button093.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 94){
            binding.button094.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 95){
            binding.button095.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 96){
            binding.button096.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 97){
            binding.button097.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 98){
            binding.button098.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 99){
            binding.button099.setBackgroundColor(colorPlayer3)
        }
        else if(player3== 100){
            binding.button100.setBackgroundColor(colorPlayer3)
        }
    }

    private fun PositionColor2(){
        if(player2 == 1){
            binding.button001.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 2){
            binding.button002.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 3){
            binding.button003.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 4){
            binding.button004.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 5){
            binding.button005.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 6){
            binding.button006.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 7){
            binding.button007.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 8){
            binding.button008.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 9){
            binding.button009.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 10){
            binding.button010.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 11){
            binding.button011.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 12){
            binding.button012.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 13){
            binding.button013.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 14){
            binding.button014.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 15){
            binding.button015.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 16){
            binding.button016.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 17){
            binding.button017.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 18){
            binding.button018.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 19){
            binding.button019.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 20){
            binding.button020.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 21){
            binding.button021.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 22){
            binding.button022.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 23){
            binding.button023.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 24){
            binding.button024.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 25){
            binding.button025.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 26){
            binding.button026.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 27){
            binding.button027.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 28){
            binding.button028.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 29){
            binding.button029.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 30){
            binding.button030.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 31){
            binding.button031.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 32){
            binding.button032.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 33){
            binding.button033.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 34){
            binding.button034.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 35){
            binding.button035.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 36){
            binding.button036.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 37){
            binding.button037.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 38){
            binding.button038.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 39){
            binding.button039.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 40){
            binding.button040.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 41){
            binding.button041.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 42){
            binding.button042.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 43){
            binding.button043.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 44){
            binding.button044.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 45){
            binding.button045.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 46){
            binding.button046.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 47){
            binding.button047.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 48){
            binding.button048.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 49){
            binding.button049.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 50){
            binding.button050.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 59){
            binding.button059.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 51){
            binding.button051.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 52){
            binding.button052.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 53){
            binding.button053.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 54){
            binding.button054.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 55){
            binding.button055.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 56){
            binding.button056.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 57){
            binding.button057.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 58){
            binding.button058.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 60){
            binding.button060.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 61){
            binding.button061.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 62){
            binding.button062.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 63){
            binding.button063.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 64){
            binding.button064.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 65){
            binding.button065.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 66){
            binding.button066.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 67){
            binding.button067.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 68){
            binding.button068.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 69){
            binding.button069.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 70){
            binding.button070.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 71){
            binding.button071.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 72){
            binding.button072.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 73){
            binding.button073.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 74){
            binding.button074.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 75){
            binding.button075.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 76){
            binding.button076.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 77){
            binding.button077.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 78){
            binding.button078.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 79){
            binding.button079.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 80){
            binding.button080.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 81){
            binding.button081.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 82){
            binding.button082.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 83){
            binding.button083.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 84){
            binding.button084.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 85){
            binding.button085.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 86){
            binding.button086.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 87){
            binding.button087.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 88){
            binding.button088.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 89){
            binding.button089.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 90){
            binding.button090.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 91){
            binding.button091.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 92){
            binding.button092.setBackgroundColor(colorPlayer2)
        }

        else if(player2== 93){
            binding.button093.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 94){
            binding.button094.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 95){
            binding.button095.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 96){
            binding.button096.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 97){
            binding.button097.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 98){
            binding.button098.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 99){
            binding.button099.setBackgroundColor(colorPlayer2)
        }
        else if(player2== 100){
            binding.button100.setBackgroundColor(colorPlayer2)
        }
    }

    private fun PositionColor1(){
        if(player1 == 1){
            binding.button001.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 2){
            binding.button002.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 3){
            binding.button003.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 4){
            binding.button004.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 5){
            binding.button005.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 6){
            binding.button006.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 7){
            binding.button007.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 8){
            binding.button008.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 9){
            binding.button009.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 10){
            binding.button010.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 11){
            binding.button011.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 12){
            binding.button012.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 13){
            binding.button013.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 14){
            binding.button014.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 15){
            binding.button015.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 16){
            binding.button016.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 17){
            binding.button017.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 18){
            binding.button018.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 19){
            binding.button019.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 20){
            binding.button020.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 21){
            binding.button021.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 22){
            binding.button022.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 23){
            binding.button023.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 24){
            binding.button024.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 25){
            binding.button025.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 26){
            binding.button026.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 27){
            binding.button027.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 28){
            binding.button028.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 29){
            binding.button029.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 30){
            binding.button030.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 31){
            binding.button031.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 32){
            binding.button032.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 33){
            binding.button033.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 34){
            binding.button034.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 35){
            binding.button035.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 36){
            binding.button036.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 37){
            binding.button037.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 38){
            binding.button038.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 39){
            binding.button039.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 40){
            binding.button040.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 41){
            binding.button041.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 42){
            binding.button042.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 43){
            binding.button043.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 44){
            binding.button044.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 45){
            binding.button045.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 46){
            binding.button046.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 47){
            binding.button047.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 48){
            binding.button048.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 49){
            binding.button049.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 50){
            binding.button050.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 59){
            binding.button059.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 51){
            binding.button051.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 52){
            binding.button052.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 53){
            binding.button053.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 54){
            binding.button054.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 55){
            binding.button055.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 56){
            binding.button056.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 57){
            binding.button057.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 58){
            binding.button058.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 60){
            binding.button060.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 61){
            binding.button061.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 62){
            binding.button062.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 63){
            binding.button063.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 64){
            binding.button064.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 65){
            binding.button065.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 66){
            binding.button066.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 67){
            binding.button067.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 68){
            binding.button068.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 69){
            binding.button069.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 70){
            binding.button070.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 71){
            binding.button071.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 72){
            binding.button072.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 73){
            binding.button073.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 74){
            binding.button074.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 75){
            binding.button075.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 76){
            binding.button076.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 77){
            binding.button077.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 78){
            binding.button078.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 79){
            binding.button079.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 80){
            binding.button080.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 81){
            binding.button081.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 82){
            binding.button082.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 83){
            binding.button083.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 84){
            binding.button084.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 85){
            binding.button085.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 86){
            binding.button086.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 87){
            binding.button087.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 88){
            binding.button088.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 89){
            binding.button089.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 90){
            binding.button090.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 91){
            binding.button091.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 92){
            binding.button092.setBackgroundColor(colorPlayer1)
        }

        else if(player1== 93){
            binding.button093.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 94){
            binding.button094.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 95){
            binding.button095.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 96){
            binding.button096.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 97){
            binding.button097.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 98){
            binding.button098.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 99){
            binding.button099.setBackgroundColor(colorPlayer1)
        }
        else if(player1== 100){
            binding.button100.setBackgroundColor(colorPlayer1)
        }
    }
    
 
    
    fun RollReset(){
        binding.textPlayerRoll1.text = "0"
        binding.textPlayerRoll2.text = "0"
        binding.textPlayerRoll3.text = "0"
        binding.textPlayerRoll4.text = "0"
    }


    fun ButtonResetColor() {
        binding.button001.setBackgroundColor(resetColor)
        binding.button002.setBackgroundColor(resetColor)
        binding.button003.setBackgroundColor(resetColor)
        binding.button004.setBackgroundColor(resetColor)
        binding.button005.setBackgroundColor(resetColor)
        binding.button006.setBackgroundColor(resetColor)
        binding.button007.setBackgroundColor(resetColor)
        binding.button008.setBackgroundColor(resetColor)
        binding.button009.setBackgroundColor(resetColor)
        binding.button010.setBackgroundColor(resetColor)
        binding.button011.setBackgroundColor(resetColor)
        binding.button012.setBackgroundColor(resetColor)
        binding.button013.setBackgroundColor(resetColor)
        binding.button014.setBackgroundColor(resetColor)
        binding.button015.setBackgroundColor(resetColor)
        binding.button016.setBackgroundColor(resetColor)
        binding.button017.setBackgroundColor(resetColor)
        binding.button018.setBackgroundColor(resetColor)
        binding.button019.setBackgroundColor(resetColor)
        binding.button020.setBackgroundColor(resetColor)
        binding.button021.setBackgroundColor(resetColor)
        binding.button022.setBackgroundColor(resetColor)
        binding.button023.setBackgroundColor(resetColor)
        binding.button024.setBackgroundColor(resetColor)
        binding.button025.setBackgroundColor(resetColor)
        binding.button026.setBackgroundColor(resetColor)
        binding.button027.setBackgroundColor(resetColor)
        binding.button028.setBackgroundColor(resetColor)
        binding.button029.setBackgroundColor(resetColor)
        binding.button030.setBackgroundColor(resetColor)
        binding.button031.setBackgroundColor(resetColor)
        binding.button032.setBackgroundColor(resetColor)
        binding.button033.setBackgroundColor(resetColor)
        binding.button034.setBackgroundColor(resetColor)
        binding.button035.setBackgroundColor(resetColor)
        binding.button036.setBackgroundColor(resetColor)
        binding.button037.setBackgroundColor(resetColor)
        binding.button038.setBackgroundColor(resetColor)
        binding.button039.setBackgroundColor(resetColor)
        binding.button040.setBackgroundColor(resetColor)
        binding.button041.setBackgroundColor(resetColor)
        binding.button042.setBackgroundColor(resetColor)
        binding.button043.setBackgroundColor(resetColor)
        binding.button044.setBackgroundColor(resetColor)
        binding.button045.setBackgroundColor(resetColor)
        binding.button046.setBackgroundColor(resetColor)
        binding.button047.setBackgroundColor(resetColor)
        binding.button048.setBackgroundColor(resetColor)
        binding.button049.setBackgroundColor(resetColor)
        binding.button050.setBackgroundColor(resetColor)
        binding.button051.setBackgroundColor(resetColor)
        binding.button052.setBackgroundColor(resetColor)
        binding.button053.setBackgroundColor(resetColor)
        binding.button054.setBackgroundColor(resetColor)
        binding.button055.setBackgroundColor(resetColor)
        binding.button056.setBackgroundColor(resetColor)
        binding.button057.setBackgroundColor(resetColor)
        binding.button058.setBackgroundColor(resetColor)
        binding.button059.setBackgroundColor(resetColor)
        binding.button060.setBackgroundColor(resetColor)
        binding.button061.setBackgroundColor(resetColor)
        binding.button062.setBackgroundColor(resetColor)
        binding.button063.setBackgroundColor(resetColor)
        binding.button064.setBackgroundColor(resetColor)
        binding.button065.setBackgroundColor(resetColor)
        binding.button066.setBackgroundColor(resetColor)
        binding.button067.setBackgroundColor(resetColor)
        binding.button068.setBackgroundColor(resetColor)
        binding.button069.setBackgroundColor(resetColor)
        binding.button070.setBackgroundColor(resetColor)
        binding.button071.setBackgroundColor(resetColor)
        binding.button072.setBackgroundColor(resetColor)
        binding.button073.setBackgroundColor(resetColor)
        binding.button074.setBackgroundColor(resetColor)
        binding.button075.setBackgroundColor(resetColor)
        binding.button076.setBackgroundColor(resetColor)
        binding.button077.setBackgroundColor(resetColor)
        binding.button078.setBackgroundColor(resetColor)
        binding.button079.setBackgroundColor(resetColor)
        binding.button080.setBackgroundColor(resetColor)
        binding.button081.setBackgroundColor(resetColor)
        binding.button082.setBackgroundColor(resetColor)
        binding.button083.setBackgroundColor(resetColor)
        binding.button084.setBackgroundColor(resetColor)
        binding.button085.setBackgroundColor(resetColor)
        binding.button086.setBackgroundColor(resetColor)
        binding.button087.setBackgroundColor(resetColor)
        binding.button088.setBackgroundColor(resetColor)
        binding.button089.setBackgroundColor(resetColor)
        binding.button090.setBackgroundColor(resetColor)
        binding.button091.setBackgroundColor(resetColor)
        binding.button092.setBackgroundColor(resetColor)
        binding.button093.setBackgroundColor(resetColor)
        binding.button094.setBackgroundColor(resetColor)
        binding.button095.setBackgroundColor(resetColor)
        binding.button096.setBackgroundColor(resetColor)
        binding.button097.setBackgroundColor(resetColor)
        binding.button098.setBackgroundColor(resetColor)
        binding.button099.setBackgroundColor(resetColor)
        binding.button100.setBackgroundColor(resetColor)
    }




    override fun onBackPressed() {
        super.onBackPressed()

        val goToLogin = Intent(applicationContext,
            MainActivity::class.java)
        startActivity(goToLogin)
        finish()
    }




}