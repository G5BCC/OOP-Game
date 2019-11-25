package formulario.botoes;

import formulario.Formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeitorBotoesSair implements ActionListener {
    private Formulario form;

    public LeitorBotoesSair(Formulario form){
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        form.sairFormulario();
    }
}
