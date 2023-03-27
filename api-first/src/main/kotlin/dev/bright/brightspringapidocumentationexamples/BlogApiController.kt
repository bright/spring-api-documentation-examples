package dev.bright.brightspringapidocumentationexamples

import dev.bright.rest.BlogsV2Api
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.NativeWebRequest
import java.util.*

@RestController
@Validated
class BlogApiController(private val request: Optional<NativeWebRequest>) : BlogsV2Api {
    override fun getRequest(): Optional<NativeWebRequest> = request
}
