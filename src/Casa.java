public class Casa extends Imovel{
    private double seguroIncendio;
    private final double ALIQUOTA = 0.005;
    private final double DESCONTO = 0.1;
    private Endereco enderecoCasa;


    //#region Contrutores

    /**
     * Cria uma nova casa
     * @param valorVenda Valor de venda da casa
     * @param ano Ano de construção da casa
     * @param qtdBeneficios Quantidades de benefícios que a casa possui
     * @param seguroIncendio Valor do seguro incêndio
     */
    public Casa(double valorVenda, int ano, int qtdBeneficios, double seguroIncendio) {
        super(valorVenda, ano, qtdBeneficios);
        this.seguroIncendio = seguroIncendio;
        this.enderecoCasa = enderecoCasa;
    }
    //#endregion

    //#region Métodos de negócio

    /**
     * Calcula o valor do desconto no aluguel da casa, com base no ano em que a casa foi construída
     * @return A porcentagem total a ser descontada dividida por 100
     */
    @Override
    public double calculaValorDesconto(){
        double descontoTotal = ((2023 - this.ano) / 5) * this.DESCONTO;
        if (descontoTotal > this.MAX_DESCONTO){
            descontoTotal = 0.3;
        }
        return descontoTotal;
    }

    public double valorMensalSeguro() {
        return this.seguroIncendio / 12;
    }

    /**
     * Calcula o valor do aluguel da casa com base no valor da alíquota sobre o valor de venda do imóvel,
     * a quantidade bnenefícios e o desconto aplicado à casa
     * @return O valor do aluguel da casa
     */
    @Override
    public double calculaValorAluguel(){
        double valorAluguel;
        if(this.calculaValorDesconto() != 0){
            valorAluguel = ((this.valorVenda * this.ALIQUOTA) + (this.VALOR_BENEFICIO * this.qtdBeneficios)
                    + valorMensalSeguro()) * calculaValorDesconto();
        } else {
            valorAluguel = (this.valorVenda * this.ALIQUOTA) + (this.VALOR_BENEFICIO * this.qtdBeneficios)
                    + valorMensalSeguro();
        }
        return Math.round(valorAluguel * 100.0)/100.0;
    }

    /**
     * Cria um endereço para a casa, onde temos a rua, bairro e número da casa
     * @param novoEndereco Informções do endereço da casa
     * @return O endereço da casa
     */
    @Override
    public Endereco enderecoImovel(Endereco novoEndereco){
        this.enderecoCasa = new Endereco(novoEndereco.getRua(), novoEndereco.getBairro(), novoEndereco.getNumero());
        return this.enderecoCasa;
    }

    /**
     * Foramata o endereço da casa. Formato:
     * <this.endereco.getRua.toUpperCase>, <this.endereco.getBairro.toUpperCase>,
     * <this.endereco.getNumero>
     * @return String no formato indicado
     */
    @Override
    public String enderecoFormatado(){
        StringBuilder aux = new StringBuilder();
        aux.append(enderecoCasa.getRua().toUpperCase() + ", " + enderecoCasa.getBairro().toUpperCase() +
                ", " + enderecoCasa.getNumero());

        return aux.toString();
    }
}
