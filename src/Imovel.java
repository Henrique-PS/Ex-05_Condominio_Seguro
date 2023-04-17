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
    private int id;
    private static int cont = 0;
    protected int idProprietario;

    public Imovel(double valorVenda, int ano, int qtdBeneficios, int idProprietario) {
        Imobiliaria imobiliaria;

        this.valorVenda = valorVenda;
        this.ano = ano;
        this.qtdBeneficios = qtdBeneficios;
        this.endereco = endereco;
        this.cont++;
        this.id = cont;
        this.idProprietario = idProprietario;
    }

    public int getId() {
        return id;
    }

    public double calculaValorDesconto(){
        return this.descontoTotal;
    }

    public double calculaValorAluguel(){
        return this.valorAluguel;
    }

    public Endereco enderecoImovel(Endereco novoEndereco){
        return this.endereco;
    }

    public String enderecoFormatado(){
        return this.enderecoFormatado;
    }
}
