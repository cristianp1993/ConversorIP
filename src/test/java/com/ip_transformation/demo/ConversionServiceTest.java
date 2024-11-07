package com.ip_transformation.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ConversionServiceTest {

    private final ConversionService conversionService = new ConversionService();

    // Prueba para el metodo performConversion con "Decimal a Binario"
    @Test
    public void testPerformConversionDecimalToBinary() {
        String result = conversionService.performConversion("10", "Decimal a Binario");
        assertEquals("1010", result);
    }

    // Prueba para el método convertDecimalToBinary
    @Test
    public void testConvertDecimalToBinary() {
        String result = conversionService.convertDecimalToBinary("15");
        assertEquals("1111", result); // 15 en decimal es 1111 en binario
    }

    @Test
    public void testPerformConversionDecimalToHexadecimal() {
        String result = conversionService.performConversion("45", "Decimal a Hexadecimal");
        assertEquals("2D", result);
    }

    // Prueba para el metodo performConversion con "Hexadecimal a Decimal"
    @Test
    public void testPerformConversionHexadecimalToDecimal() {
        String result = conversionService.performConversion("PRUEBA", "Hexadecimal a Decimal");
        assertEquals("Conversión no soportado", result);
    }

    @Test
    public void testPerformConversionIPtoBinary() {
        String result = conversionService.performConversion("192.168.10.5", "IP a Binario");
        assertEquals("11000000.10101000.00001010.00000101", result);
    }


    // Prueba para el metodo performConversion con un tipo de conversión no soportado
    @Test
    public void testPerformConversionUnsupportedType() {
        String result = conversionService.performConversion("10", "Conversion no soportada");
        assertEquals("Tipo de conversión no soportado", result);
    }
}