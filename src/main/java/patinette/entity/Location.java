package patinette.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LOCATION")
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID", nullable = false, unique = true)
	private Long id;

	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "TROTTINETTE_ID")
	private Trottinette trottinette;

	@Getter @Setter
	@Column(name = "DATE_RESERVATION")
	private LocalDateTime dateReservation;

	@Transient
	private String dateResaString;

	@Getter @Setter
	@Column(name = "DATE_RENDU")
	private LocalDateTime dateRendu;

	@Transient
	private String dateRenduString;

	@Getter @Setter
	@Column(name = "B_RUNNING")
	private boolean bRunning;

	@Getter @Setter
	@Column(name = "PRICE")
	private Double price;

	@Getter @Setter
	@Column(name = "B_PAID")
	private boolean bPaid;

	public String getDateResaString() {
		if (dateReservation == null) return "";
		return dateReservation.toString();
	}

	public void setDateResaString(String dateResa) {
		this.dateResaString = dateResa;
	}

	public String getDateRenduString() {
		if (dateRendu == null) return "";
		return dateRendu.toString();
	}

	public void setDateRenduString(String dateRenduString) {
		this.dateRenduString = dateRenduString;
	}

}
