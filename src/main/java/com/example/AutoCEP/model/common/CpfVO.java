package com.example.AutoCEP.model.common;

import com.example.AutoCEP.exepction.cpf.CpfErrorCode;
import com.example.AutoCEP.exepction.cpf.InvalidCpfExecption;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class CpfVO {

    @Pattern(regexp = "^(\\d{3}\\.?){3}-?\\d{2}$")
    private String cpf;

    public CpfVO() {
    }

    public CpfVO(String cpf) throws Exception {
        validate(cpf);
        this.cpf = normalize(cpf);
    }

    private boolean isValidDigits(String cpf) {
        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * (10 - i); /* converte o caractere para número e multiplica pelo peso (de 10 a 2) */
            }
            int dig1 = 11 - (sum % 11); /* calcula o primeiro dígito verificador com base na soma */
            if (dig1 >= 10) dig1 = 0; /* Se o resultado for maior ou igual a 10, o dígito verificador é 0 */

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * (11 - i);
            }
            int dig2 = 11 - (sum % 11); /* calcula o segundo dígito verificador */
            if (dig2 >= 10) dig2 = 0;

            return cpf.charAt(9) - '0' == dig1 && cpf.charAt(10) - '0' == dig2;
        } catch (Exception e) {
            return false;
        }
    }

    private String normalize(String cpf) {
        return cpf.replaceAll("[^\\d]", "");
    }

    private void validate(String cpf) throws InvalidCpfExecption {

        String normalized = normalize(cpf);

        if (normalized.matches("(\\d)\\1{10}")) {
            throw new InvalidCpfExecption(CpfErrorCode.ALL_DIGITS_EQUALS);
        }

        if (!isValidDigits(normalized)) {
            throw new InvalidCpfExecption(CpfErrorCode.INVALID_VERF_DIGITS);
        }
    }



    public String getValue() {
        return cpf;
    }
}
