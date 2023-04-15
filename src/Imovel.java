public abstract class Imovel {
    protected Endereco endereco;
    protected double valorVenda;
    protected int ano;
    private double valorAluguel;
    protected final double VALOR_BENEFICIO = 100;
    protected final double MAX_DESCONTO = 0.3;
    private double descontoTotal;
    private String enderecoFormatado;


    public Imovel(double valorVenda, int ano, Endereco endereco) {
        this.valorVenda = valorVenda;
        this.ano = ano;
        this.endereco = endereco;
    }

    public double defineValorDesconto(){
        return this.descontoTotal;
    }

    public double calculaValorAluguel(int qtdBeneficios){
        return this.valorAluguel;
    }

    public String enderecoFormatado(){
        return this.enderecoFormatado;
    }
}
