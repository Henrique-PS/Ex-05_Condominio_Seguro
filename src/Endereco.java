public class Endereco {
    private String rua;
    private String bairro;
    private String numero;
    private String apartamento;

    public Endereco(String rua, String bairro, String numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public Endereco(String rua, String bairro, String numero, String apartamento) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.apartamento = apartamento;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getApartamento() {
        return apartamento;
    }
}
