public class Apartamento extends Imovel {

    private final double TAXA_CONDOMINIO = 500;
    private final double ALIQUOTA = 0.004;
    private final double DESCONTO = 0.05;

    public Apartamento(double valorVenda, int ano, int qtdBeneficios, Endereco endereco) {
        super(valorVenda, ano, qtdBeneficios, endereco);
    }

    @Override
    public double defineValorDesconto() {
        double descontoTotal = ((2023 - this.ano) / 5) * this.DESCONTO;
        if (descontoTotal > this.MAX_DESCONTO) {
            descontoTotal = 0.3;
        }
        return descontoTotal;
    }

    @Override
    public double calculaValorAluguel() {
        double valorAluguel;
        if (this.defineValorDesconto() != 0) {
            valorAluguel = ((this.valorVenda * this.ALIQUOTA) + (this.VALOR_BENEFICIO * this.qtdBeneficios) + this.TAXA_CONDOMINIO) * defineValorDesconto();
        } else {
            valorAluguel = (this.valorVenda * this.ALIQUOTA) + (this.VALOR_BENEFICIO * this.qtdBeneficios) + this.TAXA_CONDOMINIO;
        }

        return valorAluguel;
    }

    @Override
    public String enderecoFormatado() {
        StringBuilder aux = new StringBuilder();
        aux.append(this.endereco.getRua().toUpperCase() + ", " + this.endereco.getBairro().toUpperCase() +
                ", " + this.endereco.getNumero() + ", " + this.endereco.getApartamento().toUpperCase());

        return aux.toString();
    }
}