package dev.xcyn.site.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.xcyn.site.toSitePalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val SocialPlatformStyle = CssStyle {
    val sitePalette = colorMode.toSitePalette()
    base {
        Modifier
            .backgroundColor(sitePalette.base)
            .border(1.px, LineStyle.Solid, sitePalette.mantle)
            .borderRadius(12.px)
            .padding(topBottom = 0.1.cssRem, leftRight = 0.5.cssRem)
            //.width(9.cssRem)
            .styleModifier { property("transition", "color 200ms") }
    }
    hover {
        Modifier.color(sitePalette.brand.primary)
    }
}

val SocialHandleStyle = CssStyle {
    val sitePalette = colorMode.toSitePalette()
    base {
        Modifier
            .backgroundColor(sitePalette.base)
            .border(1.px, LineStyle.Solid, sitePalette.mantle)
            .borderRadius(12.px)
            .padding(topBottom = 0.1.cssRem, leftRight = 0.5.cssRem)
            .styleModifier { property("transition", "color 200ms") }
    }
    hover {
        Modifier.color(sitePalette.brand.primary)
    }
}

@Composable
fun SocialLinks() {
    val sitePalette = ColorMode.current.toSitePalette()

    Column(Modifier.fillMaxWidth().gap(0.4.cssRem)) {
        SpanText("Socials", Modifier
            .color(sitePalette.text)
            .fontSize(1.2.cssRem))

        SocialLink(
            icon = "github",
            platform = "GitHub",
            handle = "ilgax",
            url = "https://github.com/ilgax"
        )
        SocialLink(
            icon = "discord",
            platform = "Discord",
            handle = ".xcynical",
            url = "https://discord.com/users/781961041452990464"
        )
        SocialLink(
            icon = "protonmail",
            platform = "Mail",
            handle = "hello@xcyn.dev",
            url = "mailto:hello@xcyn.dev"
        )
        /*SocialLink(
            icon = "nexusmods",
            platform = "NexusMods",
            handle = "ilgax",
            url = "https://www.nexusmods.com/profile/ilgax"
        )

         */
        SocialLink(
            icon = "modrinth",
            platform = "Modrinth",
            handle = "xcyn",
            url = "https://modrinth.com/user/xcyn"
        )
    }
}

@Composable
private fun SocialLink(icon: String, platform: String, handle: String, url: String) {
    val sitePalette = ColorMode.current.toSitePalette()
    val isLight = ColorMode.current.isLight

    Row(Modifier.gap(0.5.cssRem), verticalAlignment = Alignment.CenterVertically) {
        Box(
            SocialPlatformStyle.toModifier()
        ) {
            Row(Modifier.gap(0.35.cssRem), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    "https://cdn.jsdelivr.net/npm/simple-icons@v16/icons/$icon.svg",
                    platform,
                    Modifier
                        .size(20.px)
                        .styleModifier { property("filter", if (isLight) "none" else "invert(1)") }
                )
                SpanText(platform, Modifier.color(sitePalette.subtext).whiteSpace(WhiteSpace.NoWrap))
            }
        }

        Link(url, variant = UndecoratedLinkVariant.then(UncoloredLinkVariant)) {
            Box(
                SocialHandleStyle.toModifier()
            ) {
                SpanText(handle, Modifier.whiteSpace(WhiteSpace.NoWrap))
            }
        }
    }
}