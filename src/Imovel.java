public abstract class Imovel {
    private Endereco endereco;
    private double valorVenda;
    private int ano;
    private double valorAluguel;
    protected final double VALOR_VENEFICIO = 100;
    protected final double MAX_DESCONTO = 0.3;
    protected final double DESCONTO = 0.05;


    public Imovel(double valorVenda, int ano) {
        this.valorVenda = valorVenda;
        this.ano = ano;
    }

    public double calculaValorAluguel(int qtdBeneficios){
        return valorAluguel;
    }

    public Endereco definirEnderco(){
        return endereco;
    }
}
