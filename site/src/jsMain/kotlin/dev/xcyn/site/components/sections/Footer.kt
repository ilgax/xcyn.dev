package dev.xcyn.site.components.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.style.vars.color.ColorVar
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.xcyn.site.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Span

val FooterStyle = CssStyle.base {
    Modifier
        .padding(topBottom = 1.5.cssRem)
        .scale(0.85)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(FooterStyle.toModifier().then(modifier), contentAlignment = Alignment.Center) {
        Span(Modifier.textAlign(TextAlign.Center).toAttrs()) {
            val sitePalette = ColorMode.current.toSitePalette()
            Link(
                "https://github.com/ilgax/xcyn.dev/blob/master/LICENSE",
                "MIT",
                Modifier.setVariable(ColorVar, sitePalette.brand.primary).whiteSpace(WhiteSpace.NoWrap),
                variant = UncoloredLinkVariant
            )
            SpanText(" • ", Modifier.color(sitePalette.subtext))
            Link(
                "https://github.com/ilgax/xcyn.dev",
                "Source",
                Modifier.setVariable(ColorVar, sitePalette.brand.accent).whiteSpace(WhiteSpace.NoWrap),
                variant = UncoloredLinkVariant
            )
            SpanText(" • Made with ", Modifier.whiteSpace(WhiteSpace.NoWrap).color(sitePalette.subtext))
            var clicked by remember { mutableStateOf(false) }
            var timesClicked by remember { mutableStateOf(0) }
            SpanText("❤", Modifier
                .color(if (timesClicked % 5 == 0 && timesClicked != 0) sitePalette.crust else if (clicked) sitePalette.brand.accent else sitePalette.brand.primary)
                .onClick { clicked = !clicked; timesClicked++ })
        }
    }
}
