//Integrantes: Isis Macedo e Andrade RM 561497, Theodoro Spinola Furtado RM 566019, Ana Clara de Oliveira Nascimento RM 561957, Anabelle Rosseto Rodrigues RM 564526

package br.com.fiap.bean;

import java.io.IOException;

/**
 * Interface que define um contrato para classes que gerenciam a persistência de dados.
 * O objetivo é fornecer métodos padrão para ler e gravar informações de um objeto
 * do tipo DragonBallSuper
 */
public interface IDBSuper {

    /**
     * Lê os dados de um arquivo e retorna um objeto DragonBallSuper populado.
     * <p>
     * O metodo é responsável por localizar o arquivo com base no caminho fornecido,
     * ler seu conteúdo e converter as informações para preencher os atributos de
     * um objeto.
     *
     * @param path O caminho do diretório onde o arquivo de dados está localizado.
     * @return Um objeto DragonBallSuper com os dados lidos do arquivo.
     * @throws IOException Se ocorrer um erro de I/O durante a operação de leitura,
     * como o arquivo não ser encontrado.
     */
    DragonBallSuper ler(String path) throws IOException;

    /**
     * Salva os dados de um objeto DragonBallSuper em um arquivo.
     * <p>
     * O metodo deve criar ou sobrescrever um arquivo no caminho especificado
     * e escrever os atributos do objeto, retornando uma mensagem de status
     * sobre o sucesso ou falha da operação.
     *
     * @param path O caminho do diretório onde o arquivo de dados será salvo.
     * @return Uma String indicando se a operação de gravação foi bem-sucedida
     * ou se falhou, incluindo a mensagem de erro.
     */
    String gravar(String path);
}