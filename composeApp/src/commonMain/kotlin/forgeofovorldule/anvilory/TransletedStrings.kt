package forgeofovorldule.anvilory

var ts_New_plot = "New plot"
var ts_This_is_an_example_story = "This is an example story"
var ts_New_chapter = "New chapter"
var ts_loading = "loading"
var ts_app_icon = "app icon"

fun changeLanguage() {
    if (languages == Languages.RU) {
        ts_New_plot = "Новый сюжет"
        ts_This_is_an_example_story = "Это пример истории"
        ts_New_chapter = "Новая глава"
        ts_loading = "загрузка"
        ts_app_icon = "иконка приложения"
    } else {
        ts_New_plot = "New plot"
        ts_This_is_an_example_story = "This is an example story"
        ts_New_chapter = "New chapter"
        ts_loading = "loading"
        ts_app_icon = "app icon"
    }
}