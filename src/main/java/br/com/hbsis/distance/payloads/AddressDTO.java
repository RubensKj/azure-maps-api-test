package br.com.hbsis.distance.payloads;

public class AddressDTO {

    private String rua;
    private String bairro;
    private String estado;
    private String cidade;
    private String cep;
    private String pais;

    public AddressDTO() {
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getPais() {
        return pais;
    }
}
