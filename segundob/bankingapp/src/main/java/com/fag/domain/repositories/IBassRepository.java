package com.fag.domain.repositories;

import com.fag.domain.dto.BankslipDTO;

public interface IBassRepository {

    String consultarBoleto(String linhaDigitavel);

    String pagarBoleto(BankslipDTO dadosBoletoConsultado);

    String gerarQRCode(Double valorPix);

}
