package com.sophia.simuladordefrete.frete

import com.sophia.simuladordefrete.model.ResultadoFrete
import com.sophia.simuladordefrete.model.TipoFrete

class CalculadoraFrete {

    fun calcular(
        tipo: TipoFrete,
        pesoKg: Double,
        distanciaKm: Double
    ): ResultadoFrete{

        val resultado = when(tipo) {

            TipoFrete.ECONOMICO -> ResultadoFrete(
                valor = 8 + 3 * pesoKg + 0.10 * distanciaKm,
                prazoDias = 5
            )

            TipoFrete.EXPRESSO -> ResultadoFrete(
                valor = 20 + 5 * pesoKg + 0.25 * distanciaKm,
                prazoDias = 2
            )

            TipoFrete.RETIRADA -> ResultadoFrete(
                valor = 0.0 ,
                prazoDias = 1
            )

        }

        return resultado

    }
}