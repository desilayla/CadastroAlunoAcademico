package sample.DAO;

import sample.Aluno.AlunoAcademico;
import sample.Banco.BancodeDados;
import java.util.List;
import java.util.function.Consumer;

public class AlunoDao {

    private BancodeDados banco = BancodeDados.getInstance();

    public void salvar(AlunoAcademico alunoAcademico) {

        banco.tbAluno.add(alunoAcademico);
        System.out.println("salvando pessoa: " + alunoAcademico);
    }

    public AlunoAcademico pesquisaPorId(String chave) {

        List<AlunoAcademico> alunos = banco.tbAluno;

        for (AlunoAcademico aluno : alunos) {
            if (aluno.getId().equals(chave)) {
                return aluno;
            }
        }

        return null;
    }

    public void remover(AlunoAcademico alunoAcademico) {
        banco.tbAluno.remove(alunoAcademico);
    }

    public void alterarAluno(AlunoAcademico alunoSelecionado) {

        banco.tbAluno.stream().forEach(new Consumer<AlunoAcademico>() {


            public void accept(AlunoAcademico alunoAcademico) {
                if (alunoAcademico.getId().equals(alunoSelecionado.getId())) {
                    alunoAcademico.setNome(alunoSelecionado.getNome());
                    alunoAcademico.setEmail(alunoSelecionado.getEmail());
                    alunoAcademico.setEndereco(alunoSelecionado.getEndereco());
                    alunoAcademico.setCpf(alunoSelecionado .getCpf());
                    alunoAcademico.setSexo(alunoSelecionado.getSexo());

                }
            }
        });

    }
}
