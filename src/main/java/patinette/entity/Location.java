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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LOCATION")
@Getter @Setter
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID", nullable = false, unique = true)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TROTTINETTE_ID")
	private Trottinette trottinette;
	
	@Column(name = "DATE_RESERVATION")
	private LocalDateTime dateReservation;
	
	@Column(name = "DATE_RENDU")
	private LocalDateTime dateRendu;
	
	@Column(name = "B_RUNNING")
	private boolean bRunning;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "B_PAID")
	private boolean bPaid;

}
