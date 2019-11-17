package exceptions;

public class ExcecaoFormulario extends Exception {
    public ExcecaoFormulario(String msg){
        super(msg);
    }

    public ExcecaoFormulario(){
        super();
    }
}
