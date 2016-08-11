package training.bootcamp.expensesplitter.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="ES_GROUPS")
public class Group {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GROUP_ID")
	private long id;
	
	@Column(name="GROUP_NAME")
	@NotNull
	private String gorupName;
	
	@Column(name= "CREATED_DATE")
	private Timestamp createdDate;
	
	@Column(name= "CREATED_BY")
	private String createdBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGorupName() {
		return gorupName;
	}

	public void setGorupName(String gorupName) {
		this.gorupName = gorupName;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
