package net.pilsfree.smsjizdenka

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class SMSWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.s_m_s_widget)

    views.setOnClickPendingIntent(R.id.widget_p35,
        smsPendingIntent(context,0, smsIntent("PMDP35M")))

    views.setOnClickPendingIntent(R.id.widget_p24,
        smsPendingIntent(context,1, smsIntent("PMDP24H")))

    views.setOnClickPendingIntent(R.id.widget_v35,
        smsPendingIntent(context,2, smsIntent("PMDP35MV")))

    views.setOnClickPendingIntent(R.id.widget_pv65,
        smsPendingIntent(context,3, smsIntent("PMDP65MV")))


    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}

fun smsIntent(text : String) : Intent {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse("smsto:90206")
    intent.putExtra("sms_body",text)
    return intent
}

fun smsPendingIntent(context: Context,rq:Int,intent: Intent) : PendingIntent {
    return PendingIntent.getActivity(context,rq,intent,0)
}