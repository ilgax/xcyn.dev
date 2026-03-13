package dev.xcyn.site.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.xcyn.site.HeadlineTextStyle
import dev.xcyn.site.components.layouts.PageLayoutData
import dev.xcyn.site.toSitePalette
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Home"))
}

@Composable
fun TagChip(text: String) {
    val sitePalette = ColorMode.current.toSitePalette()
    Box(Modifier.backgroundColor(sitePalette.surface1).padding(0.5.cssRem).borderRadius(6.px)) {
        SpanText(text, Modifier.color(sitePalette.text).fontSize(0.9.cssRem))
    }
}

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    var displayName by remember { mutableStateOf("") }
    val sitePalette = ColorMode.current.toSitePalette()
    var animatonDone by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val fullName = "xcynical"
        val shortName = "xcyn"

        delay(400)

        for (i in fullName.indices) {
            displayName = fullName.substring(0, i + 1)
            delay(120)
        }

        delay(1600)

        for (i in fullName.length downTo shortName.length) {
            displayName = fullName.substring(0, i)
            delay(80)
        }
        delay(300)
        animatonDone = true
    }

    Column(Modifier.fillMaxWidth().maxWidth(860.px).margin(leftRight = autoLength).gap(1.cssRem).padding(topBottom = 2.cssRem, leftRight = 2.cssRem)) {
        //Hero
        Row(
            Modifier.fillMaxWidth().gap(1.cssRem),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.gap(0.5.cssRem)) {
                Div(HeadlineTextStyle.toModifier().toAttrs()) {
                    SpanText("Hi, I'm ", Modifier.color(sitePalette.text))
                    SpanText(displayName + if (animatonDone) "!" else "", Modifier.color(sitePalette.brand.primary))
                }

                SpanText(
                    "Part time Kotlin nerd, full time gamer · future cybersecurity engineer", Modifier.color(sitePalette.text)
                )
            }
        Box(Modifier
            .size(100.px)
            .borderRadius(12.px)
            .backgroundColor(sitePalette.surface0)
            )
        }

        Box(Modifier.fillMaxWidth().backgroundColor(sitePalette.surface0).padding(1.5.cssRem).borderRadius(12.px)) {
            Column(Modifier.gap(1.cssRem)) {
                SpanText("About", Modifier.color(sitePalette.text).fontSize(0.9.cssRem))
                SpanText("17 year old guy from Turkey.", Modifier.color(sitePalette.subtext))
                SpanText("TODO", Modifier.color(sitePalette.text))
                Row(Modifier.gap(0.5.cssRem)) {
                    TagChip("He/Him")
                }
            }
        }
    }
}
