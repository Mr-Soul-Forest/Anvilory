package forgeofovorldule.anvilory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun PlotsContent(viewModel: AppViewModel) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(UIC_light)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.4.dp)
                .padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(29.6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(UIC, RoundedCornerShape(47.6.dp))
                    .padding(start = 19.6.dp, end = 9.2.dp)
                    .height(48.4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = ts_Your_plots,
                    color = UIC_extra_dark,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = JetBrainsFont(),
                    fontSize = 19.2.sp,
                    modifier = Modifier.weight(1f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.2.dp)
                ) {
                    Box(
                        modifier = Modifier.size(35.6.dp)
                            .background(UIC_extra_light, RoundedCornerShape(35.6.dp))
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = languages.toString(),
                            color = UIC_light,
                            fontWeight = FontWeight.Normal,
                            fontFamily = JetBrainsFont(),
                            fontSize = 21.2.sp
                        )
                    }
                    Box(
                        modifier = Modifier.size(35.6.dp)
                            .background(UIC_extra_light, RoundedCornerShape(35.6.dp))
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "+",
                            color = UIC_light,
                            fontWeight = FontWeight.Normal,
                            fontFamily = JetBrainsFont(),
                            fontSize = 30.sp
                        )
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.8.dp),
                modifier = Modifier.verticalScroll(rememberScrollState())
                    .padding(horizontal = 19.6.dp)
            ) {
                for (item in plots) {
                    OnePlotBlock(item)
                }
            }
        }
    }
}

@Composable
private fun OnePlotBlock(plot: Plot) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.4.dp),
        modifier = Modifier.height(201.6.dp)
            .fillMaxWidth()
            .background(UIC_extra_light, RoundedCornerShape(18.8.dp))
            .padding(18.8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.weight(0.66f)
            ) {
                Text(
                    text = plot.title + " ",
                    color = UIC,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = JetBrainsFont(),
                    fontSize = 19.2.sp,
                )
                Text(
                    text = "-> " + if (plot.typeOfPlot == TypeOfPlot.STORY) ts_story else ts_movie,
                    color = UIC,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraLight,
                    fontFamily = JetBrainsFont(),
                    fontSize = 14.4.sp,
                )
            }
            Box(
                modifier = Modifier.height(25.2.dp)
                    .background(UIC_light, RoundedCornerShape(12.6.dp))
                    .weight(0.33f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${
                        Clock.System.now()
                            .toLocalDateTime(TimeZone.currentSystemDefault()).date.toEpochDays() - plot.lastEdit.toEpochDays()
                    } $ts_days_ago",
                    color = UIC_extra_light,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Normal,
                    fontFamily = JetBrainsFont(),
                    fontSize = 12.8.sp,
                    modifier = Modifier.padding(horizontal = 12.6.dp)
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "$ts_Description:",
                color = UIC_light,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = JetBrainsFont(),
                fontSize = 13.2.sp
            )
            Text(
                text = plot.description,
                color = UIC_light,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Normal,
                fontFamily = JetBrainsFont(),
                fontSize = 12.8.sp
            )
            for (chapter in plot.chapters) {
                Text(
                    text = "${chapter.title}:",
                    color = UIC_light,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = JetBrainsFont(),
                    fontSize = 13.2.sp
                )
                for (pair in chapter.pairs) {
                    Text(
                        text = pair.text,
                        color = UIC_light,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Normal,
                        fontFamily = JetBrainsFont(),
                        fontSize = 12.8.sp
                    )
                }
            }
        }
    }
}