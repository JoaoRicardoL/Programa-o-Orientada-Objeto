public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Usuario usuario =
                new Usuario(1, "João");

        biblioteca.cadastrarUsuario(usuario);

        Livro livro1 =
                new Livro(
                        1,
                        "Java Básico",
                        "Carlos Silva",
                        "123456",
                        3);

        Livro livro2 =
                new Livro(
                        2,
                        "POO em Java",
                        "Maria Souza",
                        "654321",
                        2);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);

        biblioteca.listarLivros();

        biblioteca.realizarEmprestimo(1, 1);

        biblioteca.listarLivros();

        biblioteca.devolverLivro(1);

        biblioteca.listarLivros();
    }
}