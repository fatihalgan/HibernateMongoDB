package hogm.hnapi.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="jta")
public class LuckyNumberEntity implements Serializable {

	private static final long serialVersionUID = -7851483251937163600L;
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;

	@Column(name="luckynumber", nullable=false)
	private int luckyNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLuckyNumber() {
		return luckyNumber;
	}

	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}
	
	
	
	
}
