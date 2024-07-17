import androidx.compose.runtime.Composable
import ui.LaunchScreen

class FeatureLaunch: Feature {

    override fun route(argument: String?): String = "launch"
    @Composable override fun screen() = LaunchScreen()

}