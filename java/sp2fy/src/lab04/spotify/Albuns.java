package lab04.spotify;
import java.util.ArrayList;

public class Album{

    private String artista, tituloAlbum;
    private int ano;
    private boolean favorito;
    private ArrayList <Musica> musicas;
    private int duracaoTotal = 0;
   
    public Album(String artista, String tituloAlbum, int ano) throws Exception {
        this(artista, tituloAlbum, ano, false);
        musicas = new ArrayList();
       
    }

    public Album(String artista, String tituloAlbum, int ano, boolean favorito) throws Exception {
        if (tituloAlbum == null || tituloAlbum.trim().isEmpty()) {
            throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
        }
        if (artista == null || artista.trim().isEmpty()) {
            throw new Exception("Artista do album nao pode ser nulo ou vazio.");
        }
        if (ano <= 1900) {
            throw new Exception("Ano de lancamento nao pode ser igual ou inferior a 1900.");
        }
       
        musicas = new ArrayList();
        this.tituloAlbum = tituloAlbum;
        this.artista = artista;
        this.ano = ano;
        this.favorito = favorito;
    }

    // GET TITULO
    public String getTitulo() {
        return this.tituloAlbum;
    }

    // SET TITULO
    public void setTitulo(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    // ADICIONAR MUSICA
    public boolean addMusica(String titulo, int duracao, String genero)throws Exception {
       
        Musica musica = new Musica (titulo, duracao, genero);
        if (!musicas.contains(musica)) {
            this.musicas.add(musica);
            this.duracaoTotal += duracao;
            return true;
        }
        return false;
    }

    // REMOVER MUSICA
    public boolean removeMusica(String titulo) {
        for (Musica nome : musicas) {
            if (nome.getTitulo().equalsIgnoreCase(titulo)) {
                this.duracaoTotal -= nome.getDuracao();
                this.musicas.remove(nome);
                return true;
            }
        }
        return false;
    }

    // GET DURACAO
    public int getDuracao() {
        return duracaoTotal;
    }
    // GET MUSICA
    public Musica getMusica(int faixa){
        return musicas.get(faixa-1);
    }
   
    @Override
    public String toString() {
        return "Artista: " + this.artista +" - "+ "Titulo:" +" "+ this.tituloAlbum +" - "+ "Ano: " +this.ano;
    }

        // GET MUSICA
        public Musica getMusica(String titulo){
            for( Musica musica:musicas){
                if(musica.getTitulo().equalsIgnoreCase(titulo)){
                    return musica;
                }
            }return null;
    }
       
    // GET ARTISTA
    public String getArtista() {
        return this.artista;
    }
   
    // SET ARTISTA
    public void setArtirta(String artista) {
        this.artista = artista;
    }

    // É FAVORITO
    public boolean isFavorito() {
        return this.favorito;
    }

    // GET FAVORITO
    public boolean getFavorito() {
        return this.favorito;
    }

    // SET FAVORITO
    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

   
    public boolean equals(Object outroAlbum) {
        if (outroAlbum instanceof Album) {
            Album novoAlbum = (Album) outroAlbum ;
            if (this.tituloAlbum.equalsIgnoreCase(novoAlbum.getTitulo()) && this.artista.equalsIgnoreCase(novoAlbum.getArtista())) {
                return true;
            }
        } return false;
       
    }
}