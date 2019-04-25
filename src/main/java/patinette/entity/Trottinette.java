package patinette.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TROTTINETTE")
@Getter @Setter
public class Trottinette implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TROTTINETTE_ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "LAT")
	private Double lat;
	
	@Column(name = "LNG")
	private Double lng;
	
	@Column(name = "B_AVAILABLE")
	private boolean bAvailable;
	
}