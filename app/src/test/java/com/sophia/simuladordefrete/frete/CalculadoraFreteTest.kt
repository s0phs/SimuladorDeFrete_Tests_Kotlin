package com.sophia.simuladordefrete.frete

import com.sophia.simuladordefrete.model.TipoFrete
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculadoraFreteTest {

    private val calculadoraFrete = CalculadoraFrete()
    @Test
    fun `frete economico deve calcular valor pelo peso e a distancia`(){
        //Arrange
        val peso = 2.0
        val distanciaKm = 100.0

        // Act
        val resultado = calculadoraFrete.calcular(
            TipoFrete.EXPRESSO,
            pesoKg = peso,
            distanciaKm = distanciaKm
        )

        //Assert
        assertEquals(
            22.0,
            resultado.valor,
            0.01 //aceita uma diferença de 0.01 do valor esperado
        )

        assertEquals(
            5,
            resultado.prazoDias
        )
    }

    @Test
    fun `peso zero deve gerar erro`(){
        assertThrows(IllegalArgumentException::class.java){
            calculadoraFrete.calcular(
                TipoFrete.ECONOMICO,
                pesoKg = 0.0,
                distanciaKm = 100.0
            )
        }
    }

}