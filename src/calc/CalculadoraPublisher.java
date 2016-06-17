package calc;

import javax.xml.ws.Endpoint;

/**
 * Autor: gabriel, em 23/04/16.
 */
public class CalculadoraPublisher {

    public static void main(String[] args)  {
        Endpoint.publish("http://localhost:9000/calc", new CalculadoraServerImpl());
    }
}
