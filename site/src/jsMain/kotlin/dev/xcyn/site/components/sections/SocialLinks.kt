package dev.xcyn.site.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.xcyn.site.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px

@Composable
fun SocialLinks() {
    val sitePalette = ColorMode.current.toSitePalette()

    Column(Modifier.fillMaxSize().gap(0.75.cssRem)) {
        SpanText("Socials", Modifier
            .color(sitePalette.text)
            .fontSize(0.9.cssRem))

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
            platform = "Email",
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

    Link(
        url,
        Modifier.fillMaxWidth(),
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant)
    ) {
        Row(Modifier.gap(1.cssRem), verticalAlignment = Alignment.CenterVertically) {
            Image(
                "https://cdn.jsdelivr.net/npm/simple-icons@v16/icons/$icon.svg",
                platform,
                Modifier
                    .color(sitePalette.subtext)
                    .size(20.px)
            )
            SpanText(platform, Modifier.color(sitePalette.subtext).width(6.cssRem))
            SpanText(handle, Modifier.color(sitePalette.text))
        }
    }
}