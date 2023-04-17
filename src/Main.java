public class Main {
    public static void main(String[] args) {

        Imobiliaria imobiliariaTest = new Imobiliaria();
        Imovel casaTest1 = new Casa(500000, 2000, 2, 500, 1);
        System.out.println(casaTest1.getId());
        Imovel casaTest2 = new Casa(675000, 2017, 1, 500, 2);
        System.out.println(casaTest2.getId());
        Imovel ap1 = new Apartamento(800000, 2020, 3, 1);
        System.out.println(ap1.getId());
        Proprietario prop1 = new Proprietario("Prop1");
        Proprietario prop2 = new Proprietario("Prop2");

        imobiliariaTest.addImovel(casaTest1);
        imobiliariaTest.addImovel(casaTest2);
        imobiliariaTest.addImovel(ap1);
        imobiliariaTest.addProprietario(prop1);

        System.out.println(casaTest2.calculaValorAluguel());
    }
}