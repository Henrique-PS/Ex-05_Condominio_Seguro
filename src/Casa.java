public class Casa extends Imovel{
    private double seguroIncendio;
    private final double ALIQUOTA = 0.005;
    private final double DESCONTO = 0.1;

    public Casa(double valorVenda, int ano, Endereco endereco, double seguroIncendio) {
        super(valorVenda, ano, endereco);
        this.seguroIncendio = seguroIncendio;
    }

    @Override
    public double defineValorDesconto(){
        double descontoTotal = ((2023 - this.ano) / 5) * this.DESCONTO;
        if (descontoTotal > this.MAX_DESCONTO){
            descontoTotal = 0.3;
        }
        return descontoTotal;
    }

    @Override
    public double calculaValorAluguel(int qtdBeneficios){
        double valorAluguel;
        if(this.defineValorDesconto() != 0){
            valorAluguel = ((this.valorVenda * this.ALIQUOTA) + (this.VALOR_BENEFICIO * qtdBeneficios) + valorMensalSeguro()) * defineValorDesconto();
        } else {
            valorAluguel = (this.valorVenda * this.ALIQUOTA) + (this.VALOR_BENEFICIO * qtdBeneficios) + valorMensalSeguro();
        }

        return valorAluguel;
    }

    public double valorMensalSeguro() {
        return this.seguroIncendio / 12;
    }

    @Override
    public String enderecoFormatado(){
        StringBuilder aux = new StringBuilder();
        aux.append(this.endereco.getRua().toUpperCase() + ", " + this.endereco.getBairro().toUpperCase() +
                ", " + this.endereco.getNumero());

        return aux.toString();
    }
}
