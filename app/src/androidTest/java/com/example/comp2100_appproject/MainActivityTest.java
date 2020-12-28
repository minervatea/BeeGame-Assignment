package com.example.comp2100_appproject;

import android.app.Activity;
import android.content.Context;
import android.renderscript.ScriptGroup;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@MediumTest
@RunWith(AndroidJUnit4.class)
public class  MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);
    public ActivityTestRule<Registration> rule2 = new ActivityTestRule<Registration>(Registration.class);

    @Test
    public void loginTest() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        MainActivity activity = rule.getActivity();
        View username = activity.findViewById(R.id.username);
        View password = activity.findViewById(R.id.password);

        assertThat(username,notNullValue());
        assertThat(password,notNullValue());

        Button button  = (Button) activity.findViewById(R.id.login);
        EditText user = (EditText) activity.findViewById(R.id.username);
        EditText pass = (EditText) activity.findViewById(R.id.password);


        button.callOnClick();
        assertFalse(activity.succeed);

    }

}
