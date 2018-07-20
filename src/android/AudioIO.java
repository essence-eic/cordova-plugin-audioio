package com.eic.plugin.audioio;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

public class AudioIO extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, 
                CallbackContext callbackContext) throws JSONException {	
            if (action.equals("enableSpeaker")) {
                enableSpeaker(args.getString(0));
                return true;
            }
            if (action.equals("setMicrophoneMute")) {
                setMicrophoneMute(args.getString(0));
                return true;
            }
            return false;
    }
    public boolean enableSpeaker(String on) {
        Context context = webView.getContext();
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (Boolean.valueOf(on)){
	        audioManager.setMode(AudioManager.STREAM_MUSIC);
            audioManager.setSpeakerphoneOn(true);        
        }else{
	        audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
            audioManager.setSpeakerphoneOn(false);        
        }
        Log.d("setSpeaker",on);
        return true;
    }
    public boolean setMicrophoneMute(String on) {
        Context context = webView.getContext();
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setMicrophoneMute(Boolean.valueOf(on));        
        Log.d("setMicrophoneMute",on);
        return true;
    }
}
