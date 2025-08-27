//Integrantes: Isis Macedo e Andrade RM 561497, Theodoro Spinola Furtado RM 566019, Ana Clara de Oliveira Nascimento RM 561957, Anabelle Rosseto Rodrigues RM 564526

package br.com.fiap.main;

import br.com.fiap.bean.DragonBallSuper;

import javax.swing.*;
import java.io.IOException;

public class UsaDBSuper {
    public static void main(String[] args) {
        String nome;
        int esfera, ki, tecnicas, velocidade, transformacoes;
        do
        {

            try{
                //Faz Pergunta ao usuário o que ele quer fazer. 1 consulta, 2 cria um personagem DBS.
                String opcao = JOptionPane.showInputDialog(null, "Digite sua opção: \n1 = consultar personagem;\n2 = cadastrar personagem","Programa Dragon Ball Super", JOptionPane.PLAIN_MESSAGE);

                //Transorma a opção em int.
                int opcaoInt = Integer.parseInt(opcao);

                //pede o caminho do arquivo, esteja ele criado ou não. Se criado estiver criado, ele vai criar a pasta.
                String path = JOptionPane.showInputDialog("Digite o caminho (path) do arquivo desejado.");

                //instancia um dbs.
                DragonBallSuper dbs = new DragonBallSuper();

                switch (opcaoInt){
                    case 1:
                        nome = JOptionPane.showInputDialog("Informe o nome do personagem");

                        dbs.setNome(nome);

                        dbs = dbs.ler(path);
                        if (dbs == null)
                        {
                            JOptionPane.showMessageDialog(null, "Caminho inválido ou inexistente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            String mensagem = String.format
                                    (
                                            """
                                                    caminho: %s
                                                    Esfera: No.%d
                                                    ki: %d
                                                    técnicas: %d
                                                    velocidade: %d
                                                    transformações: %d""",
                                            path,
                                            dbs.getEsfera(),
                                            dbs.getKi(),
                                            dbs.getTecnicas(),
                                            dbs.getVelocidade(),
                                            dbs.getTransformacoes()
                                            );

                            JOptionPane.showMessageDialog(null,mensagem, "Informações de " + dbs.getNome() + ".txt", JOptionPane.INFORMATION_MESSAGE);
                        }


                        break;

                    case 2:

                        nome = JOptionPane.showInputDialog("Informe o nome do personagem");
                        esfera = Integer.parseInt(JOptionPane.showInputDialog("informe o número da esfera"));
                        ki = Integer.parseInt(JOptionPane.showInputDialog("informe o ki de " + nome));
                        tecnicas = Integer.parseInt(JOptionPane.showInputDialog("informe o número de técnicas de " + nome));
                        velocidade = Integer.parseInt(JOptionPane.showInputDialog("informe a velocidade de " + nome));
                        transformacoes = Integer.parseInt(JOptionPane.showInputDialog("informe o número de transoformações de " + nome));

                        dbs.setNome(nome);
                        dbs.setEsfera(esfera);
                        dbs.setKi(ki);
                        dbs.setTecnicas(tecnicas);
                        dbs.setVelocidade(velocidade);
                        dbs.setTransformacoes(transformacoes);

                        JOptionPane.showMessageDialog(null, dbs.gravar(path));

                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
            }

        }
        while (JOptionPane.showConfirmDialog(null, "Deseja continuar com o programa?", "Fim do programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Até a próxima!", "FIM DO PROGRAMA", JOptionPane.PLAIN_MESSAGE);



    }
}
