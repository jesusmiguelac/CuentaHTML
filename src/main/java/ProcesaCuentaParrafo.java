import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class ProcesaCuentaParrafo  extends HTMLEditorKit.ParserCallback {

    private int contador ;
    private int contadorpalabras;
    private boolean inParagraph;

    public ProcesaCuentaParrafo() {
        contador = 0;
        inParagraph = false;
    }

    @Override
    public void handleText(char[] data, int pos) {
        if( inParagraph ) {
            String texto = new String(data);
            contadorpalabras = (texto.split("\\s+")).length;
            System.out.println("El número de palabras en el párrafo " +(contador+1)+ " es de "+contadorpalabras);
        }
    }

    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if( t == HTML.Tag.P ) {
            inParagraph = true;
        }
    }

    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if( t == HTML.Tag.P ) {
            inParagraph = false;
            contador++;
        }
        if( t == HTML.Tag.BODY ) {
            System.out.printf("Total de parrafos en documento: %d%n", contador);
        }
    }

}
