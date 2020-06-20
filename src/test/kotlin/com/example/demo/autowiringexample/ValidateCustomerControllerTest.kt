package com.example.demo.autowiringexample

import com.example.demo.autowiringexample.validators.PanValidator
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters

@WebFluxTest(ValidateCustomerController::class)
class ValidateCustomerControllerTest(
    @Autowired val webTestClient: WebTestClient,
    @Autowired val panValidator: PanValidator
) {

    @Test
    fun `validate customer`() {

        val body = Customer(
            "Vinay",
            "01/01/1990",
            "ABCDM1234D",
            "G0000000"
        )
        every { panValidator.validate(any()) } returns true
        webTestClient.post()
            .uri("/customer/validate")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(body))
            .exchange()
            .expectStatus().is2xxSuccessful

    }

    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun panValidator() = mockk<PanValidator>()
    }
}