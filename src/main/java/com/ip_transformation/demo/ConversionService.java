package com.ip_transformation.demo;

import org.springframework.stereotype.Service;

import static java.lang.Integer.*;

@Service
public class ConversionService {

    public String performConversion(String value, String conversionType) {
        switch (conversionType) {
            case "Decimal a Binario":
                return convertDecimalToBinary(value);
            case "Decimal a Hexadecimal":
                return convertDecimalToHexadecimal(value);
            case "Binario a Decimal":
                return convertBinaryToDecimal(value);
            case "Binario a Hexadecimal":
                return convertBinaryToHexadecimal(value);
            case "Hexadecimal a Decimal":
                return convertHexadecimalToDecimal(value);
            case "Hexadecimal a Binario":
                return convertHexadecimalToBinary(value);
            case "Decimal a IP":
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
    public String convertDecimalToBinary(String value) {
        return toBinaryString(parseInt(value));
    }

    private String convertDecimalToHexadecimal(String value) {
        return toHexString(parseInt(value)).toUpperCase();
    }

    private String convertBinaryToDecimal(String value) {
        return Integer.toString(parseInt(value, 2));
    }

    private String convertBinaryToHexadecimal(String value) {
        return toHexString(parseInt(value, 2)).toUpperCase();
    }

    private String convertHexadecimalToDecimal(String value) {
        return Integer.toString(parseInt(value, 16));
    }

    private String convertHexadecimalToBinary(String value) {
        return toBinaryString(parseInt(value, 16));
    }

    private String convertToIP(String value) {
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
            String hexValue = String.format("%02X", decimalValue);
            hexIp.append(hexValue).append(":");
        }

        return hexIp.toString().substring(0, hexIp.length() - 1);
    }
}
