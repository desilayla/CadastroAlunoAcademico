package sample.RegraNegocio;

import sample.Aluno.AlunoAcademico;
import sample.DAO.AlunoDao;


public class Regra {

    private AlunoDao dao = new AlunoDao();

    public void addNovoAluno(String Id, String Nome, String Email, String Endereco,String Cpf, String Sexo) {


        AlunoAcademico alunoAcademico = new AlunoAcademico();
        alunoAcademico.setId(Id);
        alunoAcademico.setNome(Nome);
        alunoAcademico.setEmail(Email);
        alunoAcademico.setEndereco(Endereco);
        alunoAcademico.setCpf(Cpf);
        alunoAcademico.setSexo(Sexo);


        dao.salvar(alunoAcademico);

    }

    public AlunoAcademico pesquisaPorId(String chave) throws Exception {
        String nova = chave.trim();

        if (nova == null || nova.equals("")) {
            throw new Exception("Pesquisa Nula.");
        } else {
            return dao.pesquisaPorId(chave);
        }

    }

    public void excluirPessoa(AlunoAcademico alunoAcademico) {
        dao.remover(alunoAcademico);
    }

    public void alterarPessoa(AlunoAcademico alunoAcademico) {
        dao.alterarAluno(alunoAcademico);
    }
}

