import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {

        for (Livro l : livros) {
            if (l.getIsbn().equals(livro.getIsbn())) {
                System.out.println("ISBN já cadastrado!");
                return;
            }
        }

        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso.");
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarEmprestimo(int idUsuario, int idLivro) {

        Usuario usuario = null;
        Livro livro = null;

        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) {
                usuario = u;
            }
        }

        for (Livro l : livros) {
            if (l.getId() == idLivro) {
                livro = l;
            }
        }

        if (usuario == null || livro == null) {
            System.out.println("Usuário ou livro não encontrado.");
            return;
        }

        if (livro.getQuantidade() <= 0) {
            System.out.println("Livro indisponível.");
            return;
        }

        for (Emprestimo e : emprestimos) {
            if (e.isAtivo()
                    && e.getUsuario().getId() == idUsuario
                    && e.getLivro().getId() == idLivro) {

                System.out.println("Usuário já possui esse livro.");
                return;
            }
        }

        livro.setQuantidade(livro.getQuantidade() - 1);

        Emprestimo emprestimo =
                new Emprestimo(
                        emprestimos.size() + 1,
                        usuario,
                        livro);

        emprestimos.add(emprestimo);

        System.out.println("Empréstimo realizado.");
    }

    public void devolverLivro(int idEmprestimo) {

        for (Emprestimo e : emprestimos) {

            if (e.getId() == idEmprestimo && e.isAtivo()) {

                e.devolver();

                Livro livro = e.getLivro();

                livro.setQuantidade(
                        livro.getQuantidade() + 1);

                System.out.println("Livro devolvido.");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado.");
    }

    public void listarLivros() {

        for (Livro livro : livros) {

            System.out.println(
                    livro.getId() + " - "
                            + livro.getTitulo()
                            + " | Estoque: "
                            + livro.getQuantidade());
        }
    }
}