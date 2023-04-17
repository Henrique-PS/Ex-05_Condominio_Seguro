public class Apartamento extends Imovel {

    private final double TAXA_CONDOMINIO = 500;
    private final double ALIQUOTA = 0.004;
    private final double DESCONTO = 0.05;
    private Endereco enderecoAp;

    //#region Contrutores

    /**
     * Cria uma nova casa
     * @param valorVenda Valor de venda do apartamento
     * @param ano Ano de construção do apartamento
     * @param qtdBeneficios Quantidades de benefícios o apartamento possui
     */
    public Apartamento(double valorVenda, int ano, int qtdBeneficios, int idProprietario) {
        super(valorVenda, ano, qtdBeneficios, idProprietario);
    }
    //#endregion

    //#region Métodos de negócio

    /**
     * Calcula o valor do desconto no aluguel do apartamento, com base no ano em que o apartamento foi construído
     * @return A porcentagem total a ser descontada dividida por 100
     */
    @Override
    public double calculaValorDesconto() {
        double descontoTotal = ((2023 - this.ano) / 5) * this.DESCONTO;
        if (descontoTotal > this.MAX_DESCONTO) {
            descontoTotal = 0.3;
        }
        return descontoTotal;
    }

    /**
     * Calcula o valor do aluguel da casa com base no valor da alíquota sobre o valor de venda do imóvel,
     * a quantidade bnenefícios e o desconto aplicado à casa
     * @return O valor do aluguel do apartamento arrendondado com duas casas decimais
     */
    @Override
    public double calculaValorAluguel() {
        double valorAluguel = ((this.valorVenda * this.ALIQUOTA) + (this.VALOR_BENEFICIO * this.qtdBeneficios)
                + this.TAXA_CONDOMINIO) * (1 - calculaValorDesconto());
        return Math.round(valorAluguel * 100.0)/100.0;
    }

    /**
     * Cria um endereço para o apartamento, onde temos a rua, bairro, número do prédio
     * e o número do apartamento
     * @param novoEndereco Informções do endereço do apartamento
     * @return O endereço do apartamento
     */
    @Override
    public Endereco enderecoImovel(Endereco novoEndereco){
        this.enderecoAp = new Endereco(novoEndereco.getRua(), novoEndereco.getBairro(),
                novoEndereco.getNumero(), novoEndereco.getApartamento());
        return this.enderecoAp;
    }

    /**
     * Foramata o endereço do apartamento. Formato:
     * <this.endereco.getRua.toUpperCase>, <this.endereco.getBairro.toUpperCase>,
     * <this.endereco.getNumero>, <this.endereco.getApartamento>
     * @return String no formato indicado
     */
    @Override
    public String enderecoFormatado() {
        StringBuilder aux = new StringBuilder();
        aux.append(this.enderecoAp.getRua().toUpperCase() + ", " + this.enderecoAp.getBairro().toUpperCase() +
                ", " + this.enderecoAp.getNumero() + ", " + this.enderecoAp.getApartamento().toUpperCase());

        return aux.toString();
    }
}