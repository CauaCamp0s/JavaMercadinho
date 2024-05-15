import java.sql.*;
import java.util.Scanner;

public class SistemaCadastrobd {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do MySQL não encontrado.");
            e.printStackTrace();
        }
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mercadinhoJava";
    private static final String JDBC_USER = "caua";
    private static final String JDBC_PASSWORD = "140610";

    // Método para cadastrar um produto no banco de dados
    public void cadastrarProduto(String nome, double preco, int quantidade) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            System.out.println("Conectado ao banco de dados.");
            String sql = "INSERT INTO produto (nome, preco, quantidade) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nome);
                statement.setDouble(2, preco);
                statement.setInt(3, quantidade);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Produto cadastrado com sucesso.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    // Método para listar todos os produtos cadastrados
    public void listarProdutos() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            System.out.println("Conectado ao banco de dados.");
            String sql = "SELECT * FROM produto";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                System.out.println("Lista de Produtos:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    double preco = resultSet.getDouble("preco");
                    int quantidade = resultSet.getInt("quantidade");
                    System.out.println(id + " - " + nome + " - R$" + preco + " - Quantidade: " + quantidade);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
    }

    // Método para atualizar um produto no banco de dados
    public void atualizarProduto(int id, String nome, double preco, int quantidade) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            System.out.println("Conectado ao banco de dados.");
            String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nome);
                statement.setDouble(2, preco);
                statement.setInt(3, quantidade);
                statement.setInt(4, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Produto atualizado com sucesso.");
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // Método para excluir um produto no banco de dados
    public void excluirProduto(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            System.out.println("Conectado ao banco de dados.");
            String sql = "DELETE FROM produto WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Produto excluído com sucesso.");
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SistemaCadastrobd sistema = new SistemaCadastrobd();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Excluir Produto");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    String precoStr = scanner.nextLine();
                    double preco = Double.parseDouble(precoStr.replace(",", "."));
                    System.out.print("Digite a quantidade do produto: ");
                    int quantidade = scanner.nextInt();
                    sistema.cadastrarProduto(nome, preco, quantidade);
                    break;
                case 2:
                    sistema.listarProdutos();
                    break;
                case 3:
                    System.out.print("Digite o ID do produto a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Digite o novo nome do produto: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo preço do produto: ");
                    String novoPrecoStr = scanner.nextLine();
                    double novoPreco = Double.parseDouble(novoPrecoStr.replace(",", "."));
                    System.out.print("Digite a nova quantidade do produto: ");
                    int novaQuantidade = scanner.nextInt();
                    sistema.atualizarProduto(idAtualizar, novoNome, novoPreco, novaQuantidade);
                    break;
                case 4:
                    System.out.print("Digite o ID do produto a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    sistema.excluirProduto(idExcluir);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
