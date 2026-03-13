package dev.xcyn.site

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color

/**
 * @property surface0 A useful color to apply to a container that should differentiate itself from the background
 *   but just a little.
 */
class SitePalette(
    val base: Color,
    val mantle: Color ,
    val crust: Color,
    val surface0: Color,
    val surface1: Color,
    // val surface2: Color,
    val overlay0: Color,
    // val overlay1: Color,
    // val overlay2: Color,
    val text: Color,
    val subtext: Color,
    val cobweb: Color,
    val brand: Brand,
) {
    class Brand(
        val primary: Color = Color.rgb(0xCBA6F7),
        val accent: Color = Color.rgb(0x89DCEB),
    )
}

object SitePalettes {
    val light = SitePalette(
        base = Color.rgb(0xeff1f5),
        mantle = Color.rgb(0xe6e9ef),
        crust = Color.rgb(0xdce0e8),
        surface0 = Color.rgb(0xccd0da),
        surface1 = Color.rgb(0xbcc0cc),
        overlay0 = Color.rgb(0x9ca0b0),
        text = Color.rgb(0x4c4f69),
        subtext = Color.rgb(0x6c6f85),
        cobweb = Colors.LightGray,
        brand = SitePalette.Brand(
            primary = Color.rgb(0x8839ef),
            accent = Color.rgb(0x04a5e5),
        )
    )
    val dark = SitePalette(
        base = Color.rgb(0x1e1e2e),
        mantle = Color.rgb(0x181825),
        crust = Color.rgb(0x11111b),
        surface0 = Color.rgb(0x313244),
        surface1 = Color.rgb(0x45475a),
        overlay0 = Color.rgb(0x6c7086),
        text = Color.rgb(0xcdd6f4),
        subtext = Color.rgb(0xa6adc8),
        cobweb = Colors.LightGray.inverted(),
        brand = SitePalette.Brand(
            primary = Color.rgb(0xCBA6F7),
            accent = Color.rgb(0x89DCEB),
        )
    )
}

fun ColorMode.toSitePalette(): SitePalette {
    return when (this) {
        ColorMode.LIGHT -> SitePalettes.light
        ColorMode.DARK -> SitePalettes.dark
    }
}

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.background = Color.rgb(0xeff1f5)
    ctx.theme.palettes.light.color = Color.rgb(0x4c4f69)
    ctx.theme.palettes.dark.background = Color.rgb(0x1e1e2e)
    ctx.theme.palettes.dark.color = Color.rgb(0xcdd6f4)
}
