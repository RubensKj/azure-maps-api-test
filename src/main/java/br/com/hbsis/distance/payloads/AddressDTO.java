package br.com.hbsis.distance.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {

    @NotNull
    @NotBlank
    private String rua;
    @NotNull
    @NotBlank
    private String bairro;
    @NotNull
    private UF estado;
    @NotNull
    @NotBlank
    private String cidade;
    @NotNull
    @NotBlank
    private String cep;
    @NotNull
    @NotBlank
    private String pais;
}
