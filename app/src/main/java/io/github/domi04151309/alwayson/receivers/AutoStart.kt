package io.github.domi04151309.alwayson.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import io.github.domi04151309.alwayson.R
import io.github.domi04151309.alwayson.services.ForegroundService
import java.lang.Exception

class AutoStart : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action == Intent.ACTION_BOOT_COMPLETED) {
            try {
                ContextCompat.startForegroundService(context, Intent(context, ForegroundService::class.java))
            } catch (e: Exception) {
                Toast.makeText(context, R.string.err_service_failed, Toast.LENGTH_LONG).show()
            }
        }
    }
}
