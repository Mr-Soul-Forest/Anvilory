package forgeofovorldule.anvilory

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class Plot(
    var title: String = ts_New_plot,
    var description: String = ts_This_is_an_example_story,
    var typeOfPlot: TypeOfPlot = TypeOfPlot.STORY
) {
    var maxChapterIndex = 0
    var chapters = mutableListOf(Chapter())
    var lastEdit: LocalDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
}