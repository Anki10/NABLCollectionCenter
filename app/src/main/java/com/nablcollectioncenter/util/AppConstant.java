package com.nablcollectioncenter.util;

import java.util.List;

/**
 * Created by raj on 3/19/2018.
 */

public class AppConstant {

    public final static String PREF_NAME = "com.NABL.prefs";
    public final static String DEFAULT_VALUE = "";
    public final static String NO_INTERNET_CONNECTED = "Please check your internet connection and try again.\n";

    public final static String accessToken = "AccessToken";

    public final static String[][] QUESTIONS = {{
            "Type of the collection centre/source of sample",
            "Size of premises",
            "Average Number of patients per day",
            "Does it meet the requirement of the workload?",
            "Reception and waiting area separate from collection area",
            "Hand washing facility",
            "Clean toilet facility on site ",
            "Provision of privacy during collections",
            "Hours of operation have been displayed"
    }, {

            "Is it adequately lit and clean",
            "Is the humidity and temperature suitable",
            "Are cleaning policies available",
            "Is it adequately ventilated and prevented from dust",
            "Does it have adequate space and separation to avoid cross contamination",
            "Is the house keeping adequate"}
    };


    public final static String[][][] OPTIONS = {
            {
                    {
                            "Owned",
                            "Managed",
                            "Franchise",
                            "Any other source of sample collection which is not categorized above"

                    },
                    {
                            "Owned",
                            "Managed",
                            "Franchise",
                            "Any other source of sample collection which is not categorized above"
                    },
                    {
                            "Owned",
                            "Managed",
                            "Franchise",
                            "Any other source of sample collection which is not categorized above"
                    }

            },
            {
                    {
                            "Owned",
                            "Managed",
                            "Franchise",
                            "Any other source of sample collection which is not categorized above"
                    },
                    {
                            "Owned",
                            "Managed",
                            "Franchise",
                            "Any other source of sample collection which is not categorized above"
                    }
            }
    };
}
