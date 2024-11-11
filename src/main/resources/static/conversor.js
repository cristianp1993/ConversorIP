function validateInput() {
    const conversionType = document.getElementById("conversionType").value;
    const inputValue = document.getElementById("inputValue").value;
    const errorMessage = document.getElementById("error-message");
    errorMessage.textContent = "";

    const decimalRegex = /^[0-9]+$/;
    const binaryRegex = /^[01]+$/;
    const hexRegex = /^[0-9a-fA-F]+$/;
    const ipRegex = /^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])(\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}$/;

    // Validacion con cada tipo
    if ((conversionType === "Decimal a Binario" || conversionType === "Decimal a Hexadecimal" || conversionType === "Decimal a IP") && !decimalRegex.test(inputValue)) {
        errorMessage.textContent = "Solo se permiten números para la conversión desde Decimal.";
        return false;
    } else if ((conversionType === "Binario a Decimal" || conversionType === "Binario a Hexadecimal") && !binaryRegex.test(inputValue)) {
        errorMessage.textContent = "Solo se permiten 0 y 1 para la conversión desde Binario.";
        return false;
    } else if ((conversionType === "Hexadecimal a Decimal" || conversionType === "Hexadecimal a Binario") && !hexRegex.test(inputValue)) {
        errorMessage.textContent = "Solo se permiten caracteres hexadecimales (0-9, A-F) para la conversión desde Hexadecimal.";
        return false;
    } else if ((conversionType === "IP a Binario" || conversionType === "IP a Decimal" || conversionType === "IP a Hexadecimal") && !ipRegex.test(inputValue)) {
        errorMessage.textContent = "Formato IP no válido. Use el formato correcto, por ejemplo, 192.168.1.1.";
        return false;
    }
    
    errorMessage.textContent = "";
    return true;
}

function validateForm() {
    return validateInput();
}