package xyz.ksharma.composemultiplatform

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import xyz.ksharma.composemultiplatform.splash.ServiceAlertScreen
import xyz.ksharma.composemultiplatform.splash.HomeScreen

@Composable
fun ComposeNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier.fillMaxSize(),
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onClick = {
                    navController.navigate(
                        route = ServiceAlertRoute(
                            alertsJsonList = serviceAlert1.map { it.toJsonString() },
                        ),
                        navOptions = NavOptions.Builder()
                            .setLaunchSingleTop(true)
                            .build(),
                    )
                },
            )
        }

        composable<ServiceAlertRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<ServiceAlertRoute>()

            route.alertsJsonList.forEach { alertJson ->
                println(alertJson)
            }

            ServiceAlertScreen(
                alerts = route.alertsJsonList.size,
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}

@Serializable
private data object HomeRoute

@Serializable
internal data class ServiceAlertRoute(
    val alertsJsonList: List<String>,
)


val serviceAlert1 = listOf(
    ServiceAlert(
        heading = "Marayong Station Lift 1 between the concourse and Railway Rd is not available",
        message = "At Marayong Station Lift 1 between the concourse and Railway Rd is temporarily out of service.\nFrom Monday 16 December to Sunday 29 December, the lift will be closed for maintenance. \nDirect lift access is still available from Harvey Road to the concourse. \nFrom Railway Road, follow the signs to the underpass, to access the lift on Harvey Road\nIf you need help, ask staff or phone 02 9851 7241."
    ),
    ServiceAlert(
        heading = "Lidcombe Station Lift 1 between the concourse and Platform 1 is not available",
        message = "At Lidcombe Station Lift 1 between the concourse and Platform 1 is temporarily out of service.\n\nIf you need help, ask staff or phone 02 9752 8432."
    ),
    ServiceAlert(
        heading = "Liverpool Station Lift 4 between the concourse and Bus Stand E is not available",
        message = "At Liverpool Station Lift 4 between the concourse and Bus Stand E is temporarily out of service.\n\nIf you need help, ask staff or phone 02 9765 1655."
    )
)

val serviceAlert2 = listOf(
    ServiceAlert(
        heading = "Marayong Station Lift 1 between the concourse and Railway Rd is not available",
        message = "At Marayong Station Lift 1 between the concourse and Railway Rd is temporarily out of service.\nFrom Monday 16 December to Sunday 29 December, the lift will be closed for maintenance. \nDirect lift access is still available from Harvey Road to the concourse. \nFrom Railway Road, follow the signs to the underpass, to access the lift on Harvey Road\nIf you need help, ask staff or phone 02 9851 7241."
    ),
    ServiceAlert(
        heading = "Opal can be used between Bathurst and Lithgow Stations when booked",
        message = "<p>If travelling by Coach to or from Bathurst you can use your <a href=\"https://transportnsw.info/opal\" target=\"_blank\" rel=\"noopener\">Opal card</a> or <a href=\"https://transportnsw.info/tickets-opal/opal/contactless-payments\">contactless card or device</a> to tap on or off at Bathurst station and your origin/destination station provided the origin/destination is an <a href=\"https://transportnsw.info/stops\">Opal enabled station</a>. When using Opal you will need to reserve a seat, at no cost, through the Contact Centre by calling <a href=\"tel:132232\">13 22 32</a> (Between 07:00 to 22:00 each day). <br /><br /></p>"
    ),
    ServiceAlert(
        heading = "Bathurst Bullet temporary timetable changes on Wednesdays",
        message = "<div><strong>From Wednesday 13 November until 26 March 2025</strong>, some timetables will change on Wednesdays for an Indian Pacific trial.</div>\n<div>&nbsp;</div>\n<div>See <a href=\"https://transportnsw.info/trip#/trip\">TripPlanner</a> and other <a href=\"https://transportnsw.info/apps\">transport apps</a> for up-to-date service times.</div>\n<div>&nbsp;</div>\n<div><strong>Timetable changes:</strong></div>\n<ul>\n<li>06:00 Lithgow to Bathurst service will now depart Lithgow at 5.36am and depart earlier at all stations including Rydal (5.55am) and Tarana (6.11am), arriving in Bathurst at 6.44am.</li>\n<li>07:40 Bathurst to Sydney Terminal service will continue to depart Bathurst at 7.40am but will arrive at Sydney Terminal earlier at 11.20am instead of 11.52am.</li>\n<li>The 15:52 Sydney Terminal to Bathurst service will now depart earlier from Sydney Terminal at 3pm and depart earlier at all stations including Parramatta (3.22pm), Penrith (3.46pm), Springwood (4.08pm), Katoomba (4.42pm), Mt Victoria (4.58pm) Lithgow (5.24pm), Rydal (5.41pm) and Tarana (6.14pm), arriving in Bathurst at 6.47pm.&nbsp;</li>\n<li>The 20:25 Bathurst to Lithgow service will now depart Bathurst at 7.22pm, Tarana 7.54pm, Rydal 8.10pm and arriving at Lithgow 8.29pm.</li>\n</ul>"
    ),
    ServiceAlert(
        heading = "Trains may run to a changed timetable and stopping pattern",
        message = "<div><strong>Monday 16 to Friday 20 December</strong> </div>\n<ul>\n<li>Due to trackwork at Central, platforms 1-12, trains may run to a reduced frequency or changed timetable and stopping pattern. <br /><br /></li>\n<li><strong>Friday from 11.30pm</strong>, trains run between Blue Mountains Line stations and the City Circle.<br /><br /></li>\n<li>Replacement buses for trackwork may be affected by driver shortages. We are doing all we can to minimise the impact to your journey and provide a safe service, however cancellations or delays may occur.</li>\n<li><a href=\"https://transportnsw.info/trip#/trip\">Plan your trip</a> before you travel for up-to-date real time information. You can also subscribe to <a href=\"https://transportnsw.info/travel-info/ways-to-get-around/train/about-trackwork#subscribe\">planned trackwork alerts</a>.</li>\n</ul>"
    ),
    ServiceAlert(
        heading = "Some services on this line may not be wheelchair accessible.",
        message = "<div>Please contact NSW TrainLink on 131 500 ahead of your journey to confirm if your trip will be accessible.</div>"
    ),
    ServiceAlert(
        heading = "Westmead Station Lift 2 between the concourse and Platform 3/4 is not available",
        message = "At Westmead Station Lift 2 between the concourse and Platform 3/4 is temporarily out of service.\n\nIf you need help, ask staff or phone 02 9848 9116."
    ),
    ServiceAlert(
        heading = "Platforms may change. Check indicator screens and listen for announcements",
        message = "<div>&nbsp; &nbsp;</div>"
    )
)
