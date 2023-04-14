package ph.startrek.snakenladder.hosenilla.heroo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Global {
    private static String username;
    private static String password;

    private HashMap<Integer, String> highScore;


    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void setScore(int score, String name){
        highScore.put(score,name);
    }

    public String highScoreList(){

        return "1st, 2000 , heroo \n asdasds \n asdsad";
    }





}
