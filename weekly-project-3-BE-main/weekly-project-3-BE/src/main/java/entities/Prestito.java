package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prestati")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "ricercaTessera", query = "SELECT p FROM Prestito p WHERE p.restituzioneeffettiva IS NULL AND p.utente_id = :utente_id")
@NamedQuery(name = "ricercaPrestitiScaduti", query = "SELECT p FROM Prestito p WHERE p.restituzioneeffettiva IS NULL AND p.restituzioneprevista < CURRENT_DATE ")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int utente_id;
	private String prestato;
	private LocalDate inizioprestito;
	private LocalDate restituzioneprevista;
	private LocalDate restituzioneeffettiva;
	
	@Override
	public String toString() {
		return"Numero tessera: " + this.utente_id + " | Titolo: " + this.prestato + " | inizio prestito: " + this.inizioprestito + " | restituzione prevista: " + this.restituzioneprevista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUtente_id() {
		return utente_id;
	}

	public void setUtente_id(int utente_id) {
		this.utente_id = utente_id;
	}

	public String getPrestato() {
		return prestato;
	}

	public void setPrestato(String prestato) {
		this.prestato = prestato;
	}

	public LocalDate getInizioprestito() {
		return inizioprestito;
	}

	public void setInizioprestito(LocalDate inizioprestito) {
		this.inizioprestito = inizioprestito;
	}

	public LocalDate getRestituzioneprevista() {
		return restituzioneprevista;
	}

	public void setRestituzioneprevista(LocalDate restituzioneprevista) {
		this.restituzioneprevista = restituzioneprevista;
	}

	public LocalDate getRestituzioneeffettiva() {
		return restituzioneeffettiva;
	}

	public void setRestituzioneeffettiva(LocalDate restituzioneeffettiva) {
		this.restituzioneeffettiva = restituzioneeffettiva;
	}
	
	

}
