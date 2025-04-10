package model.common;

import java.util.regex.Pattern;

public class Cpf {
    private static final Pattern FORMATTED_OR_RAW_CPF = Pattern.compile("^(\\d{3}\\.?){3}-?\\d{2}$");
    private final String cpf;

    public Cpf(String cpf) throws Exception {
        validate(cpf);
        this.cpf = normalize(cpf);
    }


    private void validate(String cpf) throws Exception {
        if (FORMATTED_OR_RAW_CPF.matcher(cpf).matches() == false) {
            throw new Exception("Invalid cpf format.");
        }

        String normalized = normalize(cpf);

        if (normalized.matches("(\\d)\\1{10}")) {
            throw new Exception("Invalid CPF: all digits are equal.");
        }

        if (!isValidDigits(normalized)) {
            throw new Exception("Invalid CPF: check digits do not match.");
        }
    }

    private String normalize(String cpf) {
        return cpf.replaceAll("[^\\d]", "");
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

    public String getCpf() {
        return cpf;
    }
}
