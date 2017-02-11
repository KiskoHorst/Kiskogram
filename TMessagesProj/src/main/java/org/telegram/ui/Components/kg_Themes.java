package org.telegram.ui.Components;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.LocaleController;
import org.telegram.messenger.R;
import org.telegram.messenger.volley.toolbox.AndroidAuthenticator;

/**
 * Created by Kisko on 30.10.2016.
 */
public class kg_Themes {

    static SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", Activity.MODE_PRIVATE);
    public static int currentTheme = preferences.getInt("kg_theme", 0);
    public static int count = 3;

    public static final int BACKGROUND = 0;
    public static final int DRAWER_BACKGROUND = 1;
    public static final int DRAWER_DIVIDER = 2;
    public static final int DRAWER_TEXT = 3;
    public static final int TOOLBAR = 4;
    public static final int TOOLBAR_TEXT_PRIMARY = 5;
    public static final int TOOLBAR_TEXT_SECONDARY = 6;

    public static final int TEXT_PRIMARY = 7;
    public static final int TEXT_SECONDARY = 8;
    public static final int TEXT_HINT = 9;
    public static final int TEXT_ACCENT = 10;

    public static final int DIALOGS_MESSAGE_NOALPHA = 11;

    public static final int COMPOSE_PANEL = 12;

    public static final int GREYSECTION = 13;
    public static final int GREYSECTION_TEXT = 14;

    public static String getThemeName(int id) {
        switch (id) {
            case 0: return LocaleController.getString("Theme_Light", R.string.Theme_Light);
            case 1: return LocaleController.getString("Theme_Dark", R.string.Theme_Dark);
            case 2: return LocaleController.getString("Theme_Black", R.string.Theme_Black);
        }
        return "wat";
    }

    public static void setCurrentTheme(int id) {
        //currentTheme = id;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("kg_theme", id);
        editor.commit();
    }

    public static int getColor(int i) {
        switch (i) {
            case BACKGROUND:
                switch (currentTheme){
                    case 0:
                        return 0xFFFFFFFF;
                    case 1:
                        return 0xFF303030;
                    case 2:
                        return 0xFF000000;
                }
            case GREYSECTION:
                switch (currentTheme){
                    case 0:
                        return 0xFFf2f2f2;
                    case 1:
                        return 0xFF404040;
                    case 2:
                        return 0xFF2B2B2B;
                }
            case GREYSECTION_TEXT:
                switch (currentTheme){
                    case 0:
                        return 0xFF8a8a8a;
                    case 1:
                        return 0xFF9E9E9E;
                    case 2:
                        return 0xFF8E8E8E;
                }
            case DIALOGS_MESSAGE_NOALPHA:
                switch (currentTheme){
                    case 0:
                        return 0xFF757575;
                    case 1:
                        return 0xFFC1C1C1;
                    case 2:
                        return 0xFFB3B3B3;
                }
            case TOOLBAR_TEXT_PRIMARY:
                return 0xFFFFFFFF;
            case TOOLBAR_TEXT_SECONDARY:
                return 0x7FFFFFFF;
            case TEXT_PRIMARY:
                switch (currentTheme){
                    case 0:
                        return 0xDD000000;
                    case 1:
                        return 0xFFFFFFFF;
                    case 2:
                        return 0xFFFFFFFF;
                }
            case TEXT_SECONDARY:
                switch (currentTheme){
                    case 0:
                        return 0x8A000000;
                    case 1:
                        return 0xB3FFFFFF;
                    case 2:
                        return 0xB3FFFFFF;
                }
            case TEXT_HINT:
                switch (currentTheme){
                    case 0:
                        return 0x61000000;
                    case 1:
                        return 0x7FFFFFFF;
                    case 2:
                        return 0x7FFFFFFF;
                }
            case DRAWER_BACKGROUND: //LaunchActivity, listView.setBackgroundColor, 320
                switch (currentTheme){
                    case 0:
                        return 0xFFFFFFFF;
                    case 1:
                        return 0xFF303030;
                    case 2:
                        return 0xFF000000;
                }
            case DRAWER_DIVIDER: //DividerCell, paint.setColor, 26
                switch (currentTheme){
                    case 0:
                        return 0x1F000000;
                    case 1:
                        return 0x1FFFFFFF;
                    case 2:
                        return 0x1FFFFFFF;
                }
            case DRAWER_TEXT: //DrawerActionCell, textView.setTextColor, 30
                switch (currentTheme){
                    case 0:
                        return 0xff444444;
                    case 1:
                        return 0xFFFFFFFF;
                    case 2:
                        return 0xFFFFFFFF;
                }
            case TOOLBAR: //Theme, public static final int ACTION_BAR_COLOR, 31
                switch (currentTheme){
                    case 0:
                        return 0xFF527DA3;
                    case 1:
                        return 0xFF354756;
                    case 2:
                        return 0xFF354756;
                }
            case COMPOSE_PANEL: //Theme, public static final int ACTION_BAR_COLOR, 31
                switch (currentTheme){
                    case 0:
                        return 0xFFFFFFFF;
                    case 1:
                        return 0xFF303030;
                    case 2:
                        return 0xFF000000;
                }
        }
        return 0;
    }

    public static int getDrawable(String name, Context ctx) {
        int a = 0;
        switch (currentTheme) {
            case 0:
                return (ctx.getResources().getIdentifier(name, "drawable", "li.peeloi.kisko.kiskogram"));
            case 1:
                a = (ctx.getResources().getIdentifier(name+"_dark", "drawable", "li.peeloi.kisko.kiskogram"));
                if (a != 0) {
                    return a;
                } else {
                    return (ctx.getResources().getIdentifier(name, "drawable", "li.peeloi.kisko.kiskogram"));
                }
            case 2:
                a = (ctx.getResources().getIdentifier(name+"_black", "drawable", "li.peeloi.kisko.kiskogram"));
                if (a != 0) {
                    return a;
                } else {
                    a = (ctx.getResources().getIdentifier(name+"_dark", "drawable", "li.peeloi.kisko.kiskogram"));
                    if (a != 0) {
                        return a;
                    } else {
                        return (ctx.getResources().getIdentifier(name, "drawable", "li.peeloi.kisko.kiskogram"));
                    }
                }
        }
        return a;
    }

    public static int getAlertDialogTheme(int i) {
        if (i>=1) {
            return AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        } else {
            return AlertDialog.THEME_DEVICE_DEFAULT_LIGHT;
        }
    }
}
