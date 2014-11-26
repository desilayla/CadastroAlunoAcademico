package sample.Banco;

import sample.Aluno.AlunoAcademico;
import java.util.ArrayList;
import java.util.List;



public class BancodeDados {


        public List<AlunoAcademico> tbAluno = new ArrayList<AlunoAcademico>();

        private static BancodeDados bancoDeDadosEmMemoria;


        private BancodeDados() {
                tbAluno.add(new AlunoAcademico("01", "Bia", "bia@gmail.com" , "Rua Tupi" , "12334566788", "Feminino"));
                tbAluno.add(new AlunoAcademico("02", "Ana", "Ana@yahoo.com" , "Rua Azul" , "12334355688", "Feminino"));
                tbAluno.add(new AlunoAcademico("03", "José", "Jose@gmail.com" , "Rua " , "287837266788", "Masculino"));
        }


        public static BancodeDados getInstance() {

                if (bancoDeDadosEmMemoria == null) {
                        bancoDeDadosEmMemoria = new BancodeDados();
                }

                return bancoDeDadosEmMemoria;
        }

}
