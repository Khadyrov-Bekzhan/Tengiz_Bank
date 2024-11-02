package com.example.kaspi.ui.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.kaspi.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionNavigationHomeToStoreFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_storeFragment)

    public fun actionNavigationHomeToDevicesFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_devicesFragment)

    public fun actionNavigationHomeToDocumentsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_documentsFragment)

    public fun actionNavigationHomeToTransactionsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_transactionsFragment)

    public fun actionNavigationHomeToArticlesFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_articlesFragment)

    public fun actionNavigationHomeToTravelFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_travelFragment)

    public fun actionNavigationHomeToGovermentFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_govermentFragment)

    public fun actionNavigationHomeToStatisticsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_statisticsFragment)

    public fun actionNavigationHomeToKaspiFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_kaspiFragment)

    public fun actionNavigationHomeToHalykFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_halykFragment)

    public fun actionNavigationHomeToAmazonFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_amazonFragment)

    public fun actionNavigationHomeToMagnumFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_magnumFragment)
  }
}
