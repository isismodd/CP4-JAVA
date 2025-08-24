//Integrantes: Isis Macedo e Andrade RM 561497, Theodoro Spinola Furtado RM 566019, Ana Clara de Oliveira Nascimento RM 561957, Anabelle Rosseto Rodrigues RM 564526

package br.com.fiap.bean;

import java.io.*;

/**
 * Representa um personagem do universo de Dragon Ball Super com seus atributos.
 * Esta classe implementa a interface IDBSuper, permitindo que os dados
 * do personagem sejam lidos de e gravados em um arquivo de texto.
 * O formato do arquivo é uma linha por atributo: nome, ki, tecnicas,
 * velocidade e transformacoes, nessa ordem.
 */

public class DragonBallSuper implements IDBSuper {

    /**
     * O nome do personagem (ex: "Goku", "Vegeta").
     */
    private String nome;

    /**
     * O nível de Ki (energia de combate) do personagem.
     */
    private int ki;

    /**
     * O número de técnicas especiais que o personagem possui.
     */
    private int tecnicas;

    /**
     * O nível de velocidade do personagem.
     */
    private int velocidade;

    /**
     * O número de transformações que o personagem pode realizar.
     */
    private int transformacoes;

    /**
     * Construtor padrão da classe DragonBallSuper.
     * Cria uma nova instância da classe sem inicializar seus atributos.
     */
    public DragonBallSuper() {
    }

    /**
     * Retorna o nome do personagem.
     *
     * @return O nome do personagem como uma string
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do personagem.
     *
     * @param nome O nome a ser atribuído ao personagem.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nível de Ki do personagem.
     *
     * @return O nível de Ki como um valor inteiro.
     */
    public int getKi() {
        return ki;
    }

    /**
     * Define o nível de Ki do personagem.
     *
     * @param ki O valor do Ki a ser atribuído.
     */
    public void setKi(int ki) {
        this.ki = ki;
    }

    /**
     * Retorna o número de técnicas do personagem.
     *
     * @return O número de técnicas como um valor inteiro.
     */
    public int getTecnicas() {
        return tecnicas;
    }

    /**
     * Define o número de técnicas do personagem.
     *
     * @param tecnicas O número de técnicas a ser atribuído.
     */
    public void setTecnicas(int tecnicas) {
        this.tecnicas = tecnicas;
    }

    /**
     * Retorna o nível de velocidade do personagem.
     *
     * @return O nível de velocidade como um valor inteiro.
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     * Define o nível de velocidade do personagem.
     *
     * @param velocidade O nível de velocidade a ser atribuído.
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Retorna o número de transformações do personagem.
     *
     * @return O número de transformações como um valor inteiro.
     */
    public int getTransformacoes() {
        return transformacoes;
    }

    /**
     * Define o número de transformações do personagem.
     *
     * @param transformacoes O número de transformações a ser atribuído.
     */
    public void setTransformacoes(int transformacoes) {
        this.transformacoes = transformacoes;
    }

    /**
     * Lê os dados do personagem de um arquivo de texto e popula o objeto atual.
     * O nome do arquivo é inferido do atributo 'nome' da própria classe.
     *
     * @param path O caminho do diretório onde o arquivo do personagem está localizado.
     * @return O próprio objeto DragonBallSuper com os dados carregados do arquivo.
     * @throws IOException Se ocorrer um erro durante a leitura do arquivo (ex: arquivo não encontrado).
     */
    @Override
    public DragonBallSuper ler(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path + "/" + nome + ".txt"))) {
            this.nome = br.readLine();
            this.ki = Integer.parseInt(br.readLine());
            this.tecnicas = Integer.parseInt(br.readLine());
            this.velocidade = Integer.parseInt(br.readLine());
            this.transformacoes = Integer.parseInt(br.readLine());
            return this;
        }
    }

    /**
     * Salva os atributos do objeto DragonBallSuper em um arquivo de texto.
     * Cria o diretório caso não exista. O nome do arquivo é baseado no atributo 'nome' do personagem.
     *
     * @param path O caminho do diretório onde o arquivo será salvo.
     * @return Uma mensagem indicando o sucesso ou falha da operação de gravação.
     */

    @Override
    public String gravar(String path) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdir();
            }
            try (PrintWriter pw = new PrintWriter(new FileWriter(path + "/" + nome + ".txt"))) {
                pw.println(nome);
                pw.println(ki);
                pw.println(tecnicas);
                pw.println(velocidade);
                pw.println(transformacoes);
            }
            return "Arquivo gravado com sucesso";
        } catch (IOException e) {
            return "Falha ao gravar arquivo: " + e.getMessage();
        }
    }
}