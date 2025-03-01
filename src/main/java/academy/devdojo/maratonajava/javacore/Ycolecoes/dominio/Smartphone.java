package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }
    //Regras do hashCode()
    //Se x.equals(y) == true, y.hashcode() == x.hashCode()
    //Se y.hashCode() == x.hashCode() nao necessariamente o equals de y.equals(x) tem que ser true
    //Se x.equals(y) == false
    //Se y.hashCode() != x.hashCode() x.equals(y) devera ser false
    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) { //Exemplo x.equals(y), nesse caso this é o x , e o obj é o y
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Smartphone smartphone = (Smartphone) obj; //Cast Explicito (estou garantindo pro compilador que obj é um smartphone
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }



    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
