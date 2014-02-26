/**   Copyright (C) 2013  Louis Teboul (a.k.a Androguide)
 *
 *    admin@pimpmyrom.org  || louisteboul@gmail.com
 *    http://pimpmyrom.org || http://androguide.fr
 *    71 quai Clémenceau, 69300 Caluire-et-Cuire, FRANCE.
 *
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License along
 *      with this program; if not, write to the Free Software Foundation, Inc.,
 *      51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 **/

package com.androguide.honamicontrol.cards;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.androguide.honamicontrol.helpers.CPUHelper;
import com.fima.cardsui.R;
import com.fima.cardsui.objects.Card;

public class CardSwitchPlugin extends Card {
    private Switch theSwitch;

    public CardSwitchPlugin(String title, String desc, String color, String prop, ActionBarActivity fa, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super(title, desc, color, prop, fa, onCheckedChangeListener);
    }

    @Override
    public View getCardContent(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_switch, null);

        assert v != null;
        ((TextView) v.findViewById(R.id.title)).setText(title);
        ((TextView) v.findViewById(R.id.title)).setTextColor(Color.parseColor(color));
        ((TextView) v.findViewById(R.id.desc)).setText(desc);
        theSwitch = (Switch) v.findViewById(R.id.toggle);
        int isOn = Integer.valueOf(CPUHelper.readOneLine(prop));
        if (isOn == 1)
            ((Switch) v.findViewById(R.id.toggle)).setChecked(true);

        ((Switch) v.findViewById(R.id.toggle)).setOnCheckedChangeListener(onCheckedChangeListener);
        return v;
    }

    public int getCardContentId() {
        return R.layout.card_switch;
    }

    public Switch getSwitch() {
        return theSwitch;
    }

    @Override
    public boolean convert(View convertCardView) {
        return true;
    }
}
