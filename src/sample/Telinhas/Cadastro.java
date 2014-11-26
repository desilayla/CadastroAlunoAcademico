package sample.Telinhas;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Aluno.AlunoAcademico;
import sample.RegraNegocio.Regra;

public class Cadastro {

    private Stage palco;
    private VBox janela;
    private TelaEstado estadoTela = TelaEstado.INSERINDO;
    private AlunoAcademico entidade;
    private TextField edtId = new TextField();
    private TextField edtNome = new TextField();
    private TextField edtEmail = new TextField();
    private TextField edtEndereco = new TextField();
    private TextField edtCpf = new TextField();
    private TextField edtSexo = new TextField();


    public Cadastro(Stage palco) {
        this.palco = palco;

        janela = new VBox();
        Label lblId = new Label("ID:");


        edtId.promptTextProperty().setValue("Digite o ID");
        janela.getChildren().addAll(lblId, edtId);

        Label lblNome = new Label();

        lblNome.setText("Nome: ");
        janela.getChildren().add(lblNome);
        janela.getChildren().add(edtNome);

        Label lblEmail = new Label("Email:");
        edtEmail.promptTextProperty().setValue("Digite seu email");
        janela.getChildren().addAll(lblEmail, edtEmail);

        Label lblEndereco = new Label("Endereco:");
        edtEndereco.promptTextProperty().setValue("Digite seu Endereço");
        janela.getChildren().addAll(lblEndereco, edtEndereco);

        Label lblCpf = new Label("CPF:");
        edtCpf.promptTextProperty().setValue("Digite seu Cpf");
        janela.getChildren().addAll(lblCpf, edtCpf);

        Label lblSexo = new Label("Sexo:");
        edtSexo.promptTextProperty().setValue("Sexo");
        janela.getChildren().addAll(lblSexo, edtSexo);

        Button btnConfirmar = new Button("Confirmar");


        btnConfirmar.setOnAction(event -> {
            Regra regra = new Regra();

            if (estadoTela.equals(TelaEstado.INSERINDO)) {
                regra.addNovoAluno(edtId.getText(), edtNome.getText(), edtEmail.getText(), edtEndereco.getText(), edtCpf.getText(), edtSexo.getText());
                edtId.textProperty().setValue(null);
                edtNome.textProperty().setValue(null);
                edtEmail.textProperty().setValue(null);
                edtEndereco.textProperty().setValue(null);
                edtCpf.textProperty().setValue(null);
                edtSexo.textProperty().setValue(null);
            } else if (estadoTela.equals(TelaEstado.EDITANDO)) {
                regra.alterarPessoa(this.entidade);
                try {
                    abrirTelaDePesquisa(palco);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnJanelaPesquisa = new Button("Pesquisa");

        ToolBar toolBar = new ToolBar();
        toolBar.getItems().addAll(btnConfirmar, btnJanelaPesquisa);

        janela.getChildren().add(toolBar);


        btnJanelaPesquisa.setOnAction(action -> {

            try {
                abrirTelaDePesquisa(palco);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }


    private void abrirTelaDePesquisa(Stage palco) throws Exception {
        TelaPesquisa pesquisa = new TelaPesquisa();
        pesquisa.start(palco);
        pesquisa.atualizarGrid();
    }

    public VBox getTela() {
        return this.janela;
    }

    public void iniciaInsercao() {
        this.estadoTela = TelaEstado.INSERINDO;
    }

    public void iniciaAlteracao(AlunoAcademico alunoAcademico) {
        this.entidade = alunoAcademico;
        this.estadoTela = TelaEstado.EDITANDO;
        edtId.textProperty().setValue(alunoAcademico.getId());
        edtNome.textProperty().setValue(alunoAcademico.getNome());
        edtEmail.textProperty().setValue(alunoAcademico.getEmail());
        edtEndereco.textProperty().setValue(alunoAcademico.getEndereco());
        edtCpf.textProperty().setValue(alunoAcademico.getCpf());
        edtSexo.textProperty().setValue(alunoAcademico.getSexo());

    }
}


