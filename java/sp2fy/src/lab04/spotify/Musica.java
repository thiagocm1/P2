package lab04;

public class Musica {
	public String Titulo, Genero;
	
	public int Duracao;
	// É Informado o nome da música(Título), duração (tempo da música) e o Gênero (exemplo: pop, rock)
	public Musica(String Titulo, int Duracao, String Genero) throws Exception{
		/*Verifica se o Título da música é vazio ou está em branco, se for verdade é lançada
		 * uma exceção.
		 */
		if (Titulo == null || Titulo.equals("")){
		throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}
		/* Verifica se duração da música é negativa ou inexistente, caso for
		 * verdade é lançada a exceção.
		 */
		if (Duracao <=0){
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}
		/*Verifica se possui um gênero, caso não possua é lançada
		 * a exceção
		 */
		if (Genero == null || Genero.equals("")){
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
		
		
		this.Titulo = Titulo;
			
		this.Duracao = Duracao;
		
		this.Genero = Genero;
		
	}
	
	public String getTitulo(){
		return this.Titulo;
	}
	
	public int getDuracao(){
		return this.Duracao;
	}
	
	public String getGenero(){
		return this.Genero;
	}
	
	public void setDuracao(){
		this.Duracao = Duracao;
	}
	
	public String setTitulo(){
		return this.Titulo = Titulo;
	}
	
	public String setGenero(){
		return this.Genero = Genero;
	}
	
	@Override
	public String toString(){
		return "Musica: " + Titulo + "Duração:  " + Duracao + "Gênero: " + Genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Duracao;
		result = prime * result + ((Genero == null) ? 0 : Genero.hashCode());
		result = prime * result + ((Titulo == null) ? 0 : Titulo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Musica)){
			Musica novaMusica = (Musica) obj;
			if (this.Titulo.equalsIgnoreCase(novaMusica.getTitulo())){
				return true;
			}
		}return false;		
	}


}
