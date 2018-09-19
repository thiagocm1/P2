package prova1;

public class Pokemon {
	private String nome;
	private int nivel;
	private int ataqueBase;
	private String tipo;
	private Pokemon pokemon;
	
	public Pokemon(String nomePokemon, int nivel, String tipoPokemon, int ataqueBase) throws Exception{
		if(nomePokemon == null || nomePokemon.equals("")){
			throw new Exception("O nome do Pokémon não pode ser nulo ou vazio");
		}
		if(nivel < 1){
			throw new Exception("O nível do Pokémon não pode ser menor que 1");
		}
		if(ataqueBase < 0){
			throw new Exception("O poder de ataque do Pokémon não pode ser menor que 0");
		}
		if(tipo != "Agua" || tipo != "Fogo" || tipo != "Eletrico" || tipo != "Grama" || tipo != "Gelo" || tipo != "Dragão" || tipo != "Fantasma" || tipo != "Psiquico"){
			throw new Exception("Sao permitidos apenas: Agua, Fogo, Eletrico, Grama, Gelo, Dragao, Fantasma e Psiquico.");
		}
		this.nome = nomePokemon;
		this.nivel = nivel;
		this.tipo = tipoPokemon;
		this.ataqueBase = ataqueBase;
		pokemon = new Pokemon(nome, nivel, tipo, ataqueBase);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getAtaqueBase() {
		return ataqueBase;
	}

	public void setAtaqueBase(int ataqueBase) {
		this.ataqueBase = ataqueBase;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	
}
