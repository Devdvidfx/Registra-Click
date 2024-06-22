package org.controle.registraclick.p;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Funcionario {
    private final SimpleBooleanProperty retirou;
    private final SimpleBooleanProperty devolucao;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty funcao;
    private final SimpleIntegerProperty matricula;
    private final SimpleIntegerProperty patrimonio;
    private final SimpleBooleanProperty selected;

    public Funcionario(String funcao, int matricula, String nome, int patrimonio, boolean selected) {
        this.selected = new SimpleBooleanProperty(false);
        this.retirou = new SimpleBooleanProperty(false);
        this.devolucao = new SimpleBooleanProperty(false);
        this.funcao = new SimpleStringProperty(funcao);
        this.matricula = new SimpleIntegerProperty(matricula);
        this.nome = new SimpleStringProperty(nome);
        this.patrimonio = new SimpleIntegerProperty(patrimonio);
        initializeListeners();
    }

    private void initializeListeners() {
        selected.addListener((obs, oldValue, newValue) -> {
            setRetirou(newValue);
            setDevolucao(newValue);
        });
        selected.bindBidirectional(retirou);
        selected.bindBidirectional(devolucao);
    }

    public boolean isSelected() {
        return selected.get();
    }

    public SimpleBooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public boolean isRetirou() {
        return retirou.get();
    }

    public SimpleBooleanProperty retirouProperty() {
        return retirou;
    }

    public void setRetirou(boolean retirou) {
        this.retirou.set(retirou);
    }

    public boolean isDevolucao() {
        return devolucao.get();
    }

    public SimpleBooleanProperty devolucaoProperty() {
        return devolucao;
    }

    public void setDevolucao(boolean devolucao) {
        this.devolucao.set(devolucao);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getFuncao() {
        return funcao.get();
    }

    public SimpleStringProperty funcaoProperty() {
        return funcao;
    }

    public int getMatricula() {
        return matricula.get();
    }

    public SimpleIntegerProperty matriculaProperty() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula.set(matricula);
    }
    public int getPatrimonio() {
        return patrimonio.get();
    }
}
