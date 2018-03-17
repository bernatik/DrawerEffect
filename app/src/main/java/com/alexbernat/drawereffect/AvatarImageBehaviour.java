package com.alexbernat.drawereffect;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

/**
 * Created by alexbernat on 17.02.18.
 */

public class AvatarImageBehaviour extends CoordinatorLayout.Behavior<ImageView>{

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        return dependency instanceof Toolbar;

    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);

    }
}
