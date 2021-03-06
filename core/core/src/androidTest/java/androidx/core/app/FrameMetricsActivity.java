/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.core.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class FrameMetricsActivity extends Activity {

    LinearLayout mLayout;
    View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        mLayout = new LinearLayout(this);
        mLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mLayout.setBackgroundColor(Color.BLUE);
        setContentView(mLayout);

        mView = new View(this);
        mView.setLayoutParams(new LinearLayout.LayoutParams(500, 500));
        mView.setBackgroundColor(Color.GREEN);
        mLayout.addView(mView);
    }

    public void invalidate() {
        mLayout.invalidate();
        mLayout.setBackgroundColor(Color.rgb((int) (255 * Math.random()),
                (int) (255 * Math.random()), (int) (255 * Math.random())));
    }
}
