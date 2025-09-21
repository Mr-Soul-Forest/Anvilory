/**Copyright 2025 Forge-of-Ovorldule (https://github.com/Forge-of-Ovorldule) and Mr-Soul-Forest (https://github.com/Mr-Soul-Forest)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package forgeofovorldule.anvilory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

var edit_plot = 0

@Composable
fun ChaptersContent(viewModel: AppViewModel) {
    val plot = plots[edit_plot]
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
                    .padding(horizontal = 9.2.dp)
                    .height(48.4.dp),
                horizontalArrangement = Arrangement.spacedBy(7.2.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.size(35.6.dp)
                        .background(UIC_extra_light, RoundedCornerShape(35.6.dp))
                        .clickable {
                            viewModel.setStatus(AppStatus.PLOTS_UPDATER)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "<-",
                        color = UIC_light,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = JetBrainsFont(),
                        fontSize = 21.2.sp
                    )
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = plot.title,
                        color = UIC_extra_dark,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = JetBrainsFont(),
                        fontSize = 19.2.sp,
                    )
                }
                CreateChapterDialog(viewModel)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.8.dp),
                modifier = Modifier.verticalScroll(rememberScrollState())
                    .padding(horizontal = 19.6.dp)
            ) {
                for (item in 0..<plot.chapters.size) {
                    OneChapterBlock(item, viewModel)
                }
            }
        }
    }
}

@Composable
private fun OneChapterBlock(index: Int, viewModel: AppViewModel) {
    val chapter = plots[edit_plot].chapters[index]
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.4.dp),
        modifier = Modifier.height(201.6.dp)
            .fillMaxWidth()
            .background(UIC_extra_light, RoundedCornerShape(18.8.dp))
            .clip(RoundedCornerShape(18.8.dp))
            .clickable {
                edit_chapter = index
                viewModel.setStatus(AppStatus.PARTS)
            }
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
                    text = chapter.title + " ",
                    color = UIC,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = JetBrainsFont(),
                    fontSize = 19.2.sp,
                )
                Text(
                    text = "-> " + chapter.parts.size + " $ts_parts",
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
                            .toLocalDateTime(TimeZone.currentSystemDefault()).date.toEpochDays() - chapter.lastEdit.toEpochDays()
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
            for (index in 0..<chapter.parts.size) {
                Text(
                    text = "$ts_Part $index:",
                    color = UIC_light,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = JetBrainsFont(),
                    fontSize = 13.2.sp
                )
                Text(
                    text = chapter.parts[index].text,
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

@Composable
private fun CreateChapterDialog(viewModel: AppViewModel) {
    var show by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.size(35.6.dp)
            .background(UIC_extra_light, RoundedCornerShape(35.6.dp))
            .clickable { show = true },
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

    var chapter by remember { mutableStateOf(Chapter()) }
    var chapterTitle by remember { mutableStateOf(chapter.title) }

    if (show) {
        AlertDialog(
            containerColor = UIC_light,
            onDismissRequest = { show = false },
            title = {
                Text(
                    text = if (plots[edit_plot].typeOfPlot == TypeOfPlot.STORY) ts_Create_a_chapter else ts_Create_a_series,
                    color = UIC,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = JetBrainsFont(),
                    fontSize = 19.2.sp
                )
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(10.4.dp),
                        modifier = Modifier.height(201.6.dp)
                            .fillMaxWidth()
                            .background(UIC_extra_light, RoundedCornerShape(18.8.dp))
                            .padding(18.8.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(10.4.dp),
                            modifier = Modifier.height(201.6.dp)
                                .fillMaxWidth()
                                .background(UIC_extra_light, RoundedCornerShape(18.8.dp))
                                .clip(RoundedCornerShape(18.8.dp))
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
                                        text = "$chapterTitle ",
                                        color = UIC,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = JetBrainsFont(),
                                        fontSize = 19.2.sp,
                                    )
                                    Text(
                                        text = "-> " + chapter.parts.size + " $ts_parts",
                                        color = UIC,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontWeight = FontWeight.ExtraLight,
                                        fontFamily = JetBrainsFont(),
                                        fontSize = 14.4.sp,
                                    )
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                for (index in 0..<chapter.parts.size) {
                                    Text(
                                        text = "$ts_Part $index:",
                                        color = UIC_light,
                                        overflow = TextOverflow.Ellipsis,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = JetBrainsFont(),
                                        fontSize = 13.2.sp
                                    )
                                    Text(
                                        text = chapter.parts[index].text,
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
                    Text(
                        text = ts_Title,
                        color = UIC,
                        fontWeight = FontWeight.Normal,
                        fontFamily = JetBrainsFont(),
                        fontSize = 13.2.sp,
                        textAlign = TextAlign.Center
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .background(UIC_extra_light, RoundedCornerShape(18.8.dp))
                            .padding(18.8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        BasicTextField(
                            value = chapterTitle,
                            onValueChange = {
                                chapterTitle = it
                                chapter.title = it
                            },
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(
                                color = UIC,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = JetBrainsFont(),
                                fontSize = 19.2.sp
                            ),
                            singleLine = true,
                            decorationBox = {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    it()
                                }
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )
                    }
                }
            },
            confirmButton = {
                Row {
                    Box(
                        Modifier.clickable {
                            show = false
                            plots[edit_plot].chapters.add(chapter)
                            viewModel.setStatus(AppStatus.CHAPTERS_UPDATER)
                        }
                            .background(UIC, RoundedCornerShape(18.8.dp))
                            .weight(0.5f)
                            .padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = ts_Create,
                            color = UIC_light,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Normal,
                            fontFamily = JetBrainsFont(),
                            fontSize = 16.sp
                        )
                    }
                    Box(
                        Modifier.clickable {
                            show = false
                        }
                            .background(UIC, RoundedCornerShape(18.8.dp))
                            .weight(0.5f)
                            .padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = ts_Cancel,
                            color = UIC_light,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Normal,
                            fontFamily = JetBrainsFont(),
                            fontSize = 16.sp
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}