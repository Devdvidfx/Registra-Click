package org.controle.normaeng;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.*;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<Funcionario> tabela;
    @FXML
    private TableColumn<Funcionario, Boolean> selectCol;
    @FXML
    private TableColumn<Funcionario, String> nomeCol;
    @FXML
    private TableColumn<Funcionario, String> funcaoCol;
    @FXML
    private TableColumn<Funcionario, Integer> matriculaCol;
    @FXML
    private TableColumn<Funcionario, Integer> patrimonioCol;
    @FXML
    private CheckBox Devolver;
    @FXML
    private CheckBox Retirar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectCol.setCellValueFactory(new PropertyValueFactory<>("selected"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        funcaoCol.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        matriculaCol.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        patrimonioCol.setCellValueFactory(new PropertyValueFactory<>("patrimonio"));

        tabela.setItems(listaDeFuncionarios());
        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));
        nomeCol.setCellFactory(TextFieldTableCell.forTableColumn());

        tabela.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                newSelection.selectedProperty().set(true);
            }
        });
    }

    ObservableList<Funcionario> funcionariosSelecionados = FXCollections.observableArrayList();

    @NotNull
    private ObservableList<Funcionario> listaDeFuncionarios() {
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();
        funcionarios.add(new Funcionario("Bombeiro Civil", 45548, "Fulano", 4777, false));
        funcionarios.add(new Funcionario("Eletricista", 47581, "Ciclano", 5454, false));
        funcionarios.add(new Funcionario("Eng Mec", 21648, "Beltrano", 5457, false));
        funcionarios.add(new Funcionario("Artifice", 87451, "Bebel", 15154, false));
        funcionarios.add(new Funcionario("Recepcionista", 54787, "Suu", 54541, false));
        return funcionarios;
    }

    @FXML
    protected void onConfirmarButtonClick() {
        funcionariosSelecionados.addAll(tabela.getItems().stream()
                .filter(Funcionario::isSelected)
                .toList());

        System.out.println("Funcionários selecionados: " + funcionariosSelecionados);

        if (funcionariosSelecionados.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um funcionário para a retirada.");
            alert.showAndWait();
            return;
        }

        if (Retirar.isSelected() && Devolver.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Apenas uma ação pode ser selecionada");
            alert.setContentText("Por favor, selecione apenas uma das opções: retirada ou devolução.");
            alert.showAndWait();
            return;
        }

        if (Retirar.isSelected()) {
            Alert confirmarRetirada = new Alert(Alert.AlertType.INFORMATION);
            confirmarRetirada.setTitle("Normatel Engenharia");
            confirmarRetirada.setContentText("Retirada confirmada com sucesso!");
            confirmarRetirada.showAndWait();
            funcionariosSelecionados.forEach(funcionario -> funcionario.setRetirou(true));
        } else if (Devolver.isSelected()) {
            Alert confirmarDevolucao = new Alert(Alert.AlertType.INFORMATION);
            confirmarDevolucao.setTitle("Normatel Engenharia");
            confirmarDevolucao.setContentText("Devolução confirmada com sucesso!");
            confirmarDevolucao.showAndWait();
            funcionariosSelecionados.forEach(funcionario -> funcionario.setDevolucao(true));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Nenhuma ação selecionada");
            alert.setContentText("Por favor, selecione uma das opções: retirada ou devolução.");
            alert.showAndWait();
        }

        salvarEmExcel(funcionariosSelecionados);
        System.out.println("Dados da tabela: " + tabela.getItems());
    }

    @FXML
    protected void salvarEmExcel(ObservableList<Funcionario> funcionarios) {
        String[] colunas = {"Data", "Nome", "Função", "Patrimônio", "Ação"};

        try (XSSFWorkbook planilha = obterOuCriarPlanilhaExistente()) {
            XSSFCellStyle estiloData = planilha.createCellStyle();
            DataFormat formatoData = planilha.createDataFormat();
            estiloData.setDataFormat(formatoData.getFormat("dd/MM/yyyy"));

            planilha.getSheet("Relatório dos registros de celulares" + 1);
            XSSFSheet folhaDeRegistros;

            folhaDeRegistros = planilha.createSheet("Relatório dos registros de celulares");
            XSSFRow linhaCabecalho = folhaDeRegistros.createRow(0);
            for (int i = 0; i < colunas.length; i++) {
                XSSFCell celula = linhaCabecalho.createCell(i++);
                celula.setCellValue(colunas[i++]);
            }

            int numeroDeLinhas = folhaDeRegistros.getLastRowNum() + 1;
            for (Funcionario funcionario : funcionarios) {
                XSSFRow linha = folhaDeRegistros.createRow(numeroDeLinhas++);
                linha.createCell(0).setCellValue(LocalDate.now().toString());
                linha.createCell(1).setCellValue(funcionario.getNome());
                linha.createCell(2).setCellValue(funcionario.getFuncao());
                linha.createCell(3).setCellValue(funcionario.getPatrimonio());
                linha.createCell(4).setCellValue(funcionario.isRetirou() ? "Retirada" : funcionario.isDevolucao() ? "Devolução" : "Nenhuma ação especificada");
            }

            try (FileOutputStream saidaDeArquivo = new FileOutputStream("relatorio.xlsx"+1)) {
                planilha.write(saidaDeArquivo);
            } catch (IOException ex) {
                throw new RuntimeException("Erro ao salvar o arquivo Excel: " + ex.getMessage(), ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao abrir ou criar o arquivo Excel: " + ex.getMessage(), ex);
        }
    }

    private XSSFWorkbook obterOuCriarPlanilhaExistente() {
        File arquivo = new File("relatorio.xlsx");
        if (arquivo.exists()) {
            try (FileInputStream fis = new FileInputStream(arquivo)) {
                return new XSSFWorkbook(fis);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao abrir o arquivo Excel existente: " + e.getMessage(), e);
            }
        } else {
            return new XSSFWorkbook();
        }
    }
}