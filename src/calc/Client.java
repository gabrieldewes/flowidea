package calc;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Autor: gabriel, em 23/04/16.
 */
class Client {

    public static void main(String args[]) throws Exception {
        URL url = new URL("http://localhost:9000/calc?wsdl");
        QName qname = new QName("http://calc/","CalculadoraServerImplService");
        Service ws = Service.create(url, qname);
        CalculadoraServer calc = ws.getPort(CalculadoraServer.class);

        float a = 1, b = 2;
        System.out.println("Soma ("+a+"+"+b+"): "+ calc.soma(a,b));
        System.out.println("Subtração ("+a+"-"+b+"): "+ calc.subtracao(a,b));
        System.out.println("Multiplicação ("+a+"*"+b+"): "+ calc.multiplicacao(a,b));
        System.out.println("Divisão ("+a+"/"+b+"): "+ calc.divisao(a,b));

    }
}