package com.ip_transformation.demo;

import org.springframework.stereotype.Service;

import static java.lang.Integer.*;

@Service
public class ConversionService {
    public String performConversion(String value, String conversionType) {
        switch (conversionType) {
            case "Binario":
                return convertToBinary(value);
            case "Decimal":
                return convertToDecimal(value);
            case "Hexadecimal":
                return convertToHexadecimal(value);
            case "IP":
                return convertToIP(value);
            case "IP a Binario":
                return convertIpToBinary(value);
            case "IP a Decimal":
                return Long.toString(convertIpToDecimal(value));
            case "IP a Hexadecimal":
                return convertIpToHexadecimal(value);
            default:
                return "Tipo de conversión no soportado";
        }
    }

    // Métodos de conversión
    private String convertToBinary(String value) {
        return toBinaryString(parseInt(value));
    }

    private String convertToDecimal(String value) {
        return Integer.toString(parseInt(value, 2));
    }

    private String convertToHexadecimal(String value) {
        return toHexString(parseInt(value));
    }

    private String convertToIP(String value) {
        // Ejemplo: convertir un valor entero a una IP (IPv4)
        int num = parseInt(value);
        return ((num >> 24) & 0xFF) + "." +
                ((num >> 16) & 0xFF) + "." +
                ((num >> 8) & 0xFF) + "." +
                (num & 0xFF);
    }
    private String convertIpToBinary(String ip) {
        StringBuilder binaryIp = new StringBuilder();
        String[] octets = ip.split("\\.");

        for (String octet : octets) {
            int decimalValue = parseInt(octet);
            String binaryValue = String.format("%08d", parseInt(toBinaryString(decimalValue)));
            binaryIp.append(binaryValue).append(".");
        }

        return binaryIp.toString().substring(0, binaryIp.length() - 1);
    }

    private long convertIpToDecimal(String ip) {
        String[] octets = ip.split("\\.");
        long decimalValue = 0;

        for (int i = 0; i < octets.length; i++) {
            decimalValue += (parseInt(octets[i]) << (8 * (3 - i)));
        }

        return decimalValue;
    }

    private String convertIpToHexadecimal(String ip) {
        StringBuilder hexIp = new StringBuilder();
        String[] octets = ip.split("\\.");

        for (String octet : octets) {
            int decimalValue = parseInt(octet);
            String hexValue = String.format("%02X", decimalValue); // Asegura que tenga 2 dígitos
            hexIp.append(hexValue).append(":");
        }

        return hexIp.toString().substring(0, hexIp.length() - 1); // Elimina el último dos puntos
    }
}
