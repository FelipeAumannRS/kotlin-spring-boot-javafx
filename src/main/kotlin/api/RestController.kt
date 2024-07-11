package api

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MyRestController {

    data class Message(val text: String)

    @GetMapping("/hello")
    fun hello(): Message {
        println("asdasdasd");
        return Message("Hello, World!")
    }

    @PostMapping("/echo")
    fun echo(@RequestBody message: Message): Message {
        return message
    }
}