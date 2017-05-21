package com.andrepaiva.f1info.ui.listeners;

import com.andrepaiva.f1info.data.model.ApiEntities.Constructor;
import com.andrepaiva.f1info.data.model.ApiEntities.Race;

/**
 * Created by andre on 13/05/2017.
 */

public interface OnCalendarItemClick {
    void onCalendarClick(Race race);
}
