package ph.startrek.snakenladder.hosenilla.heroo.utility

import android.content.Context
import android.content.SharedPreferences


class PreferenceUtility {
    private var appPreferences: SharedPreferences? = null
    private val PREFS = "appPreferences"

    constructor(context: Context) {
        appPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
    }

    fun saveStringPreferences(key: String?, value: String?) {
        val prefsEditor = appPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun getStringPreferences(key: String?, defaultValue: String = ""): String? {
        return appPreferences!!.getString(key, defaultValue)
    }

}