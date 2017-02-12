/*
 * This is the source code of Telegram for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2016.
 */

package org.telegram.ui.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.LocaleController;
import org.telegram.messenger.MessagesController;
import org.telegram.messenger.R;
import org.telegram.messenger.UserConfig;
import org.telegram.ui.Cells.DrawerActionCell;
import org.telegram.ui.Cells.DividerCell;
import org.telegram.ui.Cells.EmptyCell;
import org.telegram.ui.Cells.DrawerProfileCell;
import org.telegram.ui.Components.kg_Themes;

public class DrawerLayoutAdapter extends BaseAdapter {

    private Context mContext;

    public DrawerLayoutAdapter(Context context) {
        mContext = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return !(i == 1 || i == 5);
    }

    @Override
    public int getCount() {
        return UserConfig.isClientActivated() ? 10 : 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type = getItemViewType(i);
        if (type == 0) {
            DrawerProfileCell drawerProfileCell;
            if (view == null) {
                view = drawerProfileCell = new DrawerProfileCell(mContext);
            } else {
                drawerProfileCell = (DrawerProfileCell) view;
            }
            drawerProfileCell.setUser(MessagesController.getInstance().getUser(UserConfig.getClientUserId()));
        } else if (type == 1) {
            if (view == null) {
                view = new EmptyCell(mContext, AndroidUtilities.dp(8));
            }
        } else if (type == 2) {
            if (view == null) {
                view = new DividerCell(mContext);
            }
        } else if (type == 3) {
            if (view == null) {
                view = new DrawerActionCell(mContext);
            }
            DrawerActionCell actionCell = (DrawerActionCell) view;
            if (i == 2) {
                actionCell.setTextAndIcon(LocaleController.getString("NewGroup", R.string.NewGroup), kg_Themes.getDrawable("menu_newgroup", mContext));
            } else if (i == 3) {
                actionCell.setTextAndIcon(LocaleController.getString("NewSecretChat", R.string.NewSecretChat), kg_Themes.getDrawable("menu_secret", mContext));
            } else if (i == 4) {
                actionCell.setTextAndIcon(LocaleController.getString("NewChannel", R.string.NewChannel), kg_Themes.getDrawable("menu_broadcast", mContext));
            } else if (i == 6) {
                actionCell.setTextAndIcon(LocaleController.getString("Contacts", R.string.Contacts), kg_Themes.getDrawable("menu_contacts", mContext));
            } else if (i == 7) {
                actionCell.setTextAndIcon(LocaleController.getString("InviteFriends", R.string.InviteFriends), kg_Themes.getDrawable("menu_invite", mContext));
            } else if (i == 8) {
                actionCell.setTextAndIcon(LocaleController.getString("Settings", R.string.Settings), kg_Themes.getDrawable("menu_settings", mContext));
            } else if (i == 9) {
                actionCell.setTextAndIcon(LocaleController.getString("TelegramFaq", R.string.TelegramFaq), kg_Themes.getDrawable("menu_help", mContext));
            }
        }

        return view;
    }

    @Override
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else if (i == 5) {
            return 2;
        }
        return 3;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public boolean isEmpty() {
        return !UserConfig.isClientActivated();
    }
}
