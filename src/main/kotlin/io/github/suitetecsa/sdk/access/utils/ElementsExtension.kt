package io.github.suitetecsa.sdk.access.utils

import org.jsoup.nodes.Element
import org.jsoup.select.Elements

private const val ELEMENT_INDEX = 5

internal operator fun Elements.component6(): Element = this[ELEMENT_INDEX]
