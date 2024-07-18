package qltb.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="doibong")
public class DoiBong {
	@Id
	@Column(name = "id")
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	public DoiBong(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public DoiBong() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
