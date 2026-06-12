public class Emprestimo {

    private int id;
    private Usuario usuario;
    private Livro livro;
    private boolean ativo;

    public Emprestimo(int id, Usuario usuario, Livro livro) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void devolver() {
        ativo = false;
    }
}