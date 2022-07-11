package org.koil.public

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

data class IndexViewModel(val allCards: List<Card>)

@Controller
class PublicController {
    @GetMapping("/")
    fun index(): ModelAndView {
        val model = IndexViewModel(Card.values().toList())
        return ModelAndView("pages/index", mapOf("model" to model))
    }
}
