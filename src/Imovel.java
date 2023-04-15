public abstract class Imovel {
    protected Endereco endereco;
    protected double valorVenda;
    protected int ano;
    private double valorAluguel;

    protected int qtdBeneficios;
    protected final double VALOR_BENEFICIO = 100;
    protected final double MAX_DESCONTO = 0.3;
    private double descontoTotal;
    private String enderecoFormatado;


    public Imovel(double valorVenda, int ano, int qtdBeneficios, Endereco endereco) {
        this.valorVenda = valorVenda;
        this.ano = ano;
        this.endereco = endereco;
        this.qtdBeneficios = qtdBeneficios;
    }

    public double defineValorDesconto(){
        return this.descontoTotal;
    }

    public double calculaValorAluguel(){
        return this.valorAluguel;
    }

    public String enderecoFormatado(){
        return this.enderecoFormatado;
    }
}
