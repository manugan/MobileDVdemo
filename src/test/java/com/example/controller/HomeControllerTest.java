package com.example.controller;

import org.junit.Before;
import org.junit.Test;

//Spring framework specific
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Manu on 13/10/2016.
 */
public class HomeControllerTest {

    private HomeController homeController;

    @Before
    public void setHomeController() throws Exception{
        // constructor changed
       // homeController = new HomeController();
    }

    @Test
    public void shouldShowTheRightHomePageView() throws Exception {

        final String homePage = homeController.showHomepage();
        assertThat(homePage, is("home"));
    }
}
