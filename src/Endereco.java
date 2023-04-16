public class Endereco {
    private String rua;
    private String bairro;
    private String numero;
    private String apartamento;


    //#region Contrutores

    /**
     * Cria um novo endereço para uma Casa
     * @param rua Rua onde a casa se localiza
     * @param bairro Bairro onde a casa se localiza
     * @param numero Número da casa
     */
    public Endereco(String rua, String bairro, String numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    /**
     * Cria um novo endereço para um Apartamento
     * @param rua Rua onde o apartamento se localiza
     * @param bairro Bairro onde o apartamento se localiza
     * @param numero Número do prédio do apartamento
     * @param apartamento Número do apartamento
     */
    public Endereco(String rua, String bairro, String numero, String apartamento) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.apartamento = apartamento;
    }
    //#endregion

    //#region getters

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
    //#endregion
}
