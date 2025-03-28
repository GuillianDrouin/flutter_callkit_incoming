package com.hiennv.flutter_callkit_incoming

import android.content.Context
import android.content.Intent
import android.os.Bundle

object AppUtils {
    fun getAppIntent(context: Context, action: String? = null, data: Bundle? = null): Intent? {
        val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)?.cloneFilter()
        val flag =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT or Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_FROM_BACKGROUND or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent?.addFlags(flag)
        intent?.putExtra(FlutterCallkitIncomingPlugin.EXTRA_CALLKIT_CALL_DATA, data)
        intent?.action = action
        return intent
    }
}